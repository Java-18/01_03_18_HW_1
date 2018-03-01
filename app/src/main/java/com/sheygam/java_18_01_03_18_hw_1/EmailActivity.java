package com.sheygam.java_18_01_03_18_hw_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputEmail;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        inputEmail = findViewById(R.id.input_email);
        name = getIntent().getStringExtra("NAME");
        findViewById(R.id.back_btn)
                .setOnClickListener(this);
        findViewById(R.id.ok_btn)
                .setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.back_btn){
            finish();
        }else if(v.getId() == R.id.ok_btn){
            String email = inputEmail.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("NAME",name);
            intent.putExtra("EMAIL",email);
            setResult(RESULT_OK,intent);
            finish();
        }
    }
}
