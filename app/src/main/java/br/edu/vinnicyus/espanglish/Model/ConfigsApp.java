package br.edu.vinnicyus.espanglish.Model;


import com.activeandroid.ActiveAndroid;
import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;


import br.edu.vinnicyus.espanglish.lib.Configs;

/**
 * Created by Vinnicyus on 05/07/2017.
 */

@Table (name = "configs_apps", id = "id")
public class ConfigsApp extends Model {

    @Column (name = "insercao_jurados")
    private int insercaoJurados; // 0 -> no, 1 -> yes

    public int getInsercaoJurados() {
        return insercaoJurados;
    }

    public void setInsercaoJurados(int insercaoJurados) {
        this.insercaoJurados = insercaoJurados;
    }

    public void checkStatus()
    {
        ConfigsApp status_insercao_jurados = new Select("insercao_jurados").from(ConfigsApp.class).executeSingle();
        if(status_insercao_jurados == null) {
            this.insertDados(Configs.getConfigs());
            status_insercao_jurados = new ConfigsApp();
            status_insercao_jurados.setInsercaoJurados(1);
            status_insercao_jurados.save();
        }
        else if(status_insercao_jurados != null && status_insercao_jurados.getInsercaoJurados() == 0)
        {
            status_insercao_jurados.setInsercaoJurados(1);
            status_insercao_jurados.save();
        }
    }
    private void startApp()
    {
        this.setInsercaoJurados(0);
        this.save();
    }

    private void insertDados(Configs dados)
    {
        ActiveAndroid.beginTransaction();
        try {
            for (int v = 0; v < dados.jurados.length; v++) {
                Jurado j = new Jurado();
                j.setNome(dados.jurados[v][0]);
                j.setCpf(dados.jurados[v][1]);
                j.setSenha(dados.jurados[v][1]);
                j.setLingua(dados.jurados[v][2]);
                j.save();
            }
            for (int y = 0; y < dados.paises.length; y++) {
                Pais p = new Pais();
                p.setNome(dados.paises[y][0]);
                p.setCodigo(dados.paises[y][1]);
                p.setLingua(dados.paises[y][2]);
                p.save();
            }
            ActiveAndroid.setTransactionSuccessful();
        }
        finally {
            ActiveAndroid.endTransaction();
        }
    }
}
