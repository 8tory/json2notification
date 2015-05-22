# Convert JSON to Android Notification

[![Join the chat at https://gitter.im/8tory/AndroidNotificationJson](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/8tory/AndroidNotificationJson?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

This is very useful for push notification (GCM).

## Usage

### Sample code

```java
import android.app.Notification;
import com.infstory.notification.Notifications;

Notification n = Notifications.from(context).build(json);
```

#### Input json format

```json
{
    "android": {
        "notification": {
            "autoCancel": true,
            "bigPictureStyle": {
                "contentTitle": "Sample Big Picture Title",
                "summaryText": "Sample big picture text",
                "bigLargeIcon": "http://8tory.com/images/logo.png",
                "bigPicture": "http://8tory.com/images/logo.png"
            },
            "contentInfo": "sample info",
            "contentIntent": {
                "getActivity": true,
                "intent": {
                    "action": "android.intent.action.VIEW",
                    "uri": "https://play.google.com/store/apps/details?id=com.story8.android.gallery"
                }
            },
            "contentText": "Sample content",
            "contentTitle": "Sample Title",
            "deleteIntent": {
                "getActivity": true,
                "intent": {
                    "action": "android.intent.action.VIEW",
                    "uri": "https://play.google.com/store/apps/details?id=com.story8.android.gallery"
                }
            },
            "largeIcon": "http://8tory.com/images/logo.png",
            "smallIcon": "R.drawable.ic_stat_notify_story8",
            "sound": "content://settings/system/notification_sound"
        }
    }
}
```

## LICENSE

```
Copyright 2015 8tory, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
