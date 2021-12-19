package com.lol.studyapp.mvvm;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.lol.studyapp.R;
import com.lol.studyapp.api_clients.ApiResponse;

public class ViewMVVM extends AppCompatActivity {

    private ViewModelMVVM viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);
        CustomViewModelFactory factory = new CustomViewModelFactory("param");
        viewModel = new ViewModelProvider(this, factory).get(ViewModelMVVM.class);
        viewModel.getResponse().observe(this, this::consumeResponse);
        viewModel.fetchApi();
//MyViewModel myViewModel = new ViewModelProvider(this, viewModelFactory).get(MyViewModel.class);
//        viewModel = new ViewModelProvider.ModelFactory(getApplication()).create(ViewModelMVVM.class);
    }


    private void consumeResponse (ApiResponse response) {
        switch (response.status) {
            case ERROR:
               // showToast(getString(R.string.errors));
                break;
            case SUCCESS:
//                try {
//                    renderResponse((Response) response.data.body());
//                    ((MainActivity)getActivity()).showPlayerOptions();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                break;
            default:
                break;
        }
    }


}
