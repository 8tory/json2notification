package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;

import com.bluelinelabs.logansquare.models.*;

import android.app.PendingIntent;
import android.content.Context;

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
            pendingIntent = PendingIntent.getActivity(context,
                    simplePendingIntent.requestCode == null ? 0 : simplePendingIntent.requestCode,
                    simplePendingIntent.intent,
                    simplePendingIntent.flags == null ? PendingIntent.FLAG_UPDATE_CURRENT : simplePendingIntent.flags);
        } else if (simplePendingIntent.getService != null && simplePendingIntent.getService) {
            pendingIntent = PendingIntent.getService(context,
                    simplePendingIntent.requestCode == null ? 0 : simplePendingIntent.requestCode,
                    simplePendingIntent.intent,
                    simplePendingIntent.flags == null ? PendingIntent.FLAG_UPDATE_CURRENT : simplePendingIntent.flags);
        }
        return pendingIntent;
    }

    @Override
    public void serialize(PendingIntent pendingIntent, String fieldName, boolean writeFieldNameForObject,
            JsonGenerator jsonGenerator) throws IOException {
        // SimplePendingIntent simplePendingIntent = new SimplePendingIntent();
        // simplePendingIntent.flags = pendingIntent.flags
        // TODO
        // SimplePendingIntent$$JsonObjectMapper._serialize((SimplePendingIntent) simplePendingIntent, jsonGenerator, true);
    }
}
