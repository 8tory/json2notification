package com.bluelinelabs.logansquare.typeconverters;

import android.net.Uri;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;

import java.io.IOException;

public class UriTypeConverter implements TypeConverter<Uri> {

    private static final Object LOCK = new Object();

    @Override
    public Uri parse(JsonParser jsonParser) throws IOException {
        String inputString = jsonParser.getValueAsString(null);

        try {
            synchronized (LOCK) {
                return Uri.parse(inputString);
            }
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public void serialize(Uri object, String fieldName, boolean writeFieldNameForObject,
                          JsonGenerator jsonGenerator) throws IOException {
        // TODO: implementation
    }

}
