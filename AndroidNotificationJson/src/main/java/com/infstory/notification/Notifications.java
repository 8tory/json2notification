package com.infstory.notification;

import android.app.Notification;
import android.content.Context;

import com.bluelinelabs.logansquare.LoganSquare;
import com.infstory.notification.debug.Debug;
import com.infstory.notification.model.AndroidNotificationJsonModel;

import org.json.JSONObject;

public class Notifications {
    private static final String TAG = "Notifications";

    public static Notification from(Context context, JSONObject jsonObject) {
        Debug.sContext = context;
        Notification notification = null;

        try {
            // There's a TypeConverter mechanism can be used, however, it cannot pass parameters.
            // I need to pass parameters for building the instance so just do this by build() method
            // in each model itself.
            notification = LoganSquare.parse(
                    jsonObject.toString(),
                    AndroidNotificationJsonModel.class)
                .build(jsonObject, context);
        } catch (Exception e) {
            Debug.logT(TAG, e);
        }

        return notification;
    }
}
