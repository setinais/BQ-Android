package br.edu.vinnicyus.espanglish.Controller;

import android.widget.Button;
import android.widget.EditText;

import br.edu.vinnicyus.espanglish.Model.Jurado;

/**
 * Created by Vinnicyus on 26/06/2017.
 */

public class LoginValidator {

    private EditText editLogin;
    private EditText editSenha;
    private String senha;
    private String login;
    private Jurado j;

    private boolean isvalid;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public EditText getEditLogin() {
        return editLogin;
    }

    public void setEditLogin(EditText editLogin) {
        this.editLogin = editLogin;
    }

    public EditText getEditSenha() {
        return editSenha;
    }

    public void setEditSenha(EditText editSenha) {
        this.editSenha = editSenha;
    }

    public Jurado getJ() {
        return j;
    }

    public void setJ(Jurado j) {
        this.j = j;
    }

    public boolean isvalid() {
        return isvalid;
    }

    public void setIsvalid(boolean isvalid) {
        this.isvalid = isvalid;
    }

    public void validarCampos(String login, String senha)
    {
        boolean result = true;
        if(login == null || "".equals(login))
        {
            this.editLogin.setError("Campo Obrigatorio!");
            result = false;
        }
        if(senha == null || "".equals(senha))
        {
            this.editSenha.setError("Campo Obrigatorio!");
            result = false;
        }
        this.isvalid = result;
    }

}
