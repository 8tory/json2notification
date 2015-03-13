package com.infstory.notification;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;

public class Utils {
    public static boolean isEmpty(Object o) {
        if (o == null) return true;
        if (o instanceof String) {
            String s = (String) o;
            if (s.equalsIgnoreCase("null")) return true;
            return TextUtils.isEmpty(s);
        }
        return false;
    }

    public static int getDrawableId(Context context, String idString) {
        return context.getResources().getIdentifier(idString, "drawable", context.getPackageName());
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
