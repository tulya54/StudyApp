package com.lol.studyapp.mvp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.lol.studyapp.R;

public class ViewMVP extends AppCompatActivity implements MVPListeners.View {

    private static final String TAG = "View";

    private MVPListeners.Presenter presenter;

    private TextView tvText;
    private Button btnButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        tvText = findViewById(R.id.tvText);
        btnButton = findViewById(R.id.btnButton);

        //Создаём Presenter и в аргументе передаём ему this - эта Activity расширяет интерфейс MainContract.View
        presenter = new PresenterMVP(this);

        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonWasClicked();
            }
        });
        Log.d(TAG, "onCreate()");
    }

    @Override
    public void showText(String message) {
        tvText.setText(message);
        Log.d(TAG, "showMessage()");
    }

    //Вызываем у Presenter метод onDestroy, чтобы избежать утечек контекста и прочих неприятностей.
    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
        Log.d(TAG, "onDestroy()");
    }
}
