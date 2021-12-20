package com.lol.studyapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lol.studyapp.DataActivity;
import com.lol.studyapp.R;

public class NextActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                startActivity(new Intent(this, FirstActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(this, SecondActivity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(this, ThirdActivity.class));
                break;

        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 666);

        ((TextView) findViewById(R.id.textView)).setText(String.valueOf(id));

        ((Button) findViewById(R.id.btn1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn3)).setOnClickListener(this);
    }
}
