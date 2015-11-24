package com.falkolab.notificationfactory;

import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.annotations.Kroll;

import android.support.v4.app.NotificationCompat;

@Kroll.proxy
public class StyleProxy extends KrollProxy {

	protected NotificationCompat.Style style;
	
	public NotificationCompat.Style getStyle() {
		return style;
	}
}
