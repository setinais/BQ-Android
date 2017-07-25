package br.edu.vinnicyus.espanglish.lib;

import com.activeandroid.ActiveAndroid;
import android.app.Application;

/**
 * Created by Vinnicyus on 05/07/2017.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate()
    {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ActiveAndroid.dispose();
    }
}
