package com.lol.studyapp.fragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentPagerAdapter extends FragmentStateAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final FragmentA fragmentA = new FragmentA();
    private final FragmentB fragmentB = new FragmentB();
    private final FragmentC fragmentC = new FragmentC();
    private final FragmentD fragmentD = new FragmentD();
    private final FragmentE fragmentE = new FragmentE();


    public FragmentPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        addFragments();
    }

    private void addFragments() {
        fragmentList.add(fragmentA);
        fragmentList.add(fragmentB);
        fragmentList.add(fragmentC);
        fragmentList.add(fragmentD);
        fragmentList.add(fragmentE);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }
}
