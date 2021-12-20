package com.lol.studyapp.mvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.lol.studyapp.api_clients.ApiClient;
import com.lol.studyapp.api_clients.ApiResponse;
import io.reactivex.disposables.CompositeDisposable;

public class ViewModelMVVM extends ViewModel {

    private final RepositoryMVVM repository;
    private final CompositeDisposable disposable = new CompositeDisposable();
    private final MutableLiveData<ApiResponse> response = new MutableLiveData<ApiResponse>();
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
                        response.setValue(ApiResponse.success(result));
                    } else {
                        response.setValue(ApiResponse.error(result));
                    }
                    }, throwable -> {
                    response.setValue(ApiResponse.throwable(throwable));
                }

        ));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable.size() > 0)
            disposable.clear();
    }
}
