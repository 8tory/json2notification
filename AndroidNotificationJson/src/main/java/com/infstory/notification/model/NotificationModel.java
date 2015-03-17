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

package com.infstory.notification.model;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.infstory.notification.Utils;
import com.infstory.notification.debug.Debugger;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONObject;

import java.util.List;

import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;

@Keep
@KeepClassMembers
@JsonObject
public class NotificationModel implements ModelBuilder<Notification> {
    private static final String BIG_PICTURE_STYLE = "bigPictureStyle";
    private static final String CONTENT_INTENT = "contentIntent";
    private static final String DELETE_INTENT = "deleteIntent";

    private Debugger mDebugger;

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

    @JsonField
    public Boolean autoCancel;
    @JsonField(name = BIG_PICTURE_STYLE)
    public BigPictureStyleModel bigPictureStyleModel;
    @JsonField
    public String category;
    @JsonField
    public Integer color;
    @JsonField
    public String contentInfo;
    @JsonField(name = CONTENT_INTENT)
    public PendingIntentModel contentIntentModel;
    @JsonField
    public String contentTitle;
    @JsonField
    public String contentText;
    @JsonField
    public Integer defaults;
    @JsonField(name = DELETE_INTENT)
    public PendingIntentModel deleteIntentModel;
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
    @JsonField
    public Uri sound;
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

