package com.example.viwa;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


public class ReadJson {


        /*StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //this.getJson();

        final Button Button = (Button) findViewById(R.id.button);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View t) {
                /*try {
                    readJson();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


    }*/


    /*public void readJson() throws JSONException {
        String json = getJson();
        //System.out.println("JSON: " + json);
        String jsonTemp = "";

        if (json != null) {
            try {
                JSONObject root = new JSONObject(json);
                JSONObject data = root.getJSONObject("description");

                for (int i = 0; i < data.length(); i++) {
                    //JSONObject dataentry = (JSONObject) data.get(1);
                    //JSONObject data1 = dataentry.getJSONObject("description");
                    jsonTemp = data.getString("en");
                    System.out.println(jsonTemp);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }*/

    /*public String getJson() {
        String response = null;
        try {
            URL url = new URL("https://fineli.fi/fineli/api/v1/components/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //HttpClient client = HttpClients.custom().build();
            /*HttpUriRequest request = RequestBuilder.get().setUri(SAMPLE_URL).setHeader(HttpHeaders.CONTENT_TYPE, "application/json").build();
            client.execute(request);*/
            /*HttpClient client = HttpClients.custom().build();
            HttpUriRequest request = RequestBuilder.get().setUri("https://fineli.fi/fineli/api/v1/components/").setHeader(HttpHeaders.description, "application/json").build();
            client.execute(request);*/

            /*InputStream input = new BufferedInputStream(connection.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            response = sb.toString();
            input.close();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }*/

}




