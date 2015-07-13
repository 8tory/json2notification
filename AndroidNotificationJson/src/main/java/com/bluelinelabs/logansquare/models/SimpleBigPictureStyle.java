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

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;


/**
 * <pre>
 * "bigPictureStyle": {
 *     "contentTitle": "Sample Big Picture Title",
 *     "summaryText": "Sample big picture text",
 *     "bigLargeIcon": "http://8tory.com/images/logo.png",
 *     "bigPicture": "http://8tory.com/images/logo.png"
 * },
 * </pre>
 */
@Keep
@KeepClassMembers
@JsonObject
public class SimpleBigPictureStyle {
    @JsonField
    public String bigLargeIcon;
    @JsonField
    public String bigPicture;
    @JsonField
    public String contentTitle;
    @JsonField
    public String summaryText;
}
