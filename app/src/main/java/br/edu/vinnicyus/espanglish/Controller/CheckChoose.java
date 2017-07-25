package br.edu.vinnicyus.espanglish.Controller;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by Vinnicyus on 24/07/2017.
 */

public class CheckChoose {

    public CheckChoose(String rsp, String rst, TextView t)
    {
        radio_selected_pais = rsp;
        radio_selected_tipo = rst;
        tv = t;
    }

    private String radio_selected_pais;
    private String radio_selected_tipo;
    private TextView tv;



}
