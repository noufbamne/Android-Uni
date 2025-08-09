package com.example.practical_06;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast; // <-- Toast import added
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText Et1, Et2;
    Button Bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Et1 = findViewById(R.id.et1);
        Et2 = findViewById(R.id.et2);
        Bt = findViewById(R.id.bt1);

        Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Submit(v);
            }
        });
    }

    public void Submit(View view) {
        if (Et1.getText().toString().equals("Nouf") && Et2.getText().toString().equals("0102")) {
            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.google.com"));
            startActivity(i);
        } else {
            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }
}