package com.lol.studyapp.mvvm;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lol.studyapp.api_clients.ApiClient;
import com.lol.studyapp.api_clients.ApiResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ViewModelMVVM extends ViewModel {

    private RepositoryMVVM repository;
    private final CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<ApiResponse> response = new MutableLiveData<ApiResponse>();
    public MutableLiveData<ApiResponse> getResponse() {
        return response;
    }

    public ViewModelMVVM(String param) {
        repository = new RepositoryMVVM(ApiClient.getInstance());
    }

    public void fetchApi() {
        disposable.add(repository.fetchApi()
                .doOnSubscribe((disposable ->
                        response.setValue(ApiResponse.loading())
                ))
                .subscribe( result -> {
                    if (result.code() >= 200 && result.code() < 300) {
                        Log.d("TAG", "");
                    } else {
                        Log.d("TAG", "");
                    }
                    }, throwable -> {
                    Log.d("TAG", "");
                }

        ));
//        disposable.add(ApiClient.getInstance().apiService.getResult()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe((disposable -> response.setValue(ApiResponse.loading())))
//                .subscribe(result -> {
//                            if (result.code() >= 200 && result.code() < 300)
//                                response.setValue(ApiResponse.success(result));
//                            else
//                                response.setValue(ApiResponse.error(result));
//                        },
//                        throwable -> {}
//                ));
    }
}
