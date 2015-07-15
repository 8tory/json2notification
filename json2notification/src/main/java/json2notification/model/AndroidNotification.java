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

package json2notification.model;

import android.app.Notification;
import android.content.Context;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;

import com.bluelinelabs.logansquare.LoganSquare;

import com.bluelinelabs.logansquare.typeconverters.*;
import android.app.PendingIntent;
import android.app.Notification;

/**
 *
 * <pre>
 *  "android": {
 *      "notification": {
 *          "autoCancel": true,
 *          "bigPictureStyle": {
 *              "contentTitle": "Sample Big Picture Title",
 *              "summaryText": "Sample big picture text",
 *              "bigLargeIcon": "http://8tory.com/images/logo.png",
 *              "bigPicture": "http://8tory.com/images/logo.png"
 *          },
 *          "contentInfo": "sample info",
 *          "contentIntent": {
 *              "getActivity": true,
 *              "intent": {
 *                  "action": "android.intent.action.VIEW",
 *                  "uri": "https://play.google.com/store/apps/details?id=com.story8.android.gallery"
 *              }
 *          },
 *          "contentText": "Sample content",
 *          "contentTitle": "Sample Title",
 *          "deleteIntent": {
 *              "getActivity": true,
 *              "intent": {
 *                  "action": "android.intent.action.VIEW",
 *                  "uri": "https://play.google.com/store/apps/details?id=com.story8.android.gallery"
 *              }
 *          },
 *          "largeIcon": "http://8tory.com/images/logo.png",
 *          "smallIcon": "R.drawable.ic_stat_notify_story8",
 *          "sound": "content://settings/system/notification_sound"
 *      }
 *  }
 *  </pre>
 */
@Keep
@KeepClassMembers
@JsonObject
public class AndroidNotification {
    @JsonField
    public Android android;

    Context context;

    public static AndroidNotification parse(Context context, String json) {
        LoganSquare.registerTypeConverter(PendingIntent.class, new PendingIntentConverter(context));
        LoganSquare.registerTypeConverter(Notification.class, new NotificationConverter(context));
        try {
            AndroidNotification androidNotification = LoganSquare.parse(json, AndroidNotification.class);
            androidNotification.context = context;
            return androidNotification;
        } catch (Exception e) {
            return null;
        }
    }

    public String serialize() {
        LoganSquare.registerTypeConverter(PendingIntent.class, new PendingIntentConverter(context));
        LoganSquare.registerTypeConverter(Notification.class, new NotificationConverter(context));
        try {
            return LoganSquare.serialize(this);
        } catch (Exception e) {
            return null;
        }
    }
}
