package com.lol.studyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lol.studyapp.activities.NextActivity;
import com.lol.studyapp.fragments.FragmentsActivity;
import com.lol.studyapp.mvp.ViewMVP;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button) findViewById(R.id.btnRecyclerView)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnData)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnThread)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnMVP)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnActivity)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnFragments)).setOnClickListener(this);

    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRecyclerView:
                startActivity(new Intent(this, RecyclerViewActivity.class));
                break;
            case R.id.btnData:
                startActivity(new Intent(this, DataActivity.class));
                break;
            case R.id.btnThread:
                startActivity(new Intent(this, ThreadActivity.class));
                break;
            case R.id.btnMVP:
                startActivity(new Intent(this, ViewMVP.class));
                break;
            case R.id.btnActivity:
                startActivity(new Intent(this, NextActivity.class));
                break;
            case R.id.btnFragments:
                startActivity(new Intent(this, FragmentsActivity.class));
                break;
        }
    }
}