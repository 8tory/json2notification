package com.infstory.notification;

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
}
