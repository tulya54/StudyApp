package com.lol.studyapp.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.lol.studyapp.R;

public class FragmentReplaceActivity extends AppCompatActivity implements View.OnClickListener {

    private androidx.fragment.app.FragmentManager fragmentManager;
    private androidx.fragment.app.FragmentTransaction fragmentTransaction;
    private final Fragment[] fragments = new Fragment[]{new FragmentA(), new FragmentB(), new FragmentC(), new FragmentD(), new FragmentE()};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_replace);
        ((Button) findViewById(R.id.btnFragment1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnFragment2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnFragment3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnFragment4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnFragment5)).setOnClickListener(this);
    }

    @SuppressLint({"NonConstantResourceId"})
    @Override
    public void onClick(View view) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (view.getId()) {
            case R.id.btnFragment1:
                fragmentTransaction.replace(R.id.frame, fragments[0]).commit();
                break;
            case R.id.btnFragment2:
                fragmentTransaction.replace(R.id.frame, fragments[1]).commit();
                break;
            case R.id.btnFragment3:
                fragmentTransaction.replace(R.id.frame, fragments[2]).commit();
                break;
            case R.id.btnFragment4:
                fragmentTransaction.replace(R.id.frame, fragments[3]).commit();
                break;
            case R.id.btnFragment5:
                fragmentTransaction.replace(R.id.frame, fragments[4]).commit();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
