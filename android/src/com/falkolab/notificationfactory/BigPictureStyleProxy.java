package com.falkolab.notificationfactory;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.TiC;
import org.appcelerator.titanium.util.TiConvert;
import org.appcelerator.titanium.util.TiUIHelper;
import org.appcelerator.titanium.view.TiDrawableReference;

import ti.modules.titanium.filesystem.FileProxy;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat.BigPictureStyle;

@Kroll.proxy(creatableInModule=NotificationfactoryModule.class, propertyAccessors = {
	TiC.PROPERTY_DECODE_RETRIES
})
public class BigPictureStyleProxy extends StyleProxy {
	
	private static final String TAG = "TiNotificationBigPictureStyleProxy";
	
	public BigPictureStyleProxy() {
		super();
		style = new BigPictureStyle();
	}
	
	@Override
	public void handleCreationDict(KrollDict d)
	{
		super.handleCreationDict(d);
		if (d == null) {
			return;
		}
		
		if (d.containsKey(NotificationfactoryModule.PROPERTY_BIG_LARGE_ICON)) {
			setBigLargeIcon(d.get(NotificationfactoryModule.PROPERTY_BIG_LARGE_ICON));
		}
		
		if (d.containsKey(NotificationfactoryModule.PROPERTY_BIG_PICTURE)) {
			setBigPicture(d.get(NotificationfactoryModule.PROPERTY_BIG_PICTURE));
		}
		
		if (d.containsKey(NotificationfactoryModule.PROPERTY_BIG_CONTENT_TITLE)) {
			setBigContentTitle(TiConvert.toString(d.get(NotificationfactoryModule.PROPERTY_BIG_CONTENT_TITLE)));
		}
		
		if (d.containsKey(NotificationfactoryModule.PROPERTY_SUMMARY_TEXT)) {
			setSummaryText(TiConvert.toString(d.get(NotificationfactoryModule.PROPERTY_SUMMARY_TEXT)));
		}
	}
	
	private TiDrawableReference makeImageSource(Object object)
	{
		if (object instanceof FileProxy) {
			return TiDrawableReference.fromFile(this.getActivity(), ((FileProxy) object).getBaseFile());
		} else if (object instanceof String) {
			return TiDrawableReference.fromUrl(this, (String) object);
		} else {
			return TiDrawableReference.fromObject(this.getActivity(), object);
		}
	}
	
	@Kroll.method @Kroll.setProperty
	public void setBigLargeIcon(Object b) {
		if(b instanceof Number) {
			Bitmap bigLargeIcon = BitmapFactory.decodeResource(TiApplication.getInstance().getResources(), ((Number)b).intValue());
			((BigPictureStyle)style).bigLargeIcon(bigLargeIcon);
		} else {
			String iconUrl = TiConvert.toString(b);
			if (iconUrl == null) {
				Log.e(TAG, "Url is null");
				return;
			}
			String iconFullUrl = resolveUrl(null, iconUrl);
			Bitmap bigLargeIcon = BitmapFactory.decodeResource(TiApplication.getInstance().getResources(), TiUIHelper.getResourceId(iconFullUrl));
			((BigPictureStyle)style).bigLargeIcon(bigLargeIcon);
		}		
		
		setProperty(NotificationfactoryModule.PROPERTY_BIG_LARGE_ICON, b);		
	}
	
//	@Kroll.method @Kroll.setProperty
//	public void setBigPicture(Object b) {
//		if(b instanceof Number) {
//			Bitmap bigPicture = BitmapFactory.decodeResource(TiApplication.getInstance().getResources(), ((Number)b).intValue());
//			((BigPictureStyle)style).bigPicture(bigPicture);
//		} else {
//			String pictureUrl = TiConvert.toString(b);
//			if (pictureUrl == null) {
//				Log.e(TAG, "Url is null");
//				return;
//			}
//			String pictureFullUrl = resolveUrl(null, pictureUrl);
//			Bitmap bigPicture = BitmapFactory.decodeResource(TiApplication.getInstance().getResources(), TiUIHelper.getResourceId(pictureFullUrl));
//			((BigPictureStyle)style).bigPicture(bigPicture);
//		}		
//		
//		setProperty(NotificationfactoryModule.PROPERTY_BIG_PICTURE, b);
//	}
	
	@Kroll.method @Kroll.setProperty
	public void setBigPicture(Object picture)
	{
		TiDrawableReference source = makeImageSource(picture);

		// Check for decodeRetries
		if (hasProperty(TiC.PROPERTY_DECODE_RETRIES)) {
			source.setDecodeRetries(TiConvert.toInt(getProperty(TiC.PROPERTY_DECODE_RETRIES), TiDrawableReference.DEFAULT_DECODE_RETRIES));
		}

		((BigPictureStyle)style).bigPicture(source.getBitmap());

		setProperty(NotificationfactoryModule.PROPERTY_BIG_PICTURE, picture);
	}
	
	@Kroll.method @Kroll.setProperty
	public void setBigContentTitle(String title) {		
		((BigPictureStyle)style).setBigContentTitle(title);	
		setProperty(NotificationfactoryModule.PROPERTY_BIG_CONTENT_TITLE, title);
	}
	
	@Kroll.method @Kroll.setProperty
	public void setSummaryText(String cs) {	
		((BigPictureStyle)style).setSummaryText(cs);
		setProperty(NotificationfactoryModule.PROPERTY_SUMMARY_TEXT, cs);
	}	
}
