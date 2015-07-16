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

package json2notification.app

import android.app.Activity
import android.app.AlertDialog
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.view.View
import android.view.View.OnClickListener

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.ArrayList
import android.app.Notification
import json2notification.Json2Notification

import android.content.Context
import android.app.Notification
import android.app.NotificationManager

import org.json.JSONObject
import org.json.JSONException
import json2notification.model.AndroidNotification
import android.widget.TextView

public class MainActivity : ActionBarActivity() {
    var notificationManager: NotificationManager? = null
    var jsonView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        jsonView = findViewById(R.id.json) as TextView

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val wikiJson = readFile("wiki.json")
        jsonView?.setText(wikiJson)
        object : AsyncTask<String, Void, Void>() {
            override fun doInBackground(vararg jsons: String): Void? {
                android.util.Log.d("json2notification-app", "json:" + jsons[0])

                //Notification n = Json2Notification.from(MainActivity.this).with(jsons[0]).notification();
                //notificationManager.notify(1, n);
                //android.util.Log.d("json2notification-app", "notify:" + n);

                val androidNotification = AndroidNotification.parse(this@MainActivity, jsons[0])
                android.util.Log.d("json2notification-app", "notify:" + androidNotification.android.notification)
                notificationManager?.notify(1, androidNotification.android.notification)
                android.util.Log.d("json2notification-app", "serialize:" + androidNotification.serialize())
                return null
            }
        }.execute(wikiJson)
    }

    private fun readFile(filename: String): String {
        val sb = StringBuilder()

        try {
            val json = getAssets().open(filename)
            val `in` = BufferedReader(InputStreamReader(json, "UTF-8"))

            /*
            var str: String?
            while ((str = `in`.readLine()) != null) {
                sb.append(str)
            }
            */
            var str: String?
            str = `in`.readLine()
            while (str != null) {
                sb.append(str)
                str = `in`.readLine()
            }

            `in`.close()
        } catch (e: Exception) {
            e.printStackTrace()
            AlertDialog.Builder(this).setTitle("Error").setMessage("The JSON file was not able to load properly. These tests won't work until you completely kill this demo app and restart it.").setPositiveButton("OK", null).show()
        }


        return sb.toString()
    }
}
