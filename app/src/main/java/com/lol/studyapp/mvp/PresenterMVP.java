package com.lol.studyapp.mvp;

import android.util.Log;

public class PresenterMVP implements MVPListeners.Presenter {

    private static final String TAG = "Presenter";

    //Компоненты MVP приложения
    private MVPListeners.View view;
    private MVPListeners.Repository repository;

    //Сообщение
    private String message;

    //Обрати внимание на аргументы конструктора - мы передаем экземпляр View, а Repository просто создаём конструктором.
    public PresenterMVP(MVPListeners.View view) {
        this.view = view;
        this.repository = new RepositoryMVP();
    }

    @Override
    public void onButtonWasClicked() {
        message = repository.loadMessage();
        view.showText(message);
        Log.d(TAG, "onButtonWasClicked()");
    }

    @Override
    public void onDestroy() {
        /**
         * Если бы мы работали например с RxJava, в этом классе стоило бы отписываться от подписок
         * Кроме того, при работе с другими методами асинхронного андроида,здесь мы боремся с утечкой контекста
         */
        if (view != null)
            view = null;
        Log.d(TAG, "onDestroy()");
    }
}
