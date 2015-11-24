package com.falkolab.notificationfactory;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.util.TiConvert;

import android.support.v4.app.NotificationCompat.BigTextStyle;

@Kroll.proxy(creatableInModule=NotificationfactoryModule.class)
public class BigTextStyleProxy extends StyleProxy {
	
	public BigTextStyleProxy() {
		super();
		style = new BigTextStyle();
	}
	
	@Override
	public void handleCreationDict(KrollDict d)
	{
		super.handleCreationDict(d);
		if (d == null) {
			return;
		}
		
		if (d.containsKey(NotificationfactoryModule.PROPERTY_BIG_TEXT)) {
			setBigText(TiConvert.toString(d.get(NotificationfactoryModule.PROPERTY_BIG_TEXT)));
		}
		
		if (d.containsKey(NotificationfactoryModule.PROPERTY_BIG_CONTENT_TITLE)) {
			setBigContentTitle(TiConvert.toString(d.get(NotificationfactoryModule.PROPERTY_BIG_CONTENT_TITLE)));
		}
		
		if (d.containsKey(NotificationfactoryModule.PROPERTY_SUMMARY_TEXT)) {
			setSummaryText(TiConvert.toString(d.get(NotificationfactoryModule.PROPERTY_SUMMARY_TEXT)));
		}
	}
	
	@Kroll.method @Kroll.setProperty
	public void setBigText(String cs) {
		((BigTextStyle)style).bigText(cs);		
		setProperty(NotificationfactoryModule.PROPERTY_BIG_TEXT, cs);
	}
	
	@Kroll.method @Kroll.setProperty
	public void setBigContentTitle(String title) {		
		((BigTextStyle)style).setBigContentTitle(title);	
		setProperty(NotificationfactoryModule.PROPERTY_BIG_CONTENT_TITLE, title);
	}
	
	@Kroll.method @Kroll.setProperty
	public void setSummaryText(String cs) {	
		((BigTextStyle)style).setSummaryText(cs);
		setProperty(NotificationfactoryModule.PROPERTY_SUMMARY_TEXT, cs);
	}
}
