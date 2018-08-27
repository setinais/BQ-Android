package br.edu.vinnicyus.espanglish.lib;

import android.app.LauncherActivity;

/**
 * Created by Vinnicyus on 26/06/2017.
 */

public class Configs {

    public String[][] jurados =
            {
                    {"Divone","20181","Ingles"},
                    {"Flavia","20182","Ingles"},
                    {"Leandro","20183","Ingles"},
                    {"Lucelia","20184","Ingles"},

                    {"Pedro","20185","Espanhol"},
                    {"Jhennefer","20186","Espanhol"},
                    {"Danilo","20187","Espanhol"},
                    {"Itamara","20188","Espanhol"},
            };
    public String[][] paises =
            {
                    {"Chile","181","Espanhol"},
                    {"Cuba","182","Espanhol"},
                    {"Espanha","183","Espanhol"},
                    {"EUA","184","Ingles"},
                    {"Inglaterra","185","Ingles"},
                    {"Filipinas","186","Ingles"},
            };
    public static Configs getConfigs()
    {
        Configs c = new Configs();
        return c;
    }
}
