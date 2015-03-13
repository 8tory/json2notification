package com.infstory.notification.debug;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;

public class Debugger {
    private String mTag = "AndroidNotificationJson";
    private Context mContext;
    private Boolean mIsDebuggable;

    public Debugger(Context context) {
        mContext = context;
        mIsDebuggable = isDebuggable(context);
    }

    public Debugger setTag(String tag) {
        mTag = tag;
        return this;
    }

    public void logT(String msg) {
        logT(mTag, msg);
    }

    public void logT(String tag, String msg) {
        if (mIsDebuggable) Log.d(tag, msg);
    }

    public void logT(Throwable tr) {
        logT("", tr);
    }

    public void logT(String msg, Throwable tr) {
        logT(mTag, "", tr);
    }

    public void logT(String tag, String msg, Throwable tr) {
        if (mIsDebuggable) Log.d(tag, msg, tr);
    }

    private boolean isDebuggable(Context context) {
        if (context == null) return false;
        return 0 != (context.getApplicationInfo().flags &= ApplicationInfo.FLAG_DEBUGGABLE);
    }
}
