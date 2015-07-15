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

package com.bluelinelabs.logansquare.models;

import android.app.Notification;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;
import com.bluelinelabs.logansquare.typeconverters.*;
import android.support.v4.app.NotificationCompat;
import android.app.PendingIntent;
import java.util.List;
import android.net.Uri;

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
public class SimpleNotification {
    @JsonField
    public Boolean autoCancel;
    @JsonField(typeConverter = BigPictureStyleConverter.class)
    public NotificationCompat.BigPictureStyle bigPictureStyle;
    @JsonField
    public String category;
    @JsonField
    public Integer color;
    @JsonField
    public String contentInfo;
    @JsonField
    public PendingIntent contentIntent;
    @JsonField
    public String contentTitle;
    @JsonField
    public String contentText;
    @JsonField
    public Integer defaults;
    @JsonField
    public PendingIntent deleteIntent;
//    @JsonField
//    public BundleModel extras;
    @JsonField
    public String groupKey;
    @JsonField
    public Boolean groupSummary;
    @JsonField
    public String largeIcon;
    @JsonField
    public List<Integer> lights;
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
//    @JsonField
//    public Progress progress;
//    @JsonField
//    public Notification publicVersion;
    @JsonField
    public Boolean showWhen;
    @JsonField
    public String smallIcon;
    @JsonField
    public String sortKey;
    @JsonField(typeConverter = UriConverter.class)
    public Uri sound;
    @JsonField
    public String subText;
    @JsonField
    public CharSequence tickerText;
    @JsonField
    public Boolean usesChronometer;
    @JsonField
    public Integer visibility;
    @JsonField
    public Long when;
}
