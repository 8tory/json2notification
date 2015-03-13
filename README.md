# Converter for JSON to Android Notification and Vice Versa

## Usage

```java
import android.app.Notification;
import com.infstory.notification.Notifications;

Notification n = Notifications.from(context).build(json);
```

### Input json format

```json
{
    "android": {
        "notification": {
            "contentTitle": "Sample Title",
            "contentText": "Sample content",
            "contentInfo": "sample info",
            "contentIntent": {
                "getActivity": true,
                "intent": {
                    "action": "android.intent.action.VIEW",
                    "uri": "https://play.google.com/store/apps/details?id=com.story8.android.gallery"
                }
            },
            "largeIcon": "http://8tory.com/images/logo.png",
            "smallIcon": "R.drawable.ic_stat_notify_story8",
            "bigPictureStyle": {
                "contentTitle": "Sample Big Picture Title",
                "summaryText": "Sample big picture text",
                "bigLargeIcon": "http://8tory.com/images/logo.png",
                "bigPicture": "http://8tory.com/images/logo.png"
            },
            "autoCancel": true
        }
    }
}
```

```text
{
   "android": {
       "notification": {
           "contentTitle": "String",
           "contentText": "String",
           "contentInfo": "String",
           "contentIntent": (PendingIntent{
               "start": ("broadcarst"|"activity"|"activities"|"service"),
               "intent": (Intent{}),
               "flags": (int),
               "options": (Bundle{}),
           }),
           "largeIcon": "String:url",
           "smallIcon": "String:url",
           "style": (BigPictureStyle{
               "contentTitle": "String",
               "contentText": "String",
               "contentInfo": "String",
               "summaryText": "String",
               "bigLargeIcon": "String:url",
               "bigPicture": "String:url",
               "contentIntent": (PendingIntent{
                   "start": ("broadcarst"|"activity"|"activities"|"service"),
                   "intent": (Intent{}),
                   "flags": (int),
                   "options": (Bundle{}),
               })
           })
           "autoCancel": (boolean)
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
