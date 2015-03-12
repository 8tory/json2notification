package com.infstory.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.bluelinelabs.logansquare.annotation.OnJsonParseComplete;
import com.bluelinelabs.logansquare.annotation.OnPreJsonSerialize;
import com.infstory.notification.debug.Debug;
import com.nostra13.universalimageloader.core.ImageLoader;

import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;

import org.json.JSONObject;

import java.util.List;

public class Notifications {
    private static final String TAG = "Notifications";

    public static Notification from(Context context, JSONObject jsonObject) {
        try {
            Debug.sContext = context;
            return LoganSquare.parse(jsonObject.toString(), NotificationModel.class)
                    .build(jsonObject, context);
        } catch (Exception e) {
            Debug.logT(TAG, e);
            return null;
        }
    }

    @Keep
    @KeepClassMembers
    @JsonObject
    public static class NotificationModel {
        private static final String BIG_PICTURE_STYLE = "BigPictureStyle";

        public Notification build(JSONObject jsonObject, Context context) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

            if (!Utils.isEmpty(notificationModel)) {
                if (!Utils.isEmpty(notificationModel.autoCancel)) {
                    builder.setAutoCancel(notificationModel.autoCancel);
                }
//                if (!Utils.isEmpty(notificationModel.category)) {
//                    builder.setCategory(notificationModel.category);
//                }
                if (!Utils.isEmpty(notificationModel.contentTitle)) {
                    builder.setContentTitle(notificationModel.contentTitle);
                }
                if (!Utils.isEmpty(notificationModel.deleteIntent)) {
                    builder.setDeleteIntent(notificationModel.deleteIntent);
                }
//                if (!Utils.isEmpty(notificationModel.color)) {
//                    builder.setColor(notificationModel.color);
//                }
                if (!Utils.isEmpty(notificationModel.contentInfo)) {
                    builder.setContentInfo(notificationModel.contentInfo);
                }
                if (!Utils.isEmpty(notificationModel.contentInfo)) {
                    builder.setContentInfo(notificationModel.contentInfo);
                }
                if (!Utils.isEmpty(notificationModel.contentIntent)) {
                    builder.setContentIntent(notificationModel.contentIntent);
                }
                if (!Utils.isEmpty(notificationModel.contentTitle)) {
                    builder.setContentTitle(notificationModel.contentTitle);
                }
                if (!Utils.isEmpty(notificationModel.contentText)) {
                    builder.setContentText(notificationModel.contentText);
                }
                if (!Utils.isEmpty(notificationModel.defaults)) {
                    builder.setDefaults(notificationModel.defaults);
                }
                if (!Utils.isEmpty(notificationModel.deleteIntent)) {
                    builder.setDeleteIntent(notificationModel.deleteIntent);
                }
                if (!Utils.isEmpty(notificationModel.extras)) {
                    Bundle bundle = new Bundle();
                    for (String key : notificationModel.extras.keySet()) {
//                        bundle.putString(key, notificationModel.extras.get(key));
                    }
                    builder.setExtras(bundle);
                }
                if (!Utils.isEmpty(notificationModel.groupKey)) {
                    builder.setGroup(notificationModel.groupKey);
                }
                if (!Utils.isEmpty(notificationModel.groupSummary)) {
                    builder.setGroupSummary(notificationModel.groupSummary);
                }
                if (!Utils.isEmpty(notificationModel.largeIcon)) {
                    Bitmap largeIcon = ImageLoader.getInstance().loadImageSync(
                            notificationModel.largeIcon);
                    if (largeIcon != null) builder.setLargeIcon(largeIcon);
                }
                if (!Utils.isEmpty(notificationModel.localOnly)) {
                    builder.setLocalOnly(notificationModel.localOnly);
                }
                if (!Utils.isEmpty(notificationModel.number)) {
                    builder.setNumber(notificationModel.number);
                }
                if (!Utils.isEmpty(notificationModel.ongoing)) {
                    builder.setOngoing(notificationModel.ongoing);
                }
                if (!Utils.isEmpty(notificationModel.onlyAlertOnce)) {
                    builder.setOnlyAlertOnce(notificationModel.onlyAlertOnce);
                }
                if (!Utils.isEmpty(notificationModel.priority)) {
                    builder.setPriority(notificationModel.priority);
                }
//                if (!Utils.isEmpty(notificationModel.showWhen)) {
//                    builder.showWhen(notificationModel.showWhen);
//                }
                if (!Utils.isEmpty(notificationModel.smallIcon)) {
                    Bitmap smallIcon = ImageLoader.getInstance().loadImageSync(
                            notificationModel.smallIcon);
                    if (smallIcon != null) builder.setSmallIcon(Utils.getDrawableId(
                            context, notificationModel.smallIcon));
                }
                if (!Utils.isEmpty(notificationModel.sortKey)) {
                    builder.setSortKey(notificationModel.sortKey);
                }
                if (!Utils.isEmpty(notificationModel.subText)) {
                    builder.setSubText(notificationModel.subText);
                }
                if (!Utils.isEmpty(notificationModel.tickerText)) {
                    builder.setTicker(notificationModel.tickerText);
                }
                if (!Utils.isEmpty(notificationModel.usesChronometer)) {
                    builder.setUsesChronometer(notificationModel.usesChronometer);
                }
//                if (!Utils.isEmpty(notificationModel.visibility)) {
//                    builder.setVisibility(notificationModel.visibility);
//                }
                if (!Utils.isEmpty(notificationModel.when)) {
                    builder.setWhen(notificationModel.when);
                }

                NotificationCompat.Style style = null;

                if (!Utils.isEmpty(notificationModel.bigPictureStyle)) {
                    NotificationCompat.BigPictureStyle bigPictureStyle
                            = new NotificationCompat.BigPictureStyle();
                    if (!Utils.isEmpty(notificationModel.bigPictureStyle.bigLargeIcon)) {
                        Bitmap bigLargeIcon = ImageLoader.getInstance().loadImageSync(
                                notificationModel.bigPictureStyle.bigLargeIcon);
                        if (bigLargeIcon != null) bigPictureStyle.bigLargeIcon(bigLargeIcon);
                    }
                    if (!Utils.isEmpty(notificationModel.bigPictureStyle.bigPicture)) {
                        Bitmap bigPicture = ImageLoader.getInstance().loadImageSync(
                                notificationModel.bigPictureStyle.bigPicture);
                        if (bigPicture != null) bigPictureStyle.bigPicture(bigPicture);
                    }
                    if (!Utils.isEmpty(notificationModel.bigPictureStyle.contentTitle)) {
                        bigPictureStyle.setBigContentTitle(
                                notificationModel.bigPictureStyle.contentTitle);
                    }
                    if (!Utils.isEmpty(notificationModel.bigPictureStyle.bigPicture)) {
                        bigPictureStyle.setSummaryText(
                                notificationModel.bigPictureStyle.summaryText);
                    }
                    style = bigPictureStyle;
                }

                if (style != null) builder.setStyle(style);
            }

