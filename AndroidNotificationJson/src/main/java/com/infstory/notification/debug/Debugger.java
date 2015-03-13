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
