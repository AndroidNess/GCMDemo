package tomerbu.itworks.edu.gcmdemo;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.gcm.GcmPubSub;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;

/**
 * Created by Dev on 05/04/2016.
 */
public class RegistrationIntentService extends IntentService {
    public RegistrationIntentService() {
        super("Hello, Daddy");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
        InstanceID instanceID = InstanceID.getInstance(this);

        String token = instanceID.getToken(
                getString(R.string.gcm_defaultSenderId),
                GoogleCloudMessaging.INSTANCE_ID_SCOPE,
                null
        );

        sendTokenToServer(token);
        subscribeToTopics(token);
        } catch (IOException e) {
            e.printStackTrace();
        };
    }

    private void subscribeToTopics(String token) throws IOException {
        GcmPubSub pubSub = GcmPubSub.getInstance(this);
        pubSub.subscribe(token, "/topics/global", null);
        pubSub.subscribe(token, "/topics/news", null);
        pubSub.subscribe(token, "/topics/animals", null);

    }

    private void sendTokenToServer(String token) {
        //Send the token to our server... Optional
        Log.d("ITWorks", token);
    }
}
