package tomerbu.itworks.edu.gcmdemo;

import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.google.android.gms.gcm.GcmListenerService;

public class MyGcmListenerService extends GcmListenerService {
    @Override
    public void onMessageReceived(String from, Bundle data) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Title").
                setContentText("Message").
                setSmallIcon(R.mipmap.ic_launcher);

        NotificationManagerCompat.from(this).
                notify(1, builder.build());;
    }
}
