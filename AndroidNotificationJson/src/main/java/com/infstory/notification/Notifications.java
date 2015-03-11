package com.infstory.notification;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.bluelinelabs.logansquare.annotation.OnJsonParseComplete;
import com.bluelinelabs.logansquare.annotation.OnPreJsonSerialize;
import com.infstory.notification.debug.Debug;

import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;

import org.json.JSONObject;

public class Notifications {
    private static final String TAG = "Notifications";

    public static Notification from(Context context, JSONObject jsonObject) {
        try {
            Debug.sContext = context;
            return LoganSquare.parse(jsonObject.toString(), NotificationModel.class).build(context);
        } catch (Exception e) {
            Debug.logT(TAG, e);
            return null;
        }
    }

    @Keep
    @KeepClassMembers
    @JsonObject
    public static class NotificationModel {

        public Notification build(Context context) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

            if (!Utils.isEmpty(notificationModel)) {
                if (!Utils.isEmpty(notificationModel.autoCancel)) {
                    builder.setAutoCancel(notificationModel.autoCancel);
                }
                if (!Utils.isEmpty(notificationModel.contentTitle)) {
                    builder.setContentText(notificationModel.contentTitle);
                }
                // if (!Utils.isEmpty(notificationModel.deleteIntent)) {
                    // builder.setDeleteIntent(new PendingIntent());
                // }
                // if (!Utils.isEmpty()) {

                // }
                // if (!Utils.isEmpty()) {

                // }
            }

            if (!Utils.isEmpty(dataModel)) {
                Bundle bundle = new Bundle();
                if (!Utils.isEmpty(dataModel.type)) {
                    bundle.putString(DataModel.TYPE, dataModel.type);
                }
                builder.setExtras(bundle);
            }

            return builder.build();
        }

        @Keep
        @KeepClassMembers
        @JsonObject
        public static class AndroidNotificationModel {
            @JsonField
            public String contentTitle;
            @JsonField
            public String deleteIntent;
            @JsonField
            public String smallIcon;
            @JsonField
            public boolean autoCancel;
        }

        @Keep
        @KeepClassMembers
        @JsonObject
        public static class DataModel {
            @JsonField
            public String type;
            public static final String TYPE = "type";
        }
        /*
         * Standard field declaration.
         */
        @JsonField(name = "android")
        public AndroidNotificationModel notificationModel;

        /*
         * Note: passing the name parameter into @JsonField will cause
         * LoganSquare to use "_id" in JSON parsing and processing instead
         * of "imageId".
         */
        @JsonField(name = "data")
        public DataModel dataModel;

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
    }
}
