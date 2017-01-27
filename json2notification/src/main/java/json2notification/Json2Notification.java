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

package json2notification;

import android.app.Notification;
import android.content.Context;

import org.json.JSONObject;
import org.json.JSONException;

import json2notification.model.AndroidNotification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Notification;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.bluelinelabs.logansquare.typeconverters.*;
import com.bluelinelabs.logansquare.LoganSquare;

public class Json2Notification {
    private static final String TAG = "json2notification";
    private Context context;
    private JSONObject jsonObject;

    public static Json2Notification from(Context context) {
        return new Json2Notification(context);
    }

    private Json2Notification(Context context) {
        this.context = context;
    }

    @NonNull
    public Json2Notification with(String json) {
        try {
            return with(new JSONObject(json));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    @NonNull
    public Json2Notification with(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        return this;
    }

    @NonNull
    public Json2Notification with(Notification notification) {
        this.notification = notification;
        return this;
    }

    Notification notification;
    AndroidNotification androidNotification;

    @Nullable
    public Notification notification() {
        //if (notification == null) {
        if (androidNotification == null) {
            try {
                androidNotification = AndroidNotification.parse(context, jsonObject.toString());
                notification = androidNotification.android.notification;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return notification;
    }

    NotificationManager notificationManager;

    @NonNull
    public NotificationManager notificationManager() {
        if (notificationManager == null) {
            notificationManager = android.content.SystemServices.from(context).getNotificationManager();
        }
        return notificationManager;
    }

    public void notify(int id) {
        notificationManager().notify(id, notification());
    }

    public void notify(String tag, int id) {
        notificationManager().notify(tag, id, notification());
    }

    @Nullable
    public String serialize() {
        if (notification == null) return null;
        // TODO androidNotification
        //androidNotification = new AndroidNotification();
        //androidNotification.android.notification = notification;
        //String text = androidNotification.serialize();
        //LoganSquare.registerTypeConverter(Notification.class, new NotificationConverter(context));
        LoganSquare.registerTypeConverter(PendingIntent.class, new PendingIntentConverter(context));

        try {
            return LoganSquare.serialize(NotificationConverter.toSimpleNotification(notification));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
