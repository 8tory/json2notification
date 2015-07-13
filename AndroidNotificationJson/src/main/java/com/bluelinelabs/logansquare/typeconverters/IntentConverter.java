package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;

import com.bluelinelabs.logansquare.models.*;

import android.content.Context;
import android.content.Intent;

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

        if (simpleIntent.action != null) {
            intent.setAction(action);
        }
        if (simpleIntent.uri != null) {
            intent.setData(uri);
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

