package com.lol.studyapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.lol.studyapp.R;

public class FragmentC extends Fragment {

    private static final String[] text = new String[]{"FragmentA", "FragmentB", "FragmentC", "FragmentD", "FragmentE"};
    private static final int[] colors = new int[]{R.color.red, R.color.blue, R.color.green, R.color.cyan, R.color.yellow};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragments, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        TextView tvText = view.findViewById(R.id.tvText);
        ConstraintLayout container = view.findViewById(R.id.container);
        tvText.setText(text[2]);
        container.setBackground(ContextCompat.getDrawable(getActivity(), colors[2]));
    }
}
