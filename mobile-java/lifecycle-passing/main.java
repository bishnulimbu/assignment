package com.example.lifecycleapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView lifecycleText;
    Button btnGo;
    final int REQUEST_CODE = 100;

    private void appendLifecycle(String event) {
        lifecycleText.append(event + "\n");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lifecycleText = findViewById(R.id.lifecycleText);
        btnGo = findViewById(R.id.btnGo);

        appendLifecycle("onCreate");

        btnGo.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("name", "Student");
            startActivityForResult(intent, REQUEST_CODE);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        appendLifecycle("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        appendLifecycle("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        appendLifecycle("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        appendLifecycle("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        appendLifecycle("onDestroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String result = data.getStringExtra("result");
            appendLifecycle("Returned: " + result);
        }
    }
}