            return builder.build();
        }

        @Keep
        @KeepClassMembers
        @JsonObject
        public static class PendingIntentModel {
        }

        @Keep
        @KeepClassMembers
        @JsonObject
        public static class AndroidNotificationModel {
            @Keep
            @KeepClassMembers
            @JsonObject
            public static class BigPictureStyleModel {
                @JsonField
                public String bigLargeIcon;
                @JsonField
                public String bigPicture;
                @JsonField
                public String contentTitle;
                @JsonField
                public String summaryText;
            }
//            @JsonField
//            public List<NotificationCompat.Action> actions;
            @JsonField
            public Boolean autoCancel;
            @JsonField
            public String category;
            @JsonField
            public Integer color;
            @JsonField
            public String contentInfo;
            @JsonField
            public PendingIntentModel contentIntent;
            @JsonField
            public String contentTitle;
            @JsonField
            public String contentText;
            @JsonField
            public Integer defaults;
            @JsonField
            public PendingIntentModel deleteIntent;
            @JsonField
            public Bundle extras;
            @JsonField
            public String groupKey;
            @JsonField
            public Boolean groupSummary;
            @JsonField
            public String largeIcon;
//            @JsonField
//            public List<Integer> lights;
            @JsonField
            public Boolean localOnly;
            @JsonField
            public Integer number;
            @JsonField
            public Boolean ongoing;
            @JsonField
            public Boolean onlyAlertOnce;
            @JsonField
            public List<String> people;
            @JsonField
            public Integer priority;
//            @JsonField
//            public Progress progress;
//            @JsonField
//            public Notification publicVersion;
            @JsonField
            public Boolean showWhen;
            @JsonField
            public String smallIcon;
            @JsonField
            public String sortKey;
//            @JsonField
//            public Sound sound;
            @JsonField
            public BigPictureStyleModel bigPictureStyle;
            @JsonField
            public String subText;
            @JsonField
            public String tickerText;
            @JsonField
            public Boolean usesChronometer;
            @JsonField
            public Integer visibility;
            @JsonField
            public Long when;
        }

        /*
         * Note: passing the name parameter into @JsonField will cause
         * LoganSquare to use "_id" in JSON parsing and processing instead
         * of "imageId".
         */
        @JsonField(name = "android")
        public AndroidNotificationModel notificationModel;

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
