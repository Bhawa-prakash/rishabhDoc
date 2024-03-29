package com.e.rishabhdoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText _editMobile, _editPassword;
    private TextView newUser;
    private Button _loginbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        _editMobile = findViewById(R.id.email);
        _editPassword = findViewById(R.id.password);
        newUser = findViewById(R.id.newuser);

         _loginbtn = (Button) findViewById(R.id.loginbutton);

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(i);
            }
        });
        _loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validation();

            }
        });


    }

    private void Validation() {
        String mobile_str, pass_str;

        boolean check = true;
        mobile_str = _editMobile.getText().toString();
        pass_str = _editPassword.getText().toString();

        if (TextUtils.isEmpty(mobile_str.trim()) || mobile_str.length() == 0) {

            _editMobile.setError("Please enter valid email");
            check = false;


        }
        if (TextUtils.isEmpty(pass_str.trim()) || pass_str.length() == 0) {
            _editPassword.setError("Please enter valid password");
            check = false;


        }

        if (check == true) {
            /*Intent intent = new Intent(LoginActivity.this, NavigationActivity.class);
            startActivity(intent);*/
        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }


    }
}
