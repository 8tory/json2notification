package com.infstory.notification.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.infstory.notification.Utils;

import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;

@Keep
@KeepClassMembers
@JsonObject
public class IntentModel implements ModelBuilder<Intent> {
    @JsonField
    public String action;
    @JsonField
    public String uri;

    @Override
    public Intent build(Object... objects) {
        android.util.Log.d("Notifications", "Intent build ");
        Context context = (Context) objects[0];

        Intent intent = new Intent();

        if (!Utils.isEmpty(action)) {
            intent.setAction(action);
        }
        if (!Utils.isEmpty(uri)) {
            intent.setData(Uri.parse(uri));
        }

        return intent;
    }
}

