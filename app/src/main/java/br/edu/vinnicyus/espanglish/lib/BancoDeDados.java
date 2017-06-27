package br.edu.vinnicyus.espanglish.lib;


import com.activeandroid.ActiveAndroid;

/**
 * Created by Vinnicyus on 26/06/2017.
 */

public class BancoDeDados extends com.activeandroid.app.Application{

    @Override
    public void onCreate()
    {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }

    @Override
    public void onTerminate()
    {
        ActiveAndroid.dispose();
    }
}
