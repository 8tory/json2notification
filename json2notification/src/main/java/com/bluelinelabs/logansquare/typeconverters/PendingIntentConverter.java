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

import android.app.PendingIntent;
import android.content.Context;
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
public class PendingIntentConverter implements TypeConverter<PendingIntent> {

    Context context;

    public PendingIntentConverter(Context context) {
        this.context = context;
    }

    @Override
    public PendingIntent parse(JsonParser jsonParser) throws IOException {
        SimplePendingIntent simplePendingIntent = SimplePendingIntent$$JsonObjectMapper._parse(jsonParser);

        PendingIntent pendingIntent = null;

        if (simplePendingIntent.getActivity != null && simplePendingIntent.getActivity) {
            android.util.Log.d("json2notification", "getActivity:" + simplePendingIntent.getActivity);
            pendingIntent = PendingIntent.getActivity(context,
                    simplePendingIntent.requestCode == null ? 0 : simplePendingIntent.requestCode,
                    simplePendingIntent.intent,
                    simplePendingIntent.flags == null ? PendingIntent.FLAG_UPDATE_CURRENT : simplePendingIntent.flags);
        } else if (simplePendingIntent.getService != null && simplePendingIntent.getService) {
            android.util.Log.d("json2notification", "getService:" + simplePendingIntent.getService);
            pendingIntent = PendingIntent.getService(context,
                    simplePendingIntent.requestCode == null ? 0 : simplePendingIntent.requestCode,
                    simplePendingIntent.intent,
                    simplePendingIntent.flags == null ? PendingIntent.FLAG_UPDATE_CURRENT : simplePendingIntent.flags);
        }
        android.util.Log.d("json2notification", "intent:" + simplePendingIntent.intent);
        android.util.Log.d("json2notification", "requestCode:" + simplePendingIntent.requestCode);
        android.util.Log.d("json2notification", "flags:" + simplePendingIntent.flags);
        return pendingIntent;
    }

    @Override
    public void serialize(PendingIntent pendingIntent, String fieldName, boolean writeFieldNameForObject,
            JsonGenerator jsonGenerator) throws IOException {
        android.util.Log.d("json2notification", "PendingIntentConverter:serialize");
        SimplePendingIntent simplePendingIntent = new SimplePendingIntent();
        // TODO
        if (writeFieldNameForObject) jsonGenerator.writeFieldName(fieldName);
        SimplePendingIntent$$JsonObjectMapper._serialize((SimplePendingIntent) simplePendingIntent, jsonGenerator, true);
    }
}
