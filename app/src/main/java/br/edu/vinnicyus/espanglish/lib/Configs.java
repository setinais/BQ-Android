package br.edu.vinnicyus.espanglish.lib;

import android.app.LauncherActivity;

/**
 * Created by Vinnicyus on 26/06/2017.
 */

public class Configs {

    public String[][] jurados =
            {
                    {"vinnicyus","02286373175","Espanhol"},
                    {"iblayr","05053855110","Ingles"}
            };
    public String[][] paises =
            {
                    {"África do Sul","1","Ingles"},
                    {"Bolívia","2","Espanhol"},
                    {"Espanha","3","Espanhol"},
                    {"EUA","4","Ingles"},
                    {"Inglaterra","5","Ingles"},
                    {"Jamaica","6","Ingles"},
                    {"México","7","Espanhol"},
                    {"Nova Zelândia","8","Ingles"},
                    {"Porto Rico","9","Espanhol"}
            };
    public static Configs getConfigs()
    {
        Configs c = new Configs();
        return c;
    }
}
