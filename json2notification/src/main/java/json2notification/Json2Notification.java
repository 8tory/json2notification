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

    public Json2Notification with(String json) {
        try {
            return with(new JSONObject(json));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Json2Notification with(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        return this;
    }

    public Notification notification() {
        Notification notification = null;

        try {
            AndroidNotification androidNotification = AndroidNotification.parse(context, jsonObject.toString());
            notification = androidNotification.android.notification;
        } catch (Exception e) {
        }

        return notification;
    }
}
