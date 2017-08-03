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
                    {"Espanha","espanha32","Espanhol"},
                    {"México","mexico32","Espanhol"},
                    {"Porto Rico","portorico32","Espanhol"},
                    {"Bolívia","bolivia32","Espanhol"},
                    {"EUA","eua32","Ingles"},
                    {"Inglaterra","inglaterra32","Ingles"},
                    {"Nova Zelândia","novazelandia32","Ingles"},
                    {"Jamaica","jamaica32","Ingles"},
                    {"Irlanda","irlanda32","Ingles"},
                    {"África do Sul","africadosul32","Ingles"}
            };
    public static Configs getConfigs()
    {
        Configs c = new Configs();
        return c;
    }
}
