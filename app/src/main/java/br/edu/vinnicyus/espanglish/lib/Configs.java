package br.edu.vinnicyus.espanglish.lib;

import android.app.LauncherActivity;

/**
 * Created by Vinnicyus on 26/06/2017.
 */

public class Configs {

    public String[][] jurados =
            {
                    {"Vinnicyus","02286373175","Espanhol"},
                    {"Iblayr","05053855110","Ingles"}
            };
    public String[][] paises =
            {
                    {"Espanha","1","Espanhol"},
                    {"México","2","Espanhol"},
                    {"Porto Rico","3","Espanhol"},
                    {"Bolívia","4","Espanhol"},
                    {"EUA","5","Ingles"},
                    {"Inglaterra","6","Ingles"},
                    {"Nova Zelândia","7","Ingles"},
                    {"Jamaica","8","Ingles"},
                    {"Irlanda","9","Ingles"},
                    {"África do Sul","0","Ingles"}
            };
    public static Configs getConfigs()
    {
        Configs c = new Configs();
        return c;
    }
}
