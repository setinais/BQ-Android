package br.edu.vinnicyus.espanglish.Controller;


import br.edu.vinnicyus.espanglish.Model.Barraca;
import br.edu.vinnicyus.espanglish.Model.Palco;

/**
 * Created by Vinnicyus on 02/08/2017.
 */

public class WebService {

    private String retorno_server;

    public WebService(String retorno_server)
    {
        this.retorno_server = retorno_server;
    }

    public void tratramentoDados()
    {
        String[] partes = this.retorno_server.split ("[{]+", -1);
        String[] barraca = partes[1].split("[(]",-1);
        atualizarStatusBarraca(barraca[1]);
        String[] palco = partes[2].split("[(]",-1);
        atualizarStatusPalco(palco[1]);
    }

    private void atualizarStatusBarraca(String dados)
    {
        String[] explode_dados = dados.split("[;]",-1);
        Barraca barraca;
        int t = explode_dados.length -1;
        for (int v=0;v<t;v++)
        {
            barraca = Barraca.getVotos(explode_dados[v]);
            barraca.setStatus_envio(1);
            barraca.save();
        }
    }

    private void atualizarStatusPalco(String dados)
    {
        String[] explode_dados = dados.split("[;]",-1);
        Palco palco;
        for (int v=0;v<explode_dados.length -1;v++)
        {
            palco = Palco.getVotos(explode_dados[v]);
            palco.setStatus_envio(1);
            palco.save();
        }
    }
}