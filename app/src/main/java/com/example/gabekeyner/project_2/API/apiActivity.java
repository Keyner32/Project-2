package com.example.gabekeyner.project_2.API;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Selection;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gabekeyner.project_2.R;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class apiActivity extends AppCompatActivity {

    public static final String API_URL ="http://localhost:3000/api/drinks";

    private ArrayAdapter<Selection> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        adapter = new ArrayAdapter<Selection>(this, android.R.layout.simple_list_item_1, new ArrayList<Selection>());
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);


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


    private class DownloadURLTask extends AsyncTask<String,Void,APISearchResult>{

        @Override
        protected APISearchResult doInBackground(String... params) {

            String data = null;
            InputStream inStream = null;

            URL url = null;

            HttpURLConnection connection = null;
            try {
                url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                inStream = connection.getInputStream();
                data = getInputData(inStream);
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            Gson gson = new Gson();
            APISearchResult apiSearchResult = gson.fromJson(data, APISearchResult.class);
            return apiSearchResult;
        }
        @Override
        protected void onPostExecute(APISearchResult apiSearchResult) {

            adapter.clear();
            adapter.addAll(apiSearchResult.getList());
            super.onPostExecute(apiSearchResult);
        }

        private String getInputData (InputStream inStream)throws IOException {
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));

            String data = null;

            while ((data = reader.readLine()) != null){
                builder.append(data);
            }

            reader.close();

            return builder.toString();
        }
    }
}
