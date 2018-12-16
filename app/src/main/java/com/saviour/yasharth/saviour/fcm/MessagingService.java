package com.saviour.yasharth.saviour.fcm;

import android.content.Intent;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Date;

public class MessagingService extends FirebaseMessagingService {
    private NotificationUtils notificationUtils = new NotificationUtils();

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String sender = remoteMessage.getData().get("senderid");
        Log.d("FCM", "From: " + sender);
        String title = remoteMessage.getData().get("title");
        String message = remoteMessage.getData().get("message");
        SpannableStringBuilder sb = new SpannableStringBuilder(message);
        Intent resultIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
        //Boolean soundOn = true; If you want to have pref about notif sound
        Date date = new Date();
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        notificationUtils.showNotification(getApplicationContext(), title, sb, date, resultIntent);
    }
}
