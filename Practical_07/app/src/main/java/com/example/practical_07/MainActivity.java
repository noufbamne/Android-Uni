package com.example.practical_07;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    private EditText phoneNumberEditText;
    private Button callButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
        callButton = findViewById(R.id.callButton);

        callButton.setOnClickListener(v -> {
            String number = phoneNumberEditText.getText().toString().trim();

            if (number.isEmpty()) {
                Toast.makeText(this, "Please enter a phone number", Toast.LENGTH_SHORT).show();
            } else if (!number.matches("\\d{10}")) {
                // Check for exactly 10 digits
                Toast.makeText(this, "Enter a valid 10-digit phone number",
                        Toast.LENGTH_SHORT).show();
            } else {
                makePhoneCall(number);
            }
        });
    }

    private void makePhoneCall(String number) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) !=
                PackageManager.PERMISSION_GRANTED) {
            // Request permission
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},
                    1);
        } else {
            // Permission granted
            Toast.makeText(this, "Dialing " + number, Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1 && grantResults.length > 0 && grantResults[0] ==
                PackageManager.PERMISSION_GRANTED) {
            String number = phoneNumberEditText.getText().toString();
            if (number.matches("\\d{10}")) {
                makePhoneCall(number);
            } else {
                Toast.makeText(this, "Enter a valid 10-digit phone number",
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
        }
    }
}