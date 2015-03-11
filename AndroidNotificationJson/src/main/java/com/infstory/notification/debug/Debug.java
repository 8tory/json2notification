package com.infstory.notification.debug;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;

public class Debug {
    public static final String TAG = "AndroidNotificationJson";
    public static Context sContext;
    private static Boolean sIsDebuggable;

    public static void logT(String msg) {
        logT(TAG, msg);
    }

    public static void logT(String tag, String msg) {
        if (isDebuggable()) Log.d(tag, msg);
    }

    public static void logT(Throwable tr) {
        logT("", tr);
    }

    public static void logT(String msg, Throwable tr) {
        logT(TAG, "", tr);
    }

    public static void logT(String tag, String msg, Throwable tr) {
        if (isDebuggable()) Log.d(tag, msg, tr);
    }

    private static boolean isDebuggable() {
        if (sContext == null) {
            return false;
        } else {
            if (sIsDebuggable == null) {
                sIsDebuggable = (0 != (sContext.getApplicationInfo().flags
                        &= ApplicationInfo.FLAG_DEBUGGABLE));
            }
            return sIsDebuggable.booleanValue();
        }
    }
}
