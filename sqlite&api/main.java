
package com.example.lifecycleapp;

import android.os.Bundle;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    DBHelper db;
    TextView sqliteText, apiText;
    Button loadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBHelper(this);

        sqliteText = findViewById(R.id.sqliteText);
        apiText = findViewById(R.id.apiText);
        loadButton = findViewById(R.id.loadButton);

        // Add data once (you can move this elsewhere or protect against duplicates)
        db.insertData("Alice");
        db.insertData("Bob");

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String allData = db.getAllNames();
                sqliteText.setText("SQLite Data:\n" + allData);
            }
        });

        new FetchDataTask().execute("https://jsonplaceholder.typicode.com/users");
    }

    class FetchDataTask extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... urls) {
            StringBuilder result = new StringBuilder();
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null)
                    result.append(line);
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result.toString();
        }

        protected void onPostExecute(String result) {
            try {
                JSONArray jsonArray = new JSONArray(result);
                StringBuilder display = new StringBuilder("API Users:\n");
                for (int i = 0; i < 3; i++) { // Only first 3 for brevity
                    JSONObject obj = jsonArray.getJSONObject(i);
                    display.append("- ").append(obj.getString("name")).append("\n");
                }
                apiText.setText(display.toString());
            } catch (Exception e) {
                apiText.setText("Failed to parse JSON");
                e.printStackTrace();
            }
        }
    }
}
