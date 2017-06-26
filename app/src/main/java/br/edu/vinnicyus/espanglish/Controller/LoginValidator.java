package br.edu.vinnicyus.espanglish.Controller;

/**
 * Created by Vinnicyus on 26/06/2017.
 */

public class LoginValidator {

    public boolean isvalid;

    public void validarCampos(String login, String senha)
    {
        boolean result = true;
        if(login == null || "".equals(login))
        {
            //nome.setError("Campo Obrigatorio!");
            result = false;
        }
        if(senha == null || "".equals(senha))
        {
            //password.setError("Campo Obrigatorio!");
            result = false;
        }
        this.isvalid = result;
    }

}
