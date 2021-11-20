package com.lol.studyapp.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.lol.studyapp.R;

public class FragmentPagerActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_pager);
        adapter = new FragmentPagerAdapter(this);
        viewPager2 = findViewById(R.id.viewPager2);
        viewPager2.setAdapter(adapter);
    }
}
