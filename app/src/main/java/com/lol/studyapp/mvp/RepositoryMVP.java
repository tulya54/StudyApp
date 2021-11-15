package com.lol.studyapp.mvp;

import android.util.Log;

public class RepositoryMVP implements MVPListeners.Repository {

    private static final String TAG = "Repository";

    private String result = "Sorry, you never go to the paradise 9(0";
    @Override
    public String loadMessage() {
        Log.d(TAG, "loadMessage()");
        /** Здесь обращаемся к БД или сети.
         * Я специально ничего не пишу, чтобы не загромождать пример
         * DBHelper'ами и прочими не относяшимеся к теме объектами.
         * Поэтому я буду возвращать строку Сосисочная =)
         */
        return result;
    }
}
