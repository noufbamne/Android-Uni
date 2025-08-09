package com.example.practical_04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;
    Button bt1;
    String entered_username, entered_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.comp3);
        et2 = findViewById(R.id.comp5);
        bt1 = findViewById(R.id.comp6);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left , systemBars.top, systemBars.right, systemBars.bottom);

            return insets;
        });
    }

    public void try_login(View view) {
        entered_username = et1.getText().toString();
        entered_password = et2.getText().toString();
        if (entered_username.equals("Aaryan") && entered_password.equals("0102")){
            Toast.makeText(this,"Login Successful!",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Login Failed!",Toast.LENGTH_SHORT).show();

        }}}