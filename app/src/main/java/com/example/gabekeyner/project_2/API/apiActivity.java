package com.example.gabekeyner.project_2.API;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gabekeyner.project_2.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class apiActivity extends AppCompatActivity {

    public static final String API_URL ="https://salty-peak-57677.herokuapp.com/api/drinks";

    private TextView drinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);


     drinks = (TextView) findViewById(R.id.listView);


        Button button = (Button)findViewById(R.id.show_api);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConnectivityManager connMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo netFo = connMgr.getActiveNetworkInfo();
                if (netFo != null && netFo.isConnected()) {

                    new DownloadURLTask().execute(API_URL);
                }else {
                    Toast.makeText(apiActivity.this, "No network connection detected",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private String downloadURL (String myURL)throws IOException,JSONException {
        InputStream inStream = null;
        try {
            java.net.URL url = new URL(myURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();
            inStream = conn.getInputStream();
            String contentAsString = readIt(inStream);
            String processedJson = parseJson(contentAsString);
           return  processedJson;
        }finally {
            if(inStream !=null) {
                inStream.close();
            }
        }

    }

    private String parseJson(String contentAsString)throws JSONException {
        StringBuilder drinkList = new StringBuilder();
        JSONArray array = new JSONArray(contentAsString);
        for (int i = 0; i<array.length(); i++){
            JSONObject drink = array.getJSONObject(i);
            String drinkName = drink.getString("drinkName");
            String alcoholType = drink.getString("alcoholType");
            Long abvPercent = drink.getLong("abvPercent");
            String drinkDescription = drink.getString("drinkDescription");
            drinkList.append(drinkName);
            drinkList.append("\n"+ alcoholType);
            drinkList.append("\n"+ abvPercent);
            drinkList.append("\n"+ drinkDescription+"\n" +"\n");
        }
        return drinkList.toString();
    }


    private class DownloadURLTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... urls) {
            try {
                return downloadURL(urls[0]);
            }catch (IOException e){
                Log.d("IOException", e.getMessage());
                return "Unable to retrieve web page. URL may be invalid";
            }catch (JSONException e){
                return "JSON parsing issue: " + e.getMessage();
            }
        }
        @Override
        protected void onPostExecute(String result) {

            drinks.setText(result);
        }

    }
    public String readIt (InputStream inStream)throws IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));

        String read;

        while ((read = reader.readLine()) != null){
            builder.append(read);
        }

        return builder.toString();
    }
}
