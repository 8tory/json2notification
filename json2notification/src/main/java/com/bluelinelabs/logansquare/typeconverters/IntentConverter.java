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

package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;

import com.bluelinelabs.logansquare.models.*;

import android.content.Context;
import android.content.Intent;
import java.io.IOException;

/**
 * <pre>
 * {
 *     "getActivity": true,
 *     "intent": {
 *         "action": "android.intent.action.VIEW",
 *         "uri": "https://play.google.com/store/apps/details?id=com.story8.android.gallery"
 *     }
 * }
 * </pre>
 */
public class IntentConverter implements TypeConverter<Intent> {
    @Override
    public Intent parse(JsonParser jsonParser) throws IOException {
        SimpleIntent simpleIntent = SimpleIntent$$JsonObjectMapper._parse(jsonParser);
        Intent intent = new Intent();

        android.util.Log.d("json2notification", "action:" + simpleIntent.action);
        if (simpleIntent.action != null) {
            intent.setAction(simpleIntent.action);
        }
        android.util.Log.d("json2notification", "uri:" + simpleIntent.uri);
        if (simpleIntent.uri != null) {
            intent.setData(simpleIntent.uri);
        }
        return intent;
    }

    @Override
    public void serialize(Intent intent, String fieldName, boolean writeFieldNameForObject,
            JsonGenerator jsonGenerator) throws IOException {
        // SimpleIntent simpleIntent = new SimpleIntent();
        // simpleIntent.uri = intent.getData();
        // TODO
        // SimpleIntent$$JsonObjectMapper._serialize((SimpleIntent) simpleIntent, jsonGenerator, true);
    }
}

