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

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.infstory.notification.Utils;
import com.infstory.notification.debug.Debugger;

import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;

@Keep
@KeepClassMembers
@JsonObject
public class PendingIntentModel implements ModelBuilder<PendingIntent> {
    private static final String INTENT = "intent";

    private Debugger mDebugger;

    @JsonField
    public Integer flags;
    @JsonField
    public Boolean getActivity;
    @JsonField
    public Boolean getService;
    @JsonField(name = INTENT)
    public IntentModel intentModel;
    @JsonField
    public Integer requestCode;

    @Override
    public PendingIntent build(Object... objects) {
        Context context = (Context) objects[0];

        mDebugger = new Debugger(context);

        PendingIntent pendingIntent = null;
        Intent intent = null;

        if (!Utils.isEmpty(intentModel)) {
            mDebugger.logT("intentModel: " + intentModel.toString());
            intent = intentModel.build(context);
        }

        if (Utils.isEmpty(requestCode)) {
            requestCode = 0;
        }
        mDebugger.logT("requestCode: " + requestCode.toString());

        if (Utils.isEmpty(flags)) {
            flags = PendingIntent.FLAG_UPDATE_CURRENT;
        }
        mDebugger.logT("flags: " + flags.toString());

        if (!Utils.isEmpty(getActivity)) {
            mDebugger.logT("getActivity: " + getActivity.toString());
            pendingIntent = PendingIntent.getActivity(context, requestCode, intent, flags);
        } else if (!Utils.isEmpty(getService)) {
            mDebugger.logT("getService: " + getService.toString());
            pendingIntent = PendingIntent.getService(context, requestCode, intent, flags);
        }

        return pendingIntent;
    }
}

