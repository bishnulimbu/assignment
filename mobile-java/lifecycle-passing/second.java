
package com.example.lifecycleapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView nameText;
    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nameText = findViewById(R.id.nameText);
        btnReturn = findViewById(R.id.btnReturn);

        String name = getIntent().getStringExtra("name");
        nameText.setText("Hello, " + name + "!");

        btnReturn.setOnClickListener(v -> {
            Intent result = new Intent();
            result.putExtra("result", "Returned from SecondActivity");
            setResult(RESULT_OK, result);
            finish();
        });
    }
}
