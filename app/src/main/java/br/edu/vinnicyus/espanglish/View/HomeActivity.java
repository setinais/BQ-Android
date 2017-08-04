package br.edu.vinnicyus.espanglish.View;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.annotation.IdRes;
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
    private RadioButton radio8;

    private RadioButton radio6;
    private RadioButton radio7;

    private RadioButton radio_selected_pais;
    private RadioButton radio_selected_tipo;

    private Button btnVotar;
    private SharedPreferences preferences;

    private TextView tv;

    private Bundle dados;
    private String pais;

    private String[][] setTitleToobar;

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
        radio8 = (RadioButton) findViewById(R.id.radioButton8);

        radio6 = (RadioButton) findViewById(R.id.radioButton6);
        radio7 = (RadioButton) findViewById(R.id.radioButton7);

        preferences = getSharedPreferences("pref",Context.MODE_PRIVATE);
        String jurado = preferences.getString("nome", null);


        getSupportActionBar().setTitle("Bem Vindo "+jurado);

        Jurado j = Jurado.getUsuario(jurado);
        if(j.getLingua().equals("Espanhol"))
        {
            radio.setButtonDrawable(R.mipmap.espanha32);
            radio2.setButtonDrawable(R.mipmap.mexico32);
            radio3.setButtonDrawable(R.mipmap.portorico32);
            radio4.setButtonDrawable(R.mipmap.bolivia32);
            radio5.setVisibility(View.INVISIBLE);
            radio8.setVisibility(View.INVISIBLE);

            setTitleToobar = new String[4][2];

            setTitleToobar[0][0] = Integer.toString(radio.getId()) ;
            setTitleToobar[0][1] = "Espanha";
            setTitleToobar[1][0] = Integer.toString(radio2.getId()) ;
            setTitleToobar[1][1] = "México";
            setTitleToobar[2][0] = Integer.toString(radio3.getId()) ;
            setTitleToobar[2][1] = "Porto Rico";
            setTitleToobar[3][0] = Integer.toString(radio4.getId()) ;
            setTitleToobar[3][1] = "Bolívia";
        }
        else if(j.getLingua().equals("Ingles"))
        {
            radio.setButtonDrawable(R.mipmap.eua32);
            radio2.setButtonDrawable(R.mipmap.inglaterra32);
            radio3.setButtonDrawable(R.mipmap.novazelandia32);
            radio4.setButtonDrawable(R.mipmap.jamaica32);
            radio5.setButtonDrawable(R.mipmap.irlanda32);
            radio8.setButtonDrawable(R.mipmap.africadosul32);

            setTitleToobar = new String[6][2];

            setTitleToobar[0][0] = Integer.toString(radio.getId()) ;
            setTitleToobar[0][1] = "EUA";
            setTitleToobar[1][0] = Integer.toString(radio2.getId()) ;
            setTitleToobar[1][1] = "Inglaterra";
            setTitleToobar[2][0] = Integer.toString(radio3.getId()) ;
            setTitleToobar[2][1] = "Nova Zelândia";
            setTitleToobar[3][0] = Integer.toString(radio4.getId()) ;
            setTitleToobar[3][1] = "Jamaica";
            setTitleToobar[4][0] = Integer.toString(radio3.getId()) ;
            setTitleToobar[4][1] = "Irlanda";
            setTitleToobar[5][0] = Integer.toString(radio4.getId()) ;
            setTitleToobar[5][1] = "África do Sul";

        }
        else
        {
            Toast.makeText(this, "Falha na recuperação dos dados!", Toast.LENGTH_LONG).show();
        }

        rgp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton radio_selecionado_temporario = (RadioButton) findViewById(rgp.getCheckedRadioButtonId());
                String title = "";
                for (int v=0;v<setTitleToobar.length;v++)
                {
                    if(Integer.parseInt(setTitleToobar[v][0]) == radio_selecionado_temporario.getId())
                    {
                        title = setTitleToobar[v][1];
                        pais = setTitleToobar[v][1];
                    }
                }
                getSupportActionBar().setTitle(title);
            }
        });

        dados = new Bundle();
        dados.putString("jurado", j.getCpf());

        tv = (TextView) findViewById(R.id.text);
        btnVotar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                int id_p = rgp.getCheckedRadioButtonId();
                int id_t = rgt.getCheckedRadioButtonId();
                if(id_p == -1 || id_t == -1)
                {
                    tv.setError("Por favor escolha um país e um método de votação!");
                    tv.setText("Por favor escolha um país e um método de votação!");
                }
                else
                {
                    radio_selected_pais = (RadioButton) findViewById(id_p);
                    radio_selected_tipo = (RadioButton) findViewById(id_t);

                    dados.putString("pais", (String) pais);

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
