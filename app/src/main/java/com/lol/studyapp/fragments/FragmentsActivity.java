package com.lol.studyapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lol.studyapp.R;

public class FragmentsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);
        ((Button) findViewById(R.id.btnFragment)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnFragmentPager)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnFragmentAdd)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnFragmentReplace)).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFragment:
                startActivity(new Intent(this, MyFragmentActivity.class));
                break;
            case R.id.btnFragmentPager:
                startActivity(new Intent(this, FragmentPagerActivity.class));
                break;
            case R.id.btnFragmentAdd:
                startActivity(new Intent(this, FragmentAddActivity.class));
                break;
            case R.id.btnFragmentReplace:
                startActivity(new Intent(this, FragmentReplaceActivity.class));
                break;
        }
    }
}
