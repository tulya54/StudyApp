package com.lol.studyapp.mvvm;

import android.annotation.SuppressLint;
import com.lol.studyapp.api_clients.ApiClient;
import com.lol.studyapp.mvvm.models.PidorList;
import java.util.List;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class RepositoryMVVM {

    private final ApiClient apiClient;

    public RepositoryMVVM(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @SuppressLint("CheckResult")
    public Observable<Response<List<PidorList>>> fetchApi() {
        return Observable.create( callBack -> {
            apiClient.apiService.getResult()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe((disposable -> callBack.isDisposed()))
                    .subscribe(  result -> {
                            callBack.onNext(result);
                            callBack.onComplete();

                             },  callBack::onError

                    );
        });
    }
}
