package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;

import com.bluelinelabs.logansquare.models.*;

import android.support.v4.app.NotificationCompat;

public class BigPictureStyleConverter implements TypeConverter<NotificationCompat.BigPictureStyle> {
    @Override
    public NotificationCompat.BigPictureStyle parse(JsonParser jsonParser) throws IOException {
        SimpleBigPictureStyle simpleBigPictureStyle = SimpleBigPictureStyle$$JsonObjectMapper._parse(jsonParser);
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();

        if (simpleBigPictureStyle.bigLargeIcon != null) {
            try {
                Bitmap bigLargeIcon = ImageLoader.getInstance().loadImageSync(
                        simpleBigPictureStyle.bigLargeIcon);
                if (bigLargeIcon != null) bigPictureStyle.bigLargeIcon(bigLargeIcon);
            } catch (Exception e) {
            }
        }
        if (simpleBigPictureStyle.bigPicture != null) {
            try {
                Bitmap bigPicture = ImageLoader.getInstance().loadImageSync(
                        simpleBigPictureStyle.bigPicture);
                if (bigPicture != null) bigPictureStyle.bigPicture(bigPicture);
            } catch (Exception e) {
            }
        }
        if (simpleBigPictureStyle.contentTitle != null) {
            bigPictureStyle.setBigContentTitle(simpleBigPictureStyle.contentTitle);
        }
        if (simpleBigPictureStyle.summaryText != null) {
            bigPictureStyle.setSummaryText(simpleBigPictureStyle.summaryText);
        }

        return bigPictureStyle;
    }

    @Override
    public void serialize(NotificationCompat.BigPictureStyle bigPictureStyle, String fieldName, boolean writeFieldNameForObject,
            JsonGenerator jsonGenerator) throws IOException {
        // SimpleBigPictureStyle simpleBigPictureStyle = new SimpleBigPictureStyle();
        // TODO
        // SimpleBigPictureStyle$$JsonObjectMapper._serialize((SimpleBigPictureStyle) simpleBigPictureStyle, jsonGenerator, true);
    }
}
