package com.sheygam.java_18_01_03_18_hw_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        inputName = findViewById(R.id.input_name);
        findViewById(R.id.back_btn)
                .setOnClickListener(this);
        findViewById(R.id.next_btn)
                .setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.back_btn){
            finish();
        }else if(v.getId() == R.id.next_btn){
            String name = inputName.getText().toString();
            Intent intent = new Intent(this, EmailActivity.class);
            intent.putExtra("NAME",name);
            startActivityForResult(intent,1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == 1){
                setResult(RESULT_OK,data);
                finish();
            }
        }
    }
}
