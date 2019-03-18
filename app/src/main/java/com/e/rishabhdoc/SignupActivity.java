package com.e.rishabhdoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    private EditText editemail, editMobile, editPassword;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        editemail = findViewById(R.id.email);
        editMobile = findViewById(R.id.mobile);
        editPassword = findViewById(R.id.password);
        btnSignup = findViewById(R.id.signbutton);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });

    }

    public boolean validate() {
        boolean valid = true;


        String email = editemail.getText().toString();

        String mobile = editMobile.getText().toString();
        String password = editPassword.getText().toString();



        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editemail.setError("enter a valid email address");
            valid = false;
        } else {
            editemail.setError(null);
        }

        if (mobile.isEmpty() || mobile.length() != 10) {
            editMobile.setError("Enter Valid Mobile Number");
            valid = false;
        } else {
            editMobile.setError(null);
        }

        if (password.isEmpty() || password.length() <0 || password.length() > 10) {
            editPassword.setError("1 and 10 alphanumeric characters");
            valid = false;
        } else {
            editPassword.setError(null);
        }


        if (valid == true) {
            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Signup Failed", Toast.LENGTH_SHORT).show();
        }

        return valid;
    }


}

