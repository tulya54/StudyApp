package com.lol.studyapp.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.lol.studyapp.R;

public class FragmentAddActivity extends AppCompatActivity implements View.OnClickListener {

    private androidx.fragment.app.FragmentManager fragmentManager;
    private androidx.fragment.app.FragmentTransaction fragmentTransaction;
    private final Fragment[] fragments = new Fragment[]{new FragmentA(), new FragmentB(), new FragmentC(), new FragmentD(), new FragmentE()};
    private final String[] TAGS = new String[]{"FragmentA", "FragmentB", "FragmentC", "FragmentD", "FragmentE"};
    private int position = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_add);
        ((Button) findViewById(R.id.btnAdd)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnBack)).setOnClickListener(this);
    }

    @SuppressLint({"NonConstantResourceId"})
    public void onClick(View v) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.btnAdd:
                if (position < 5) {
                    //  если Add, то вызываем метод add, в который передаем
                    //  id контейнера (тот самый FrameLayout из main.xml) и объект фрагмента.
                    //  В итоге, в контейнер будет помещен Fragment1
              //      fragmentTransaction.add(R.id.frame, fragments[position], TAGS[position]);
                    fragmentTransaction.add(R.id.frame, fragments[position]);
                    fragmentTransaction.addToBackStack(TAGS[position]);
                    fragmentTransaction.commit();
                    position++;
                }
                break;
            case R.id.btnBack:

                onBackPressed();
                break;
            default:
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



        // если Remove, то вызываем метод remove, в который передаем объект фрагмента,
        // который хотим убрать. В итоге, фрагмент удалится с экрана.
//        switch (position) {
//            case 1:
//                position--;
//                FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag(TAGS[position]);
//                if (fragmentA != null) {
//                    fragmentTransaction.remove(fragments[position]);
//                    fragmentTransaction.commit();
//                }
//                break;
//            case 2:
//                position--;
//                FragmentB fragmentB = (FragmentB) fragmentManager.findFragmentByTag(TAGS[position]);
//                if (fragmentB != null) {
//                    fragmentTransaction.remove(fragments[position]);
//                    fragmentTransaction.commit();
//                }
//                break;
//            case 3:
//                position--;
//                FragmentC fragmentC = (FragmentC) fragmentManager.findFragmentByTag(TAGS[position]);
//                if (fragmentC != null) {
//                    fragmentTransaction.remove(fragments[position]);
//                    fragmentTransaction.commit();
//                }
//                break;
//            case 4:
//                position--;
//                FragmentD fragmentD = (FragmentD) fragmentManager.findFragmentByTag(TAGS[position]);
//                if (fragmentD != null) {
//                    fragmentTransaction.remove(fragments[position]);
//                    fragmentTransaction.commit();
//                }
//                break;
//            case 5:
//                position--;
//                FragmentE fragmentE = (FragmentE) fragmentManager.findFragmentByTag(TAGS[position]);
//                if (fragmentE != null) {
//                    fragmentTransaction.remove(fragments[position]);
//                    fragmentTransaction.commit();
//                }
//                break;
//        }
    }
}
