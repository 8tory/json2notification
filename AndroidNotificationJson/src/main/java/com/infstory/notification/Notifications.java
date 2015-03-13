package com.infstory.notification;

import android.app.Notification;
import android.content.Context;

import com.bluelinelabs.logansquare.LoganSquare;
import com.infstory.notification.debug.Debugger;
import com.infstory.notification.model.AndroidNotificationJsonModel;

import org.json.JSONObject;

public class Notifications {
    private static final String TAG = "Notifications";
    private Context mContext;
    private Debugger mDebugger;

    public static Notifications from(Context context) {
        return new Notifications(context);
    }

    private Notifications(Context context) {
        mContext = context;
        mDebugger = new Debugger(context).setTag(TAG);
    }

    public Notification build(JSONObject jsonObject) {
        Notification notification = null;

        try {
            // There's a TypeConverter mechanism can be used, however, it cannot pass parameters.
            // I need to pass parameters for building the instance so just do this by build() method
            // in each model itself.
            notification = LoganSquare.parse(
                    jsonObject.toString(),
                    AndroidNotificationJsonModel.class)
                    .build(jsonObject, mContext);
        } catch (Exception e) {
            mDebugger.logT(TAG, e);
        }

        return notification;
    }
}
