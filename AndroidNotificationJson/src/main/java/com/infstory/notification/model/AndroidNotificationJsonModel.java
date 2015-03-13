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
        android.util.Log.d("Notifications", "1");
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
        android.util.Log.d("Notifications", "2");

        return notification;
    }
}
