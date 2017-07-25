package br.edu.vinnicyus.espanglish.lib;

import android.app.LauncherActivity;

/**
 * Created by Vinnicyus on 26/06/2017.
 */

public class Configs {

    public String[][] jurados =
            {
                    {"Vinnicyus","02286373175","Espanhol"},
                    {"Mauricio","35001941172","Ingles"}
            };
    public String[][] paises =
            {
                    {"Espanha","espanha32","Espanhol"},
                    {"Estados Unidos","usa32","Espanhol"}
            };
    public static Configs getConfigs()
    {
        Configs c = new Configs();
        return c;
    }
}
