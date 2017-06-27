package br.edu.vinnicyus.espanglish.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Vinnicyus on 26/06/2017.
 */

@Table (name = "jurados", id ="id")
public class Jurado extends Model{

    @Column (name = "nome")
    public String nome;

    @Column (name = "cpf", unique = true)
    public String cpf;

    @Column (name = "senha")
    public String senha;



}
