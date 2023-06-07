package com.shubham.hamlet.Firebase;

import static com.shubham.hamlet.Firebase.App.FCM_CHANNEL_ID;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Color;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.shubham.hamlet.R;

public class FCMMessageReceiverService extends FirebaseMessagingService {
    private static final String TAG = "FCMMessageReceiverServi";
    String title, body;

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);
        Log.d(TAG, "onMessageReceived: Called");
        Log.d(TAG, "onMessageReceived: Message received from " + message.getFrom());
        if (message.getNotification() != null) {
            title = message.getNotification().getTitle();
            body = message.getNotification().getBody();
            Notification notification = new NotificationCompat.Builder(this, FCM_CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle(title)
                    .setContentText(body)
//                    .setColor(Color.BLUE)
                    .build();
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.notify(1002, notification);
        }
        if (message.getData().size() > 0) {
            Log.d(TAG, "onMessageReceived: DATA" + message.getData().toString());
        }
    }

    @Override
    public void onDeletedMessages() {
        super.onDeletedMessages();
        Log.d(TAG, "onDeletedMessages: Called");
    }

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        Log.d(TAG, "onNewToken: Called");
        //upload this token on the app server
    }
}
