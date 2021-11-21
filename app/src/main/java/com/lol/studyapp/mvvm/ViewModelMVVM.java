package com.lol.studyapp.mvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lol.studyapp.api_clients.ApiResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ViewModelMVVM extends ViewModel {

    private final CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<ApiResponse> response = new MutableLiveData<ApiResponse>();
    public MutableLiveData<ApiResponse> getResponse() {
        return response;
    }

    public ViewModelMVVM(String param) {

    }

    public void fetchApi() {
        disposable.add(repository.registerSocial(fn, ln, email, provId, proName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe((disposable -> responseSocial.setValue(ApiResponse.loading())))
                .subscribe(
                        result -> {
                            if (result.code() >= 200 && result.code() < 300)
                                responseSocial.setValue(ApiResponse.success(result));
                            else
                                responseSocial.setValue(ApiResponse.error(result));
                        },
                        throwable -> {}
                ));
    }
}
