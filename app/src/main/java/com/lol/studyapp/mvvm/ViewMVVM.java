package com.lol.studyapp.mvvm;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.lol.studyapp.R;
import com.lol.studyapp.api_clients.ApiResponse;
import com.lol.studyapp.mvvm.models.Pidor;
import com.lol.studyapp.mvvm.models.PidorList;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewMVVM extends AppCompatActivity {

    private ViewModelMVVM viewModel;

    private ProgressBar progressBar;
    private ImageView ivImage;
    private TextView tvFullName, tvPhone;
    private Button btnAction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);
        initViews();
        initMVVM();
    }

    private void initViews() {
        progressBar = findViewById(R.id.progressBar);
        ivImage = findViewById(R.id.ivImage);
        tvFullName = findViewById(R.id.tvFullName);
        tvPhone = findViewById(R.id.tvPhone);
        btnAction = findViewById(R.id.btnAction);
        btnAction.setOnClickListener( v -> {
            viewModel.fetchApi();
        });
    }

    private void initMVVM() {
        CustomViewModelFactory factory = new CustomViewModelFactory("param");
        viewModel = new ViewModelProvider(this, factory).get(ViewModelMVVM.class);
        viewModel.getResponse().observe(this, this::consumeResponse);
    }

    private void showLoader() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideLoader() {
        progressBar.setVisibility(View.GONE);
    }

    private void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void consumeResponse(ApiResponse response) {
        switch (response.status) {
            case LOADING:
                showLoader();
                break;
            case ERROR:
                hideLoader();
                showMsg("Ошибка при получение списка пидоров!");
                break;
            case SUCCESS:
                hideLoader();
                try {
                    if (response.data != null && response.data.body() != null) {
                        List<PidorList> pidorList = ((List<PidorList>) response.data.body());
                        if (pidorList.get(0).getManufacturer() != null) {
                            Pidor pidor = pidorList.get(0).getManufacturer();
                            if (pidor.getHomePage() != null)
                                Picasso.with(this).load(pidor.getHomePage()).resize(200, 200).into(ivImage);
                            if (pidor.getName() != null)
                                tvFullName.setText(pidor.getName());
                            if (pidor.getPhone() != null)
                                tvPhone.setText(pidor.getPhone());
                        }
                    }
                } catch (Exception e) {
                    showMsg("Ошибка при парсинге!");
                    e.printStackTrace();
                }
                break;
            case THROWABLE:
                showMsg("Неизвестная ошибка!");
                hideLoader();
                break;
            default:
                Log.d("TAG", "WTF?");
                hideLoader();
                break;
        }
    }


}
