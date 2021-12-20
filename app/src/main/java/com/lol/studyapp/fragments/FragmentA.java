package com.lol.studyapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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

public class FragmentA extends Fragment {

    private static final String[] text = new String[]{"FragmentA", "FragmentB", "FragmentC", "FragmentD", "FragmentE"};
    private static final int[] colors = new int[]{R.color.red, R.color.blue, R.color.green, R.color.cyan, R.color.yellow};
    private static final String TAG = "FragmentA";
    private String param1;
    private String param2;

    public static FragmentA newInstance(String param1, String param2) {
        FragmentA fragmentA = new FragmentA();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragmentA.setArguments(args);
        return fragmentA;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
        //  фрагмент прикреплен к Activity и получает ссылку на него.
        // В дальнейшем мы всегда можем получить ссылку на Activity, вызвав метод getActivity().
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            param1 = getArguments().getString("param1", "defaultValue");
            param2 = getArguments().getString("param1", "defaultValue");
        }
        Log.d(TAG, "onCreate");
        //  это аналог метода onCreate у Activity, но здесь мы пока не имеем доступа к UI-элементам
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
      //  return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragments, container, false);
     //   initViews(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated");
        initViews(view);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
        //  Далее метод Activity – onStart, после него onStart – аналогичен методу Activity, фрагмент виден пользователю
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        //  Далее метод Activity – onResume, после него onResume - аналогичен методу Activity, фрагмент доступен для взаимодействия.
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        // Сначала для фрагментов и Activity вызываются методы onPause и onStop. Это значит,
        // что фрагменты и Activity более недоступны для взаимодействия, а потом не видны пользователю.
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
        // Сначала для фрагментов и Activity вызываются методы onPause и onStop. Это значит,
        // что фрагменты и Activity более недоступны для взаимодействия, а потом не видны пользователю.
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
        //  сообщает нам, что View, которое мы создавали в onCreateView, более недоступно
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        //   аналог метода onDestroy у Activity
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
        //  фрагмент отсоединен от Activity
    }

    private void initViews(View view) {
        TextView tvText = view.findViewById(R.id.tvText);
        ConstraintLayout container = view.findViewById(R.id.container);
        tvText.setText(text[0]);
        container.setBackground(ContextCompat.getDrawable(getActivity(), colors[0]));
    }
}