    @Override
    public Notification build(Object... objects) {
        JSONObject jsonObject = (JSONObject) objects[0];
        Context context  = (Context) objects[1];

        mDebugger = new Debugger(context);
        mDebugger.log(jsonObject.toString());

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

        if (!Utils.isEmpty(autoCancel)) {
            mDebugger.log("autoCancel: " + autoCancel.toString());
            builder.setAutoCancel(autoCancel);
        }
        if (!Utils.isEmpty(category)) {
            mDebugger.log("category: " + category);
            builder.setCategory(category);
        }
        if (!Utils.isEmpty(contentTitle)) {
            mDebugger.log("contentTitle: " + contentTitle);
            builder.setContentTitle(contentTitle);
        }
        if (!Utils.isEmpty(color)) {
            mDebugger.log("color: " + color.toString());
            builder.setColor(color);
        }
        if (!Utils.isEmpty(contentInfo)) {
            mDebugger.log("contentInfo: " + contentInfo);
            builder.setContentInfo(contentInfo);
        }
        if (!Utils.isEmpty(contentIntentModel)) {
            mDebugger.log("contentIntentModel: " + contentIntentModel.toString());
            builder.setContentIntent(contentIntentModel.build(context));
        }
        if (!Utils.isEmpty(contentTitle)) {
            mDebugger.log("contentTitle: " + contentTitle);
            builder.setContentTitle(contentTitle);
        }
        if (!Utils.isEmpty(contentText)) {
            mDebugger.log("contentText: " + contentText);
            builder.setContentText(contentText);
        }
        if (!Utils.isEmpty(defaults)) {
            mDebugger.log("defaults: " + defaults.toString());
            builder.setDefaults(defaults);
        }
        if (!Utils.isEmpty(deleteIntentModel)) {
            mDebugger.log("deleteIntentModel: " + deleteIntentModel.toString());
            builder.setDeleteIntent(deleteIntentModel.build(context));
        }
//        if (!Utils.isEmpty(extras)) {
//            Bundle bundle = new Bundle();
//            for (String key : extras.keySet()) {
//                        bundle.putString(key, extras.get(key));
//            }
//            builder.setExtras(bundle);
//        }
        if (!Utils.isEmpty(groupKey)) {
            mDebugger.log("groupKey: " + groupKey);
            builder.setGroup(groupKey);
        }
        if (!Utils.isEmpty(groupSummary)) {
            mDebugger.log("groupSummary: " + groupSummary.toString());
            builder.setGroupSummary(groupSummary);
        }
        if (!Utils.isEmpty(largeIcon)) {
            mDebugger.log("largeIcon: " + largeIcon);
            try {
                Bitmap largeIconBitmap = ImageLoader.getInstance().loadImageSync(largeIcon);
                if (largeIconBitmap != null) builder.setLargeIcon(largeIconBitmap);
            } catch (Exception e) {
                mDebugger.log(e);
            }
        }
        if (!Utils.isEmpty(localOnly)) {
            mDebugger.log("localOnly: " + localOnly.toString());
            builder.setLocalOnly(localOnly);
        }
        if (!Utils.isEmpty(number)) {
            mDebugger.log("number: " + number.toString());
            builder.setNumber(number);
        }
        if (!Utils.isEmpty(ongoing)) {
            mDebugger.log("ongoing: " + ongoing.toString());
            builder.setOngoing(ongoing);
        }
        if (!Utils.isEmpty(onlyAlertOnce)) {
            mDebugger.log("onlyAlertOnce: " + onlyAlertOnce.toString());
            builder.setOnlyAlertOnce(onlyAlertOnce);
        }
        if (!Utils.isEmpty(priority)) {
            mDebugger.log("priority: " + priority.toString());
            builder.setPriority(priority);
        }
//                if (!Utils.isEmpty(showWhen)) {
//                    builder.showWhen(showWhen);
//                }
        if (!Utils.isEmpty(smallIcon)) {
            mDebugger.log("smallIcon: " + smallIcon);
            try {
                int smallIconId = Utils.getDrawableId(context, smallIcon);
                if (smallIconId > 0) {
                    builder.setSmallIcon(smallIconId);
                }
            } catch (Exception e) {
                mDebugger.log(e);
            }
        }
        if (!Utils.isEmpty(sortKey)) {
            mDebugger.log("sortKey: " + sortKey);
            builder.setSortKey(sortKey);
        }
        if (!Utils.isEmpty(sound)) {
            mDebugger.log("sound: " + sound.toString());
            builder.setSound(sound);
        }
        if (!Utils.isEmpty(subText)) {
            mDebugger.log("subText: " + subText);
            builder.setSubText(subText);
        }
        if (!Utils.isEmpty(tickerText)) {
            mDebugger.log("tickerText: " + tickerText);
            builder.setTicker(tickerText);
        }
        if (!Utils.isEmpty(usesChronometer)) {
            mDebugger.log("usesChronometer: " + usesChronometer.toString());
            builder.setUsesChronometer(usesChronometer);
        }
        if (!Utils.isEmpty(visibility)) {
            mDebugger.log("visibility: " + visibility.toString());
            builder.setVisibility(visibility);
        }
        if (!Utils.isEmpty(when)) {
            mDebugger.log("when: " + when.toString());
            builder.setWhen(when);
        }

        NotificationCompat.Style style = null;

        if (!Utils.isEmpty(bigPictureStyleModel)) {
            mDebugger.log("bigPictureStyleModel: " + bigPictureStyleModel.toString());
            NotificationCompat.BigPictureStyle bigPictureStyle
                    = new NotificationCompat.BigPictureStyle();
            if (!Utils.isEmpty(bigPictureStyleModel.bigLargeIcon)) {
                mDebugger.log("bigPictureStyleModel.bigLargeIcon: "
                        + bigPictureStyleModel.bigLargeIcon);
                try {
                    Bitmap bigLargeIcon = ImageLoader.getInstance().loadImageSync(
                            bigPictureStyleModel.bigLargeIcon);
                    if (bigLargeIcon != null) bigPictureStyle.bigLargeIcon(bigLargeIcon);
                } catch (Exception e) {
                    mDebugger.log(e);
                }
            }
            if (!Utils.isEmpty(bigPictureStyleModel.bigPicture)) {
                mDebugger.log("bigPictureStyleModel.bigPicture: "
                        + bigPictureStyleModel.bigPicture);
                try {
                    Bitmap bigPicture = ImageLoader.getInstance().loadImageSync(
                            bigPictureStyleModel.bigPicture);
                    if (bigPicture != null) bigPictureStyle.bigPicture(bigPicture);
                } catch (Exception e) {
                    mDebugger.log(e);
                }
            }
            if (!Utils.isEmpty(bigPictureStyleModel.contentTitle)) {
                mDebugger.log("bigPictureStyleModel.contentTitle: "
                        + bigPictureStyleModel.contentTitle);
                bigPictureStyle.setBigContentTitle(
                        bigPictureStyleModel.contentTitle);
            }
            if (!Utils.isEmpty(bigPictureStyleModel.summaryText)) {
                mDebugger.log("bigPictureStyleModel.summaryText: "
                        + bigPictureStyleModel.summaryText);
                bigPictureStyle.setSummaryText(
                        bigPictureStyleModel.summaryText);
            }
            style = bigPictureStyle;
        }

        if (style != null) builder.setStyle(style);

        return builder.build();
    }
}
