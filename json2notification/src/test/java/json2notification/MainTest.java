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

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.support.v4.app.FragmentActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import android.app.Notification;
import android.app.NotificationManager;

import org.json.JSONObject;
import org.json.JSONException;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.verify;
import android.app.PendingIntent;
import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import android.content.Intent;

import com.infstory.notification.BuildConfig;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
//@Config(manifest = Config.NONE)
public class MainTest {
    // support library fragments
    private FragmentActivity fragmentActivity;
    private android.support.v4.app.Fragment supportFragment;

    // native fragments
    private Activity activity;
    private Fragment fragment;

    @Mock
    private JSONObject json;

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
    public void parse() {
        Notification n = Json2Notification.from(context).with(rawJson).notification();
        System.out.println(n);
        assertThat(n).isNotNull();
        notificationManager.notify(1, n);
        //assertThat(shadowOf(notificationManager).getNotification(1)).isNull();
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
