package com.lol.studyapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.lol.studyapp.adapters.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;

    private final List<String> arrayList = new ArrayList<>();

    private final List<String> list = new ArrayList<>(Arrays.asList(
            "Test text 1", "Test text 2", "Test text 3", "Test text 4",
            "Test text 5", "Test text 6", "Test text 7",
            "Test text 8", "Test text 9", "Test text 10"));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_activity);
        initRecyclerView();
    //    initLinearLayout();
    }

    private void initRecyclerView() {
        adapter = new RecyclerViewAdapter(this);
        String[] stringArray = getResources().getStringArray(R.array.my_string_array);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);

        //  Res
//        for (int i = 0; i < stringArray.length; i++) {
//            arrayList.add(stringArray[i]);
//        }

        //  Constant
     //   arrayList.addAll(list);


        if (arrayList.size() == 0)
            return;
        adapter.setData(arrayList);
    }

    private void initLinearLayout() {
        LinearLayout container = findViewById(R.id.container);

        for (int i = 0; i < list.size(); i++) {
            TextView textView = new TextView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            textView.setText(list.get(i));
            textView.setTextSize(16f);
            textView.setTextColor(Color.BLACK);
            textView.setGravity(Gravity.CENTER);
            textView.setMinHeight(50);


            container.addView(textView, params);
        }
    }
}
