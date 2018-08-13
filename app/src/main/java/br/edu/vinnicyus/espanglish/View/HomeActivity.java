package br.edu.vinnicyus.espanglish.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;




import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.vinnicyus.espanglish.Controller.WebService;
import br.edu.vinnicyus.espanglish.Model.Barraca;
import br.edu.vinnicyus.espanglish.Model.Jurado;
import br.edu.vinnicyus.espanglish.Model.Palco;
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

    private Bundle dados;
    private String pais;

    private String[][] setTitleToobar;

    private int v;
    private Map<String, String> params;


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


        getSupportActionBar().setTitle("Bem Vindo "+jurado);

        Jurado j = Jurado.getUsuario(jurado);
        if(j.getLingua().equals("Espanhol"))
        {
            radio.setButtonDrawable(R.mipmap.espanha);
            radio2.setButtonDrawable(R.mipmap.mexico32);
            radio3.setButtonDrawable(R.mipmap.portorico32);
            radio4.setButtonDrawable(R.mipmap.bolivia32);
            radio5.setVisibility(View.INVISIBLE);

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
            radio5.setButtonDrawable(R.mipmap.africadosul32);

            setTitleToobar = new String[5][2];

            setTitleToobar[0][0] = Integer.toString(radio.getId()) ;
            setTitleToobar[0][1] = "EUA";
            setTitleToobar[1][0] = Integer.toString(radio2.getId()) ;
            setTitleToobar[1][1] = "Inglaterra";
            setTitleToobar[2][0] = Integer.toString(radio3.getId()) ;
            setTitleToobar[2][1] = "Nova Zelândia";
            setTitleToobar[3][0] = Integer.toString(radio4.getId()) ;
            setTitleToobar[3][1] = "Jamaica";
            setTitleToobar[4][0] = Integer.toString(radio5.getId()) ;
            setTitleToobar[4][1] = "África do Sul";

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
                    List<Barraca> all_barraca = Barraca.getAll();
                    List<Palco> all_palco = Palco.getAll();
                    if (all_palco.isEmpty() && all_barraca.isEmpty()) {
                        mensagem("Nenhuma alteração feita!");
                    } else {
                        sendDados(all_barraca, all_palco);
                    }

                    radio_selected_pais = (RadioButton) findViewById(id_p);
                    radio_selected_tipo = (RadioButton) findViewById(id_t);

                    dados.putString("pais",pais);

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

    public void mensagem(String m)
    {
        Toast.makeText(this, m, Toast.LENGTH_SHORT).show();
    }

    private String soma(float n1,float n2)
    {
        float soma = n1+n2;
        return Float.toString(soma);
    }

    public void sendDados(List<Barraca> barraca, List<Palco> palco){

        params = new HashMap<String,String>();
        String barraca_carvalho = "";
        String palco_carvalho = "";
        if(!barraca.isEmpty())
            for (int v=0;v<barraca.size();v++) {
                barraca_carvalho += "{codigo:"+barraca.get(v).getCodigo()+
                                ";comidas_tipicas:"+soma(barraca.get(v).getComidas_bebidas_tipicas(),(barraca.get(v).getCheckBox().isComidas_bebidas_tipicas() ? (float) 0.5 : (float) 0.0 ))+
                                ";criatividade:"+soma(barraca.get(v).getCriatividade(),(barraca.get(v).getCheckBox().isCriatividade() ? (float) 0.5 : (float) 0.0 ))+
                                ";fluencia_lingua:"+soma(barraca.get(v).getFluencia_lingua(),(barraca.get(v).getCheckBox().isFluencia_lingua() ? (float) 0.5 : (float) 0.0 ))+
                                ";informacoes_pais_bandeira:"+soma(barraca.get(v).getInformacoes_pais_bandeira(),(barraca.get(v).getCheckBox().isInformacoes_pais_bandeira() ? (float) 0.5 : (float) 0.0 ))+
                                ";jogos_interacao:"+soma(barraca.get(v).getJogos_interacao(),(barraca.get(v).getCheckBox().isJogos_interacao() ? (float) 0.5 : (float) 0.0 ))+
                                ";organizacao:"+soma(barraca.get(v).getOrganizacao(),(barraca.get(v).getCheckBox().isOrganizacao() ? (float) 0.5 : (float) 0.0 ))+
                                ";producao_tecnologica:"+soma(barraca.get(v).getProducao_tecnologica(),(barraca.get(v).getCheckBox().isProducao_tecnologica() ? (float) 0.5 : (float) 0.0 ))+
                                ";recepcao:"+soma(barraca.get(v).getRecepcao(),(barraca.get(v).getCheckBox().isRecepcao() ? (float) 0.5 : (float) 0.0 ))+
                                ";utilizacao_materiais:"+soma(barraca.get(v).getUtilizacao_materiais(),(barraca.get(v).getCheckBox().isUtilizacao_materiais() ? (float) 0.5 : (float) 0.0 ));
            }
        if (!palco.isEmpty())
            for (int v=0;v<palco.size();v++) {
                palco_carvalho += "{codigo:"+palco.get(v).getCodigo()+
                        ";apresentacao_cultural:"+soma(palco.get(v).getApresentacao_cultural(),(palco.get(v).getCheckbox().isApresentacao_cultural() ? (float) 0.5 : (float) 0.0))+
                        ";desfile:"+soma(palco.get(v).getDesfile_traje(),(palco.get(v).getCheckbox().isDesfile_traje() ? (float) 0.5 : (float) 0.0))+
                        ";fluencia_lingua:"+soma(palco.get(v).getFluencia_lingua(),(palco.get(v).getCheckbox().isFluencia_lingua() ? (float) 0.5 : (float) 0.0))+
                        ";preenca_de_palco:"+soma(palco.get(v).getPresenca_de_palco(),(palco.get(v).getCheckbox().isPresenca_de_palco() ? (float) 0.5 : (float) 0.0))+
                        ";qualidade_slide:"+soma(palco.get(v).getQualidade_slide(),(palco.get(v).getCheckbox().isQualidade_slide() ? (float) 0.5 : (float) 0.0))+
                        ";uso_tempo:"+soma(palco.get(v).getUso_tempo(),(palco.get(v).getCheckbox().isUso_tempo() ? (float) 0.5 : (float) 0.0));
            }

        params.put("dados", "[barraca"+barraca_carvalho+"[palco"+palco_carvalho);

        RequestQueue rq = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.POST,"http://192.168.1.106/espanglish/back/init.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.toString().equals("Error")) {
                    WebService ws = new WebService(response.toString());
                    ws.tratramentoDados();
                    mensagem("Salvo com suceesso!");
                }
                else
                {
                    mensagem("Error na busca dos dados!");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mensagem("Error de conexão!");

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{

                Map<String, String> params2 = params;
                return params2;
            }
        };
        rq.add(request);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.update :
                atualizar(this,item);
                break;
        }
        return false;
    }

    public void atualizar(final Activity activity, final MenuItem menu)
    {
            List<Barraca> all_barraca = Barraca.getAll();
            List<Palco> all_palco = Palco.getAll();
            if (all_palco.isEmpty() && all_barraca.isEmpty()) {
                //mensagem("Nenhuma alteração feita!");
            } else {
                menu.setActionView(R.layout.update);
                sendDados(all_barraca, all_palco);
                new Thread() {
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                menu.setActionView(null);
                                menu.setIcon(android.R.drawable.stat_notify_sync_noanim);

                            }
                        });
                    }
                }.start();

            }
    }
}
