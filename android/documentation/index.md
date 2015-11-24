# Ti.NotificationFactory Module

![screenshot1](screenshot1.png?raw=true "Example screenshot #1")
![screenshot2](screenshot2.png?raw=true "Example screenshot #2")

## Get it
[![gitTio](http://gitt.io/badge.svg)](http://gitt.io/component/com.falkolab.notificationfactory)

## Description

Android module that add support for style in Ti.AndroidNotification for Titanium SDK.

## Accessing the notificationfactory Module

To access this module from JavaScript, you would do the following:

    var notificationfactory = require("com.falkolab.notificationfactory");

The notificationfactory variable is a reference to the Module object.


## Usage

Big Text Style:

```javascript
var style = Ti.Android.createBigTextStyle({
	bigText: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
	bigContentTitle: "Title for big text",
	summaryText: "Summary for big text"
});
   
// Create big text style the notification
var notification = Ti.Android.createNotification({
	contentTitle: 'Something Happened',
	contentText : 'Click to return to the application.',
	style: style,
	time: Date.now()
});

// Send the notification.
Titanium.Android.NotificationManager.notify(1, notification);
```

Big Picture Style:

For test place [image](http://codeversed.com/androidifysteve.png) to corresponding folder. 
For example `Resources/android/images/res-xhdpi/`

```javascript	
// Create big picture style the notification
var notification = Ti.Android.createNotification({
    contentTitle: 'Something Happened',
    contentText : 'Click to return to the application.',
    style: Ti.Android.createBigPictureStyle({
	   	//bigPicture: "/images/androidifysteve.png",
		//bigPicture: 'http://www.notetab.com/images/More-free-time-thanks-to-NoteTab.jpg',
		bigPicture: Ti.App.Android.R.drawable.androidifysteve,
		bigContentTitle: "Title for big picture",
		summaryText: "Summary for big picture"
	}),
	time: Date.now()
});

// Send the notification.
Titanium.Android.NotificationManager.notify(2, notification);
```


## Author

Andrey Tkachenko aka falkolab
falko.lab@gmail.com

## License

MIT
