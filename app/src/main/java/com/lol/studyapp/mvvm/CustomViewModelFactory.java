package com.lol.studyapp.mvvm;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class CustomViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private String param;

    public CustomViewModelFactory(String param) {
        this.param = param;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == ViewModelMVVM.class) {
            return (T) new ViewModelMVVM(param);
        }
        return null;
    }
}
