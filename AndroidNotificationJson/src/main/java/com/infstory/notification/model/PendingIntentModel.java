package com.infstory.notification.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.infstory.notification.Utils;

import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;

@Keep
@KeepClassMembers
@JsonObject
public class PendingIntentModel implements ModelBuilder<PendingIntent> {
    private static final String INTENT = "intent";

    @JsonField
    public Integer flags;
    @JsonField
    public Boolean getActivity;
    @JsonField
    public Boolean getService;
    @JsonField(name = INTENT)
    public IntentModel intentModel;
    @JsonField
    public Integer requestCode;

    @Override
    public PendingIntent build(Object... objects) {
        android.util.Log.d("Notifications", "PendingIntent build ");
        Context context = (Context) objects[0];

        PendingIntent pendingIntent = null;
        Intent intent = null;

        if (!Utils.isEmpty(intentModel)) intent = intentModel.build(context);

        if (Utils.isEmpty(intent)) return pendingIntent;

        if (!Utils.isEmpty(getActivity)) {
            pendingIntent = PendingIntent.getActivity(context, requestCode, intent, flags);
        } else if (!Utils.isEmpty(getService)) {
            pendingIntent = PendingIntent.getService(context, requestCode, intent, flags);
        }

        if (Utils.isEmpty(pendingIntent)) return pendingIntent;

        return pendingIntent;
    }
}

