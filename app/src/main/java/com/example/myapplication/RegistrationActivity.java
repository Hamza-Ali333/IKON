package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrationActivity extends AppCompatActivity {
    TextView txt_singup;

    TextView txt_login;
    private ConstraintLayout layout;
    private boolean altLayout = false;
    private TextView textView6;
    EditText editText2;
    private Button btn_facebook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_screen);
        txt_singup = findViewById(R.id.signup);
        txt_login = findViewById(R.id.login);

        layout = findViewById(R.id.layout);
        editText2 = findViewById(R.id.editText2);
        textView6 = findViewById(R.id.textView6);
        btn_facebook = findViewById(R.id.facebook);

        editText2.setVisibility(View.GONE);
        textView6.setVisibility(View.GONE);

        btn_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistrationActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });

        txt_login.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (altLayout) {
                    txt_login.setTextColor(Color.parseColor("#EC5148"));
                    txt_singup.setTextColor(Color.parseColor("#A8A2A2"));
                    TransitionManager.beginDelayedTransition(layout);
                    editText2.setVisibility(View.GONE);
                    textView6.setVisibility(View.GONE);
                    altLayout = false;
                }
            }
        });

        txt_singup.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (!altLayout) {
                    txt_singup.setTextColor(Color.parseColor("#EC5148"));
                    txt_login.setTextColor(Color.parseColor("#A8A2A2"));
                    TransitionManager.beginDelayedTransition(layout);
                    editText2.setVisibility(View.VISIBLE);
                    textView6.setVisibility(View.VISIBLE);
                    altLayout = true;
                }
            }
        });

    }
}
