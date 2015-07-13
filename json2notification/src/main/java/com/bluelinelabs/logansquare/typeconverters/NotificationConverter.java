/*
 * Copyright (C) 2015 8tory, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;

import com.bluelinelabs.logansquare.models.*;
import android.content.Context;

import android.support.v4.app.NotificationCompat;
import android.app.Notification;
import java.io.IOException;
import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.ImageLoader;

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
            android.util.Log.d("json2notification", "autoCancel:" + simpleNotification.autoCancel);
            builder.setAutoCancel(simpleNotification.autoCancel);
        }
        if (simpleNotification.category != null) {
            android.util.Log.d("json2notification", "category:" + simpleNotification.category);
            builder.setCategory(simpleNotification.category);
        }
        if (simpleNotification.contentTitle != null) {
            android.util.Log.d("json2notification", "contentTitle:" + simpleNotification.contentTitle);
            builder.setContentTitle(simpleNotification.contentTitle);
        }
        if (simpleNotification.color != null) {
            android.util.Log.d("json2notification", "color:" + simpleNotification.color);
            builder.setColor(simpleNotification.color);
        }
        if (simpleNotification.contentInfo != null) {
            android.util.Log.d("json2notification", "contentInfo:" + simpleNotification.contentInfo);
            builder.setContentInfo(simpleNotification.contentInfo);
        }
        if (simpleNotification.contentIntent != null) {
            android.util.Log.d("json2notification", "contentIntent:" + simpleNotification.contentIntent);
            builder.setContentIntent(simpleNotification.contentIntent);
        }
        if (simpleNotification.contentText != null) {
            android.util.Log.d("json2notification", "contentText:" + simpleNotification.contentText);
            builder.setContentText(simpleNotification.contentText);
        }
        if (simpleNotification.defaults != null) {
            builder.setDefaults(simpleNotification.defaults);
        }
        if (simpleNotification.deleteIntent != null) {
            android.util.Log.d("json2notification", "deleteIntent:" + simpleNotification.deleteIntent);
            builder.setDeleteIntent(simpleNotification.deleteIntent);
        }
//        if (simpleNotification.extras != null) {
//            Bundle bundle = new Bundle();
//            for (String key : extras.keySet( != null) {
//                        bundle.putString(key, extras.get(key));
//            }
//            builder.setExtras(bundle);
//        }
        if (simpleNotification.groupKey != null) {
            android.util.Log.d("json2notification", "groupKey:" + simpleNotification.groupKey);
            builder.setGroup(simpleNotification.groupKey);
        }
        if (simpleNotification.groupSummary != null) {
            android.util.Log.d("json2notification", "groupSummary:" + simpleNotification.groupSummary);
            builder.setGroupSummary(simpleNotification.groupSummary);
        }
        if (simpleNotification.largeIcon != null) {
            android.util.Log.d("json2notification", "largeIcon:" + simpleNotification.largeIcon);
            try {
                Bitmap largeIconBitmap = ImageLoader.getInstance().loadImageSync(simpleNotification.largeIcon);
                if (largeIconBitmap != null) builder.setLargeIcon(largeIconBitmap);
            } catch (Exception e) {
            }
        }
        if (simpleNotification.localOnly != null) {
            android.util.Log.d("json2notification", "localOnly:" + simpleNotification.localOnly);
            builder.setLocalOnly(simpleNotification.localOnly);
        }
        if (simpleNotification.number != null) {
            android.util.Log.d("json2notification", "number:" + simpleNotification.number);
            builder.setNumber(simpleNotification.number);
        }
        if (simpleNotification.ongoing != null) {
            android.util.Log.d("json2notification", "ongoing:" + simpleNotification.ongoing);
            builder.setOngoing(simpleNotification.ongoing);
        }
        if (simpleNotification.onlyAlertOnce != null) {
            android.util.Log.d("json2notification", "onlyAlertOnce:" + simpleNotification.onlyAlertOnce);
            builder.setOnlyAlertOnce(simpleNotification.onlyAlertOnce);
        }
        if (simpleNotification.priority != null) {
            android.util.Log.d("json2notification", "priority:" + simpleNotification.priority);
            builder.setPriority(simpleNotification.priority);
        }
//                if (simpleNotification.showWhen != null) {
//                    builder.showWhen(showWhen);
//                }
        if (simpleNotification.smallIcon != null) {
            android.util.Log.d("json2notification", "smallIcon:" + simpleNotification.smallIcon);
            try {
                int smallIconId = getDrawableId(context, simpleNotification.smallIcon);
                if (smallIconId > 0) {
                    builder.setSmallIcon(smallIconId);
                }
            } catch (Exception e) {
            }
        }
        if (simpleNotification.sortKey != null) {
            android.util.Log.d("json2notification", "sortKey:" + simpleNotification.sortKey);
            builder.setSortKey(simpleNotification.sortKey);
        }
        if (simpleNotification.sound != null) {
            android.util.Log.d("json2notification", "sound:" + simpleNotification.sound);
            builder.setSound(simpleNotification.sound);
        //} else {
            //builder.setSound(android.media.RingtoneManager.getDefaultUri(android.media.RingtoneManager.TYPE_NOTIFICATION));
        }
        if (simpleNotification.subText != null) {
            android.util.Log.d("json2notification", "subText:" + simpleNotification.subText);
            builder.setSubText(simpleNotification.subText);
        }
        if (simpleNotification.tickerText != null) {
            android.util.Log.d("json2notification", "tickerText:" + simpleNotification.tickerText);
            builder.setTicker(simpleNotification.tickerText);
        }
        if (simpleNotification.usesChronometer != null) {
            android.util.Log.d("json2notification", "usesChronometer:" + simpleNotification.usesChronometer);
            builder.setUsesChronometer(simpleNotification.usesChronometer);
        }
        if (simpleNotification.visibility != null) {
            android.util.Log.d("json2notification", "visibility:" + simpleNotification.visibility);
            builder.setVisibility(simpleNotification.visibility);
        }
        if (simpleNotification.when != null) {
            android.util.Log.d("json2notification", "when:" + simpleNotification.when);
            builder.setWhen(simpleNotification.when);
        }
        if (simpleNotification.bigPictureStyle != null) {
            android.util.Log.d("json2notification", "bigPictureStyle:" + simpleNotification.bigPictureStyle);
            builder.setStyle(simpleNotification.bigPictureStyle);
        }

        return builder.build();
    }

    private static int getDrawableId(Context context, String resString) {
        resString = resString.replace("R.drawable.", "");
        return context.getResources().getIdentifier(
                resString, "drawable", context.getPackageName());
    }

    @Override
    public void serialize(Notification notification, String fieldName, boolean writeFieldNameForObject,
            JsonGenerator jsonGenerator) throws IOException {
        // SimpleNotification simpleNotification = new SimpleNotification();
        // TODO
        // SimpleNotification$$JsonObjectMapper._serialize((SimpleNotification) simpleNotification, jsonGenerator, true);
    }
}

