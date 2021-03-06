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

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;
import android.content.Intent;
import com.bluelinelabs.logansquare.typeconverters.*;

@Keep
@KeepClassMembers
@JsonObject
public class SimplePendingIntent {
    @JsonField
    public Integer flags;
    @JsonField
    public Boolean getActivity;
    @JsonField
    public Boolean getService;
    /**
     * ("broadcarst"|"activity"|"activities"|"service")
     */
    @JsonField
    public String start;
    @JsonField(typeConverter = IntentConverter.class)
    public Intent intent;
    @JsonField
    public Integer requestCode;
}
