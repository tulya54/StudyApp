package com.lol.studyapp.fragments;

import android.os.Bundle;
import com.lol.studyapp.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragment);
    }
}
