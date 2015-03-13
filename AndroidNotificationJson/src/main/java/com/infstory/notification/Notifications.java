package com.infstory.notification;

import android.app.Notification;
import android.content.Context;

import com.bluelinelabs.logansquare.LoganSquare;
import com.infstory.notification.debug.Debugger;
import com.infstory.notification.model.AndroidNotificationJsonModel;

import org.json.JSONObject;
import org.json.JSONException;

public class Notifications {
    private static final String ANDROID = "android";
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

    public Notification build(String json) {
        try {
            return build(new JSONObject(json));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Notification build(JSONObject jsonObject) {
        Notification notification = null;

        try {
            // There's a TypeConverter mechanism can be used, however, it cannot pass parameters.
            // I need to pass parameters for building the instance so just do this by build() method
            // in each model itself.
            android.util.Log.d(TAG, "Notifications: run");
            android.util.Log.d(TAG, "Notifications: jsonObject: " + jsonObject);
            if (jsonObject.has(ANDROID)) {
                notification = LoganSquare
                        .parse(jsonObject.get(ANDROID).toString(), AndroidNotificationJsonModel.class)
                        .build(jsonObject.get(ANDROID), mContext);
            }
            android.util.Log.d(TAG, "Notifications: bye");
        } catch (Exception e) {
            android.util.Log.d(TAG, "Exception: ", e);
            mDebugger.logT(TAG, e);
        }

        return notification;
    }
}
