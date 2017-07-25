package br.edu.vinnicyus.espanglish.View;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.vinnicyus.espanglish.Model.Jurado;
import br.edu.vinnicyus.espanglish.R;

public class HomeActivity extends AppCompatActivity {

    private RadioGroup rgp;
    private RadioGroup rgt;

    private RadioButton radio;
    private RadioButton radio2;
    private RadioButton radio3;
    private RadioButton radio4;
    private RadioButton radio5;


    private RadioButton radio6;
    private RadioButton radio7;

    private RadioButton radio_selected_pais;
    private RadioButton radio_selected_tipo;

    private Button btnVotar;
    private SharedPreferences preferences;

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnVotar = (Button) findViewById(R.id.btnVotar);

        rgp = (RadioGroup) findViewById(R.id.radioGroup1);
        rgt = (RadioGroup) findViewById(R.id.radioGroup2);

        radio = (RadioButton) findViewById(R.id.radioButton);
        radio2 = (RadioButton) findViewById(R.id.radioButton2);
        radio3 = (RadioButton) findViewById(R.id.radioButton3);
        radio4 = (RadioButton) findViewById(R.id.radioButton4);
        radio5 = (RadioButton) findViewById(R.id.radioButton5);

        radio6 = (RadioButton) findViewById(R.id.radioButton6);
        radio7 = (RadioButton) findViewById(R.id.radioButton7);



        preferences = getSharedPreferences("pref",Context.MODE_PRIVATE);
        String jurado = preferences.getString("nome", null);

        Jurado j = Jurado.getUsuario(jurado);
        if(j.getLingua().equals("Espanhol"))
        {
            radio.setButtonDrawable(R.mipmap.nicaragua32);
            radio2.setButtonDrawable(R.mipmap.nicaragua32);
            radio3.setButtonDrawable(R.mipmap.nicaragua32);
            radio4.setButtonDrawable(R.mipmap.nicaragua32);
            radio5.setButtonDrawable(R.mipmap.nicaragua32);

            radio.setText("Espanha");
            radio2.setText("China");
            radio3.setText("Japao");
            radio4.setText("Estados Unidos");
            radio5.setText("Espan");
        }
        else if(j.getLingua().equals("Ingles"))
        {
            radio.setButtonDrawable(R.mipmap.nicaragua32);
            radio2.setButtonDrawable(R.mipmap.nicaragua32);
            radio3.setButtonDrawable(R.mipmap.nicaragua32);
            radio4.setButtonDrawable(R.mipmap.nicaragua32);
            radio5.setButtonDrawable(R.mipmap.nicaragua32);

            radio.setText("a");
            radio2.setText("b");
            radio3.setText("c");
            radio4.setText("d");
            radio5.setText("e");
        }
        else
        {
            Toast.makeText(this, "Falha na recuperação dos dados!", Toast.LENGTH_LONG).show();
        }
        tv = (TextView) findViewById(R.id.text);
        btnVotar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                int id_p = rgp.getCheckedRadioButtonId();
                int id_t = rgt.getCheckedRadioButtonId();
                if(id_p == -1 || id_t == -1)
                {
                    tv.setError("Por favor escolha um pais e um metodo de votação!");
                    tv.setText("Por favor escolha um pais e um metodo de votação!");
                }
                else
                {
                    radio_selected_pais = (RadioButton) findViewById(id_p);
                    radio_selected_tipo = (RadioButton) findViewById(id_t);

                    Bundle dados = new Bundle();
                    dados.putString("pais", (String) radio_selected_pais.getText());
                    Intent intent;
                    if(radio_selected_tipo.getText().equals("Palco"))
                    {

                        intent = new Intent(HomeActivity.this, PalcoActivity.class);
                    }

                    else
                    {
                        intent = new Intent(HomeActivity.this, BarracaActivity.class);
                    }
                    intent.putExtras(dados);
                    startActivity(intent);

                }

            }
        });

    }
}
