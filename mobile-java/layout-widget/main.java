
package com.example.widgetdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    CheckBox subscribeCheck;
    RadioGroup genderGroup;
    Spinner spinner;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        subscribeCheck = findViewById(R.id.subscribeCheck);
        genderGroup = findViewById(R.id.genderGroup);
        spinner = findViewById(R.id.spinner);
        submitButton = findViewById(R.id.submitButton);

        // Set spinner data from string array
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString();
                String gender = ((RadioButton) findViewById(genderGroup.getCheckedRadioButtonId())).getText().toString();
                String country = spinner.getSelectedItem().toString();
                boolean subscribed = subscribeCheck.isChecked();

                Toast.makeText(MainActivity.this,
                        "Name: " + name + "\nGender: " + gender +
                                "\nCountry: " + country +
                                "\nSubscribed: " + subscribed,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
