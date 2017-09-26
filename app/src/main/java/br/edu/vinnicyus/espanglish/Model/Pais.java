package br.edu.vinnicyus.espanglish.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

/**
 * Created by Vinnicyus on 24/07/2017.
 */
@Table (name = "paises", id="id")
public class Pais extends Model{

    @Column (name = "nome")
    private String nome;

    @Column (name = "codigo")
    private String codigo;

    @Column (name = "lingua")
    private String lingua;

    @Column (name = "bandeira")
    private String bandeira;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String url) {
        this.codigo = url;
    }

    public String getLingua() {
        return lingua;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getBandeira() {
        return bandeira;
    }

    public static String getCodigoPais(String pais)
    {
        Pais p = new Select().from(Pais.class).where("nome = ?", pais).executeSingle();
        return p.getCodigo();
    }

    public static String getBandeiraPais(String pais)
    {
        Pais bandeira = new Select().from(Pais.class).where("nome = ?",pais).executeSingle();
        return bandeira.getBandeira();
    }
}
