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

import android.support.v4.app.NotificationCompat;
import java.io.IOException;
import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.ImageLoader;

public class BigPictureStyleConverter implements TypeConverter<NotificationCompat.BigPictureStyle> {
    @Override
    public NotificationCompat.BigPictureStyle parse(JsonParser jsonParser) throws IOException {
        SimpleBigPictureStyle simpleBigPictureStyle = SimpleBigPictureStyle$$JsonObjectMapper._parse(jsonParser);
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();

        if (simpleBigPictureStyle.bigLargeIcon != null) {
            android.util.Log.d("json2notification", "BigPictureStyle:bigLargeIcon:" + simpleBigPictureStyle.bigLargeIcon);
            try {
                Bitmap bigLargeIcon = ImageLoader.getInstance().loadImageSync(
                        simpleBigPictureStyle.bigLargeIcon);
                if (bigLargeIcon != null) bigPictureStyle.bigLargeIcon(bigLargeIcon);
                android.util.Log.d("json2notification", "BigPictureStyle:bigLargeIcon:bitmap:" + bigLargeIcon);
            } catch (Exception e) {
            }
        }
        if (simpleBigPictureStyle.bigPicture != null) {
            android.util.Log.d("json2notification", "BigPictureStyle:bigPicture:" + simpleBigPictureStyle.bigPicture);
            try {
                Bitmap bigPicture = ImageLoader.getInstance().loadImageSync(
                        simpleBigPictureStyle.bigPicture);
                if (bigPicture != null) bigPictureStyle.bigPicture(bigPicture);
                android.util.Log.d("json2notification", "BigPictureStyle:bigPicture:bitmap:" + bigPicture);
            } catch (Exception e) {
            }
        }
        if (simpleBigPictureStyle.contentTitle != null) {
            android.util.Log.d("json2notification", "BigPictureStyle:contentTitle:" + simpleBigPictureStyle.contentTitle);
            bigPictureStyle.setBigContentTitle(simpleBigPictureStyle.contentTitle);
        }
        if (simpleBigPictureStyle.summaryText != null) {
            android.util.Log.d("json2notification", "BigPictureStyle:summaryText:" + simpleBigPictureStyle.summaryText);
            bigPictureStyle.setSummaryText(simpleBigPictureStyle.summaryText);
        }

        return bigPictureStyle;
    }

    @Override
    public void serialize(NotificationCompat.BigPictureStyle bigPictureStyle, String fieldName, boolean writeFieldNameForObject,
            JsonGenerator jsonGenerator) throws IOException {
        android.util.Log.d("json2notification", "BigPictureStyleConverter:serialize");
        if (bigPictureStyle == null) return;
        SimpleBigPictureStyle simpleBigPictureStyle = new SimpleBigPictureStyle();
        // TODO
        if (writeFieldNameForObject) jsonGenerator.writeFieldName(fieldName);
        SimpleBigPictureStyle$$JsonObjectMapper._serialize((SimpleBigPictureStyle) simpleBigPictureStyle, jsonGenerator, true);
    }
}
