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

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.infstory.notification.Utils;
import com.infstory.notification.debug.Debugger;

import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;

@Keep
@KeepClassMembers
@JsonObject
public class IntentModel implements ModelBuilder<Intent> {

    private Debugger mDebugger;

    @JsonField
    public String action;
    @JsonField
    public String uri;

    @Override
    public Intent build(Object... objects) {
        Context context = (Context) objects[0];

        mDebugger = new Debugger(context);

        Intent intent = new Intent();

        if (!Utils.isEmpty(action)) {
            mDebugger.logT("action: " + action.toString());
            intent.setAction(action);
        }
        if (!Utils.isEmpty(uri)) {
            mDebugger.logT("uri: " + uri.toString());
            intent.setData(Uri.parse(uri));
        }

        return intent;
    }
}

