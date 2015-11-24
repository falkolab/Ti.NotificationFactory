var win = Ti.UI.createWindow({layout:'vertical'});

var btn1 = Ti.UI.createButton({
    title : '1) Add Big Text Notification'
});

btn1.addEventListener('click', function(e) {
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
});

win.add(btn1);

//************************

var btn2 = Ti.UI.createButton({
    title : '2) Add Big Text Notification'
});

btn2.addEventListener('click', function(e) {

	var style = Ti.Android.createBigTextStyle();
	style.setBigText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
	style.setBigContentTitle('big title');
	style.setSummaryText('big summmary');
	   
	// Create big text style the notification
	var notification = Ti.Android.createNotification({
	    contentTitle: 'Something Happened',
	    contentText : 'Click to return to the application.',
	    time: Date.now()
	});
	
	notification.setStyle(style);

    // Send the notification.
    Titanium.Android.NotificationManager.notify(2, notification);
});

win.add(btn2);

//***************************

var btn3 = Ti.UI.createButton({
    title : '3) Add Big Image Notification'
});
   
btn3.addEventListener('click', function(e) {
	// For test: 
	// * Place the image http://codeversed.com/androidifysteve.png to corresponding folder. 
	// * For example: Resources/android/images/res-xhdpi/  
	
		
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
    Titanium.Android.NotificationManager.notify(3, notification);
});

win.add(btn3);
win.open();