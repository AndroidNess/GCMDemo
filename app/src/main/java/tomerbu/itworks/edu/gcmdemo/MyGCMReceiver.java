package tomerbu.itworks.edu.gcmdemo;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.gcm.GcmReceiver;

/**
 * Created by Dev on 05/04/2016.
 */
public class MyGCMReceiver extends GcmReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("ItWorks", intent.toString());
        super.onReceive(context, intent);
    }
}
