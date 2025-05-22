
package com.example.lifecycleapp;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

    public class MainActivity extends AppCompatActivity {

        Button btnSwitch, btnShowDialog;

        boolean showingA = true;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            btnSwitch = findViewById(R.id.btnSwitch);
            btnShowDialog = findViewById(R.id.btnShowDialog);

            // Show initial fragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new FragmentA())
                    .commit();

            btnSwitch.setOnClickListener(v -> {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                if (showingA) {
                    ft.replace(R.id.fragmentContainer, new FragmentB());
                } else {
                    ft.replace(R.id.fragmentContainer, new FragmentA());
                }
                showingA = !showingA;
                ft.commit();
            });

            btnShowDialog.setOnClickListener(v -> {
                MyDialogFragment dialog = new MyDialogFragment();
                dialog.show(getSupportFragmentManager(), "MyDialog");
            });

            registerForContextMenu(btnShowDialog); // Enable context menu on button
        }

        // 🔼 Options Menu
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.options_menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            Toast.makeText(this, "Selected: " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }

        // 🔽 Context Menu
        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            getMenuInflater().inflate(R.menu.context_menu, menu);
        }

        @Override
        public boolean onContextItemSelected(MenuItem item) {
            Toast.makeText(this, "Context Menu: " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }
    }
