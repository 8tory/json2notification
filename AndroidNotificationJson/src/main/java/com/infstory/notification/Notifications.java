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

package com.infstory.notification;

import android.app.Notification;
import android.content.Context;

import com.bluelinelabs.logansquare.LoganSquare;
import com.infstory.notification.debug.Debugger;
import com.infstory.notification.model.AndroidNotificationJsonModel;

import org.json.JSONObject;
import org.json.JSONException;

public class Notifications {
    private static final String ANDROID = "android";
    private static final String TAG = "Notifications";
    private Context mContext;
    private Debugger mDebugger;

    public static Notifications from(Context context) {
        return new Notifications(context);
    }

    private Notifications(Context context) {
        mContext = context;
        mDebugger = new Debugger(context).setTag(TAG);
    }

    public Notification build(String json) {
        try {
            return build(new JSONObject(json));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Notification build(JSONObject jsonObject) {
        Notification notification = null;

        try {
            // There's a TypeConverter mechanism can be used, however, it cannot pass parameters.
            // I need to pass parameters for building the instance so just do this by build() method
            // in each model itself.
            mDebugger.logT(jsonObject.toString());
            if (jsonObject.has(ANDROID)) {
                notification = LoganSquare
                        .parse(jsonObject.get(ANDROID).toString(),
                                AndroidNotificationJsonModel.class)
                        .build(jsonObject.get(ANDROID), mContext);
            } else {
                mDebugger.logT("Wrong JSON format");
            }
        } catch (Exception e) {
            mDebugger.logT(e);
        }

        return notification;
    }
}
