package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;

import com.bluelinelabs.logansquare.models.*;

import android.support.v4.app.NotificationCompat;
import android.app.Notification;

/**
 * <pre>
 * {
 *     "getActivity": true,
 *     "intent": {
 *         "action": "android.intent.action.VIEW",
 *         "uri": "https://play.google.com/store/apps/details?id=com.story8.android.gallery"
 *     }
 * }
 * </pre>
 */
public class NotificationConverter implements TypeConverter<Notification> {
    Context context;

    public NotificationConverter(Context context) {
        this.context = context;
    }

    @Override
    public Notification parse(JsonParser jsonParser) throws IOException {
        SimpleNotification simpleNotification = SimpleNotification$$JsonObjectMapper._parse(jsonParser);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

        if (simpleNotification.autoCancel != null) {
            builder.setAutoCancel(simpleNotification.autoCancel);
        }
        if (simpleNotification.category != null) {
            builder.setCategory(simpleNotification.category);
        }
        if (simpleNotification.contentTitle != null) {
            builder.setContentTitle(simpleNotification.contentTitle);
        }
        if (simpleNotification.color != null) {
            builder.setColor(simpleNotification.color);
        }
        if (simpleNotification.contentInfo != null) {
            builder.setContentInfo(simpleNotification.contentInfo);
        }
        if (simpleNotification.contentIntentModel != null) {
            builder.setContentIntent(simpleNotification.contentIntent);
        }
        if (simpleNotification.contentTitle != null) {
            builder.setContentTitle(simpleNotification.contentTitle);
        }
        if (simpleNotification.contentText != null) {
            builder.setContentText(simpleNotification.contentText);
        }
        if (simpleNotification.defaults != null) {
            builder.setDefaults(simpleNotification.defaults);
        }
        if (simpleNotification.deleteIntentModel != null) {
            builder.setDeleteIntent(simpleNotification.deleteIntentModel);
        }
//        if (simpleNotification.extras != null) {
//            Bundle bundle = new Bundle();
//            for (String key : extras.keySet( != null) {
//                        bundle.putString(key, extras.get(key));
//            }
//            builder.setExtras(bundle);
//        }
        if (simpleNotification.groupKey != null) {
            builder.setGroup(simpleNotification.groupKey);
        }
        if (simpleNotification.groupSummary != null) {
            builder.setGroupSummary(simpleNotification.groupSummary);
        }
        if (simpleNotification.largeIcon != null) {
            try {
                Bitmap largeIconBitmap = ImageLoader.getInstance().loadImageSync(simpleNotification.largeIcon);
                if (largeIconBitmap != null) builder.setLargeIcon(largeIconBitmap);
            } catch (Exception e) {
            }
        }
        if (simpleNotification.localOnly != null) {
            builder.setLocalOnly(simpleNotification.localOnly);
        }
        if (simpleNotification.number != null) {
            builder.setNumber(simpleNotification.number);
        }
        if (simpleNotification.ongoing != null) {
            builder.setOngoing(simpleNotification.ongoing);
        }
        if (simpleNotification.onlyAlertOnce != null) {
            builder.setOnlyAlertOnce(simpleNotification.onlyAlertOnce);
        }
        if (simpleNotification.priority != null) {
            builder.setPriority(simpleNotification.priority);
        }
//                if (simpleNotification.showWhen != null) {
//                    builder.showWhen(showWhen);
//                }
        if (simpleNotification.smallIcon != null) {
            try {
                int smallIconId = Utils.getDrawableId(context, simpleNotification.smallIcon);
                if (smallIconId > 0) {
                    builder.setSmallIcon(smallIconId);
                }
            } catch (Exception e) {
            }
        }
        if (simpleNotification.sortKey != null) {
            builder.setSortKey(simpleNotification.sortKey);
        }
        if (simpleNotification.sound != null) {
            builder.setSound(simpleNotification.sound);
        }
        if (simpleNotification.subText != null) {
            builder.setSubText(simpleNotification.subText);
        }
        if (simpleNotification.tickerText != null) {
            builder.setTicker(simpleNotification.tickerText);
        }
        if (simpleNotification.usesChronometer != null) {
            builder.setUsesChronometer(simpleNotification.usesChronometer);
        }
        if (simpleNotification.visibility != null) {
            builder.setVisibility(simpleNotification.visibility);
        }
        if (simpleNotification.when != null) {
            builder.setWhen(simpleNotification.when);
        }
        if (simpleNotification.bigPictureStyle != null) {
            builder.setStyle(style);
        }

        return builder.build();
    }

    @Override
    public void serialize(Notification notification, String fieldName, boolean writeFieldNameForObject,
            JsonGenerator jsonGenerator) throws IOException {
        // SimpleNotification simpleNotification = new SimpleNotification();
        // TODO
        // SimpleNotification$$JsonObjectMapper._serialize((SimpleNotification) simpleNotification, jsonGenerator, true);
    }
}

