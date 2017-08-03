package br.edu.vinnicyus.espanglish;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import br.edu.vinnicyus.espanglish.Controller.LoginValidator;
import br.edu.vinnicyus.espanglish.Model.ConfigsApp;
import br.edu.vinnicyus.espanglish.View.HomeActivity;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity{

    private EditText nome;
    private EditText password;
    private Button btnLogar;

    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ConfigsApp check = new ConfigsApp();
        check.checkStatus();

        ImageView iv = (ImageView) findViewById(R.id.imageView);
        iv.setVisibility(View.VISIBLE);

        preferences = getSharedPreferences("pref",Context.MODE_PRIVATE);

        String login = preferences.getString("nome", null);
        String senha = preferences.getString("password", null);

        if(login != null && senha != null)
        {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        }
        Toast.makeText(this, "By Alpha's Developed", Toast.LENGTH_LONG).show();

        nome = (EditText) findViewById(R.id.nome);
        password = (EditText) findViewById(R.id.password);
        btnLogar = (Button) findViewById(R.id.btnLogar);

        btnLogar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                String login = nome.getText().toString();
                String senha = password.getText().toString();

                LoginValidator isValid = new LoginValidator();
                isValid.setLogin(login);
                isValid.setSenha(senha);
                isValid.setEditLogin(nome);
                isValid.setEditSenha(password);
                isValid.validarCampos(login,senha);
                {
                    if(isValid.isvalid())
                    {
                        SharedPreferences.Editor editor = getSharedPreferences("pref", MODE_PRIVATE).edit();
                        editor.putString("nome", login);
                        editor.putString("password", senha);
                        editor.commit();

                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }


}
