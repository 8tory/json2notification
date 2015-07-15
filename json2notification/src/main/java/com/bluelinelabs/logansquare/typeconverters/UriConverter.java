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

import android.net.Uri;

public class UriConverter extends StringBasedTypeConverter<Uri> {

    @Override
    public Uri getFromString(String string) {
        return Uri.parse(string);
    }

    @Override
    public String convertToString(Uri uri) {
        android.util.Log.d("json2notification", "UriConverter:convertToString");
        return uri.toString();
    }

}
