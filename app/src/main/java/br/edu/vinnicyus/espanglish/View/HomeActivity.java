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
    private RadioButton radio8;

    private RadioButton radio6;
    private RadioButton radio7;

    private RadioButton radio_selected_pais;
    private RadioButton radio_selected_tipo;

    private Button btnVotar;
    private Button btnWs;
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
        btnWs = (Button) findViewById(R.id.btn_ws);

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
        Toast.makeText(this, m, Toast.LENGTH_LONG).show();
    }

    public void sendDados(List<Barraca> barraca, List<Palco> palco){

        params = new HashMap<>();
        String barraca_carvalho = "";
        String palco_carvalho = "";
        if(!barraca.isEmpty())
            for (int v=0;v<barraca.size();v++) {
                barraca_carvalho += "{codigo:"+barraca.get(v).getCodigo()+
                                ";comidas_tipicas:"+Integer.toString(barraca.get(v).getComidas_bebidas_tipicas())+
                                ";criatividade:"+Integer.toString(barraca.get(v).getCriatividade())+
                                ";fluencia_lingua:"+Integer.toString(barraca.get(v).getFluencia_lingua())+
                                ";informacoes_pais_bandeira:"+Integer.toString(barraca.get(v).getInformacoes_pais_bandeira())+
                                ";jogos_interacao:"+Integer.toString(barraca.get(v).getJogos_interacao())+
                                ";organizacao:"+Integer.toString(barraca.get(v).getOrganizacao())+
                                ";producao_tecnologica:"+Integer.toString(barraca.get(v).getProducao_tecnologica())+
                                ";recepcao:"+Integer.toString(barraca.get(v).getRecepcao())+
                                ";utilizacao_materiais:"+Integer.toString(barraca.get(v).getUtilizacao_materiais());
            }
        if (!palco.isEmpty())
            for (int v=0;v<palco.size();v++) {
                palco_carvalho += "{codigo:"+palco.get(v).getCodigo()+
                        ";apresentacao_cultural:"+Integer.toString(palco.get(v).getApresentacao_cultural())+
                        ";desfile:"+Integer.toString(palco.get(v).getDesfile_traje())+
                        ";fluencia_lingua:"+Integer.toString(palco.get(v).getFluencia_lingua())+
                        ";preenca_de_palco:"+Integer.toString(palco.get(v).getPresenca_de_palco())+
                        ";qualidade_slide:"+Integer.toString(palco.get(v).getQualidade_slide())+
                        ";uso_tempo:"+Integer.toString(palco.get(v).getUso_tempo());
            }

        params.put("dados", "[barraca"+barraca_carvalho+"[palco"+palco_carvalho);

        RequestQueue rq = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.POST,"http://192.168.1.102/back/init.php", new Response.Listener<String>() {
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
                mensagem("Error de conexão! " + error.getLocalizedMessage());
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
        if(all_palco.isEmpty() && all_barraca.isEmpty()){
            mensagem("Nenhuma alteração feita!");
        }
        else {
            menu.setActionView(R.layout.update);
            sendDados(all_barraca, all_palco);
            new Thread()
            {
                public void run()
                {
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
