package com.example.validation;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button submitButton;
    private TextView errorTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        emailEditText = findViewById(R.id.editTextEmail);
        passwordEditText = findViewById(R.id.editTextPassword);
        submitButton = findViewById(R.id.buttonSubmit);
        errorTextView = findViewById(R.id.textViewError);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInputs();
            }
        });
    }
    private void validateInputs() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        errorTextView.setText("");
        if (TextUtils.isEmpty(email)) {
            errorTextView.setText("Email cannot be empty");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            errorTextView.setText("Invalid email address");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            errorTextView.setText("Password cannot be empty");
            return;
        }
        if (password.length() < 6) {
            errorTextView.setText("Password must be at least 6 characters");
            return;
        }

        Toast.makeText(MainActivity.this, "Validation Successful", Toast.LENGTH_SHORT).show();
    }
}

