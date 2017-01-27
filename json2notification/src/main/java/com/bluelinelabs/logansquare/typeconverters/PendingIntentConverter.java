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
import android.content.Intent;
import android.content.Context;
import java.io.IOException;

import android.support.annotation.Nullable;
import java.lang.reflect.*;

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
        SimplePendingIntent simplePendingIntent = new SimplePendingIntent$$JsonObjectMapper().parse(jsonParser);

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
        if (pendingIntent == null) return;
        SimplePendingIntent simplePendingIntent = new SimplePendingIntent();
        simplePendingIntent.requestCode = 0;
        simplePendingIntent.flags = PendingIntent.FLAG_UPDATE_CURRENT;
        //simplePendingIntent.intent = pendingIntent.getIntent(); // hidden-api
        simplePendingIntent.intent = getIntent(pendingIntent);
        // pendingIntent.isActivity(); // hidden-api
        boolean isActivity = isActivity(pendingIntent);
        if (isActivity) {
            simplePendingIntent.getActivity = true;
        } else {
            simplePendingIntent.getService = true;
        }
        if (writeFieldNameForObject) jsonGenerator.writeFieldName(fieldName);
        new SimplePendingIntent$$JsonObjectMapper().serialize((SimplePendingIntent) simplePendingIntent, jsonGenerator, true);
    }

    @Nullable
    private Intent getIntent(PendingIntent pintent) {
        Intent intent = null;
        try {
            Method getIntentMethod = pintent.getClass().getMethod("getIntent");
            intent = (Intent) getIntentMethod.invoke(pintent);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return intent;
    }

    private boolean isActivity(PendingIntent pintent) {
        boolean isActivity = false;
        try {
            Method isActivityMethod = pintent.getClass().getMethod("isActivity");
            isActivity = (boolean) isActivityMethod.invoke(pintent);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return isActivity;
    }
}
