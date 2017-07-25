package br.edu.vinnicyus.espanglish.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
/**
 * Created by Vinnicyus on 26/06/2017.
 */

@Table (name = "jurados", id = "id")
public class Jurado extends Model{

    @Column (name = "nome")
    private String nome;

    @Column (name = "cpf")
    private String cpf;

    @Column (name = "senha")
    private String senha;

    @Column (name = "lingua")
    private String lingua;

    public static Jurado getUsuario(String nome)
    {
        Jurado jurado = new Select().from(Jurado.class).where("nome = ?", nome).executeSingle();
        return jurado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLingua() {
        return lingua;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }
}
