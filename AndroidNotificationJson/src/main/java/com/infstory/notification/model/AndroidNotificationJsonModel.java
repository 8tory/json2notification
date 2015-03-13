package com.infstory.notification.model;

import android.app.Notification;
import android.content.Context;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.bluelinelabs.logansquare.annotation.OnJsonParseComplete;
import com.bluelinelabs.logansquare.annotation.OnPreJsonSerialize;
import com.infstory.notification.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;

@Keep
@KeepClassMembers
@JsonObject
public class AndroidNotificationJsonModel implements ModelBuilder<Notification> {
    private static final String NOTIFICATION = "notification";

    @JsonField(name = NOTIFICATION)
    public NotificationModel notificationModel;

    /*
     * Optional callback method to do something when your
     * object is done parsing.
     */
    @OnJsonParseComplete
    void onParseComplete() {
        // Do some fancy post-processing stuff after parsing here
    }

    /*
     * Optional callback method to do something before your
     * object serializes.
     */
    @OnPreJsonSerialize
    void onPreSerialize() {
        // Do some fancy pre-processing stuff before serializing here
    }

    @Override
    public Notification build(Object... objects) {
        JSONObject jsonObject = (JSONObject) objects[0];
        Context context = (Context) objects[1];

        Notification notification = null;

        if (!Utils.isEmpty(notificationModel)) {
            try {
                JSONObject notificationJson = jsonObject.getJSONObject(NOTIFICATION);
                notification = notificationModel.build(notificationJson, context);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return notification;
    }
}
