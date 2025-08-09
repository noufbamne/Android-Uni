package com.example.practical_05;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements TextWatcher{
    EditText e1, e2;
    Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.et1);
        e2 = findViewById(R.id.et2);
        bt1 = findViewById(R.id.bt1);
        bt1.setEnabled(true);

        e1.addTextChangedListener(this);
        e2.addTextChangedListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        bt1.setEnabled(!e1.getText().toString().isEmpty() &&
                !e2.getText().toString().isEmpty());
    }
    @Override
    public void afterTextChanged(Editable s) {
    }
    public void Login(View view) {
        if (e1.getText().toString().equals("Nouf") && e2.getText().toString().equals("0102")){
            Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }
}