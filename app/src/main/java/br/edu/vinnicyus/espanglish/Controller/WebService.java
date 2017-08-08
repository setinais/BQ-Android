package br.edu.vinnicyus.espanglish.Controller;



import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import br.edu.vinnicyus.espanglish.Model.Palco;
import br.edu.vinnicyus.espanglish.Model.Barraca;

/**
 * Created by Vinnicyus on 02/08/2017.
 */

public class WebService
{

    JSONObject params;

    public JSONObject getDados() throws JSONException {
        params = new JSONObject();
        getPalco();
        getBarraca();
        return params;
    }
    private void getBarraca() throws JSONException {
        List<Barraca> all_barraca = Barraca.getAll();

        for (int v=0;v<all_barraca.size();v++)
        {
            this.params.put("barraca"+v,all_barraca.get(v));
        }

    }

    private void getPalco() throws JSONException {

        List<Palco> all_palco = Palco.getAll();
        for (int v=0;v<all_palco.size();v++)
        {
            this.params.put("palco"+v,all_palco.get(v));
        }
    }

}
