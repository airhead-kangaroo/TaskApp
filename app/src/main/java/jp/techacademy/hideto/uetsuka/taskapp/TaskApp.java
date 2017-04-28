package jp.techacademy.hideto.uetsuka.taskapp;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Airhead-Kangaroo on 2017/04/25.
 */

public class TaskApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
