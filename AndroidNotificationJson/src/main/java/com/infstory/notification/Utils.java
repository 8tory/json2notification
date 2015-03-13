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

    public static int getDrawableId(Context context, String resString) {
        android.util.Log.d("Notifications", "resString: " + resString);
        android.util.Log.d("Notifications", "PackageName: " + context.getPackageName());
        resString = resString.replace("R.drawable.", "");
        return context.getResources().getIdentifier(resString, "drawable", context.getPackageName());
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
