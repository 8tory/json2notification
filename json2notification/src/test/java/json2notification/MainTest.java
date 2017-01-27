/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package json2notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.infstory.notification.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainTest {
    private String rawJson = "{" +
                                   "\"android\": {" +
                                       "\"notification\": {" +
                                           "\"contentTitle\": \"contentTitle\"," +
                                           "\"contentText\": \"contentText\"," +
                                           "\"contentInfo\": \"contentInfo\"," +
                                           "\"contentIntent\": {" +
                                               "\"start\": \"activity\"," +
                                               "\"intent\": {" +
                                                    "\"action\" : \"android.intent.action.VIEW\"," +
                                                    "\"data\" : {" +
                                                        "\"scheme\" : \"http\"," +
                                                        "\"opaquePart\" : \"//wikipedia.org\"," +
                                                        "\"authority\" : \"wikipedia.org\"," +
                                                        "\"path\" : \"/wiki/Christmas\"," +
                                                        "\"query\" : \"\"," +
                                                        "\"fragment\" : \"\"" +
                                                    "}," +
                                                    "\"dataString\" : \"http://wikipedia.org/wiki/Christmas\"," +
                                                    "\"flags\" : 0," +
                                                    "\"scheme\" : \"http\"," +
                                                    "\"excludingStopped\" : false" +
                                               "}," +
                                               "\"flags\": 0," +
                                               "\"options\": null" +
                                           "}," +
                                           "\"largeIcon\": \"largeIcon\"," +
                                           "\"smallIcon\": \"smallIcon\"," +
                                           "\"style\": {" +
                                               "\"contentTitle\": \"contentTitle\"," +
                                               "\"contentText\": \"contentText\"," +
                                               "\"contentInfo\": \"contentInfo\"," +
                                               "\"summaryText\": \"summaryText\"," +
                                               "\"bigLargeIcon\": \"bigLargeIcon\"," +
                                               "\"bigPicture\": \"bigPicture\"," +
                                               "\"contentIntent\": {" +
                                                   "\"start\": \"activity\"," +
                                                   "\"intent\": {" +
                                                        "\"action\" : \"android.intent.action.VIEW\"," +
                                                        "\"data\" : {" +
                                                            "\"scheme\" : \"http\"," +
                                                            "\"opaquePart\" : \"//wikipedia.org\"," +
                                                            "\"authority\" : \"wikipedia.org\"," +
                                                            "\"path\" : \"/wiki/Christmas\"," +
                                                            "\"query\" : \"\"," +
                                                            "\"fragment\" : \"\"" +
                                                        "}," +
                                                        "\"dataString\" : \"http://wikipedia.org/wiki/Christmas\"," +
                                                        "\"flags\" : 0," +
                                                        "\"scheme\" : \"http\"," +
                                                        "\"excludingStopped\" : false" +
                                                   "}," +
                                                   "\"flags\": 0," +
                                                   "\"options\": null" +
                                               "}" +
                                           "}," +
                                           "\"autoCancel\": true" +
                                       "}" +
                                   "}" +
                                "}";

    NotificationManager notificationManager;
    Context context;

    @Before
    public void setup() {
        notificationManager = (NotificationManager) RuntimeEnvironment.application.getSystemService(Context.NOTIFICATION_SERVICE);
        context = RuntimeEnvironment.application.getApplicationContext();
    }

    @Test
    public void testParse() {
        Notification n = Json2Notification.from(context).with(rawJson).notification();
        System.out.println(n);
        assertThat(n).isNotNull();
    }

    @Test
    public void testNotify() {
        Json2Notification.from(context).with(rawJson).notify(1);
        assertThat(shadowOf(notificationManager).getNotification(1)).isNotNull();
    }

    @Test
    public void testSerialize() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Notification notification = new NotificationCompat.Builder(context)
            .setContentTitle("Hello World!")
            .setContentText("Hello World!")
            .setContentIntent(PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT))
            .build();

        String json = Json2Notification.from(context).with(notification).serialize();
        System.out.println(json);
        assertThat(json).isNotNull();
    }
}
