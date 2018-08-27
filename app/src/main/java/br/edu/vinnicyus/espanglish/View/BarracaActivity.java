package br.edu.vinnicyus.espanglish.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import br.edu.vinnicyus.espanglish.Model.Barraca;
import br.edu.vinnicyus.espanglish.Model.CheckBoxBarraca;
import br.edu.vinnicyus.espanglish.Model.Pais;
import br.edu.vinnicyus.espanglish.Model.Jurado;
import br.edu.vinnicyus.espanglish.R;

public class BarracaActivity extends AppCompatActivity {

    private SeekBar seekBarRecepcao;
    private SeekBar seekBarUtilizacao;
    private SeekBar seekBarComida;
    private SeekBar seekBarFluencia;
    private SeekBar seekBarInformacoes;
    private SeekBar seekBarProducao;
    private SeekBar seekBarJogos;
    private SeekBar seekBarCriatividade;
    private SeekBar seekBarOrganizacao;

    private TextView countRecepcao;
    private TextView countUtilizacao;
    private TextView countComida;
    private TextView countFluencia;
    private TextView countInformacoes;
    private TextView countProducao;
    private TextView countJogos;
    private TextView countCriatividade;
    private TextView countOrganizacao;

    private CheckBox checkBoxRecepcao;
    private CheckBox checkBoxUtilizacao;
    private CheckBox checkBoxComida;
    private CheckBox checkBoxFluencia;
    private CheckBox checkBoxInformacoes;
    private CheckBox checkBoxProducao;
    private CheckBox checkBoxJogos;
    private CheckBox checkBoxCriatividade;
    private CheckBox checkBoxOrganizacao;

    private Button btn_votar;


    private int[] value_seekbar;

    private String pais;
    private String codigo_pais;
    private String jurado;

    private ImageView imageViewPais;
    private Barraca barraca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barraca);

        Intent itent = getIntent();
        Bundle dados = itent.getExtras();
        codigo_pais = Pais.getCodigoPais(dados.getString("pais"));
        pais = dados.getString("pais");
        jurado = dados.getString("jurado");

        getSupportActionBar().setTitle("Barraca -> "+pais);

        imageViewPais = (ImageView) findViewById(R.id.imageView);

        switch (pais)
        {
            case "Espanha":
                imageViewPais.setImageResource(R.mipmap.espanha);
                break;
            case "EUA":
                imageViewPais.setImageResource(R.mipmap.eua32);
                break;
            case "Inglaterra":
                imageViewPais.setImageResource(R.mipmap.inglaterra32);
                break;
            case "Cuba":
                imageViewPais.setImageResource(R.mipmap.cuba32);
                break;
            case "Chile":
                imageViewPais.setImageResource(R.mipmap.chile32);
                break;
            case "Filipinas":
                imageViewPais.setImageResource(R.mipmap.filipinas32);
                break;
            default:
                imageViewPais.setImageResource(R.mipmap.vespanglish);
                break;
        }

        seekBarRecepcao = (SeekBar) findViewById(R.id.seekBarRecepcao);
        seekBarUtilizacao = (SeekBar) findViewById(R.id.seekBarUtilizacao);
        seekBarComida = (SeekBar) findViewById(R.id.seekBarComida);
        seekBarFluencia = (SeekBar) findViewById(R.id.seekBarFluencia);
        seekBarInformacoes = (SeekBar) findViewById(R.id.seekBarInformacoes);
        seekBarProducao = (SeekBar) findViewById(R.id.seekBarProducao);
        seekBarJogos = (SeekBar) findViewById(R.id.seekBarJogos);
        seekBarCriatividade = (SeekBar) findViewById(R.id.seekBarCriatividade);
        seekBarOrganizacao = (SeekBar) findViewById(R.id.seekBarOrganizacao);

        countRecepcao = (TextView) findViewById(R.id.countRecepcao);
        countUtilizacao = (TextView) findViewById(R.id.countUtilizacao);
        countComida = (TextView) findViewById(R.id.countComida);
        countFluencia = (TextView) findViewById(R.id.countFluencia);
        countInformacoes = (TextView) findViewById(R.id.countInformacoes);
        countProducao = (TextView) findViewById(R.id.countProducao);
        countJogos = (TextView) findViewById(R.id.countJogos);
        countCriatividade = (TextView) findViewById(R.id.countCriatividade);
        countOrganizacao = (TextView) findViewById(R.id.countOrganizacao);

        checkBoxRecepcao = (CheckBox) findViewById(R.id.checkBoxRecepcao);
        checkBoxUtilizacao = (CheckBox) findViewById(R.id.checkBoxUtilizacao);
        checkBoxComida = (CheckBox) findViewById(R.id.checkBoxComida);
        checkBoxFluencia = (CheckBox) findViewById(R.id.checkBoxFluencia);
        checkBoxInformacoes = (CheckBox) findViewById(R.id.checkBoxInformacoes);
        checkBoxProducao = (CheckBox) findViewById(R.id.checkBoxProducao);
        checkBoxJogos = (CheckBox) findViewById(R.id.checkBoxJogos);
        checkBoxCriatividade = (CheckBox) findViewById(R.id.checkBoxCriatividade);
        checkBoxOrganizacao = (CheckBox) findViewById(R.id.checkBoxOrganizacao);

        btn_votar = (Button) findViewById(R.id.btnSalvar);

        value_seekbar = new int[9];

        barraca = Barraca.getVotos(codigo_pais+"."+jurado);
        if(barraca != null)
        {
            seekBarRecepcao.setProgress(barraca.getRecepcao());
            countRecepcao.setText(barraca.getRecepcao() + " / " + seekBarRecepcao.getMax());
            value_seekbar[0] = barraca.getRecepcao();
            if (barraca.getCheckBox().isRecepcao())
                checkBoxRecepcao.setChecked(true);

            seekBarUtilizacao.setProgress(barraca.getUtilizacao_materiais());
            countUtilizacao.setText(barraca.getUtilizacao_materiais() + " / " + seekBarUtilizacao.getMax());
            value_seekbar[1] = barraca.getUtilizacao_materiais();
            if (barraca.getCheckBox().isUtilizacao_materiais())
                checkBoxUtilizacao.setChecked(true);

            seekBarComida.setProgress(barraca.getComidas_bebidas_tipicas());
            countComida.setText(barraca.getComidas_bebidas_tipicas() + " / " + seekBarComida.getMax());
            value_seekbar[2] = barraca.getComidas_bebidas_tipicas();
            if (barraca.getCheckBox().isComidas_bebidas_tipicas())
                checkBoxComida.setChecked(true);

            seekBarFluencia.setProgress(barraca.getFluencia_lingua());
            countFluencia.setText(barraca.getFluencia_lingua() + " / " + seekBarFluencia.getMax());
            value_seekbar[3] = barraca.getFluencia_lingua();
            if (barraca.getCheckBox().isFluencia_lingua())
                checkBoxFluencia.setChecked(true);

            seekBarInformacoes.setProgress(barraca.getInformacoes_pais_bandeira());
            countInformacoes.setText(barraca.getInformacoes_pais_bandeira() + " / " + seekBarInformacoes.getMax());
            value_seekbar[4] = barraca.getInformacoes_pais_bandeira();
            if (barraca.getCheckBox().isInformacoes_pais_bandeira())
                checkBoxInformacoes.setChecked(true);

            seekBarProducao.setProgress(barraca.getProducao_tecnologica());
            countProducao.setText(barraca.getProducao_tecnologica() + " / " + seekBarProducao.getMax());
            value_seekbar[5] = barraca.getProducao_tecnologica();
            if (barraca.getCheckBox().isProducao_tecnologica())
                checkBoxProducao.setChecked(true);

            seekBarJogos.setProgress(barraca.getJogos_interacao());
            countJogos.setText(barraca.getJogos_interacao() + " / " + seekBarJogos.getMax());
            value_seekbar[6] = barraca.getJogos_interacao();
            if (barraca.getCheckBox().isJogos_interacao())
                checkBoxJogos.setChecked(true);

            seekBarCriatividade.setProgress(barraca.getCriatividade());
            countCriatividade.setText(barraca.getCriatividade() + " / " + seekBarCriatividade.getMax());
            value_seekbar[7] = barraca.getCriatividade();
            if (barraca.getCheckBox().isCriatividade())
                checkBoxCriatividade.setChecked(true);

            seekBarOrganizacao.setProgress(barraca.getOrganizacao());
            countOrganizacao.setText(barraca.getOrganizacao() + " / " + seekBarOrganizacao.getMax());
            value_seekbar[8] = barraca.getOrganizacao();
            if (barraca.getCheckBox().isOrganizacao())
                checkBoxOrganizacao.setChecked(true);
        }
        else
        {
            barraca = new Barraca();
            barraca.setCodigo(codigo_pais+"."+jurado);
            barraca.setCheckBox(new CheckBoxBarraca());
        }




        seekBarRecepcao.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;
                value_seekbar[0] = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                countRecepcao.setText(seekBarProgress + " / " + seekBar.getMax());
            }

        });

        seekBarUtilizacao.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;
                value_seekbar[1] = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                countUtilizacao.setText(seekBarProgress + " / " + seekBar.getMax());
            }

        });

        seekBarComida.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;
                value_seekbar[2] = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                countComida.setText(seekBarProgress + " / " + seekBar.getMax());
            }

        });

        seekBarFluencia.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;
                value_seekbar[3] = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                countFluencia.setText(seekBarProgress + " / " + seekBar.getMax());
            }

        });

        seekBarInformacoes.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;
                value_seekbar[4] = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                countInformacoes.setText(seekBarProgress + " / " + seekBar.getMax());
            }

        });

        seekBarProducao.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;
                value_seekbar[5] = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                countProducao.setText(seekBarProgress + " / " + seekBar.getMax());
            }

        });

        seekBarJogos.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;
                value_seekbar[6] = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                countJogos.setText(seekBarProgress + " / " + seekBar.getMax());
            }

        });

        seekBarCriatividade.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;
                value_seekbar[7] = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                countCriatividade.setText(seekBarProgress + " / " + seekBar.getMax());
            }

        });

        seekBarOrganizacao.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;
                value_seekbar[8] = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                countOrganizacao.setText(seekBarProgress + " / " + seekBar.getMax());
            }

        });



        //Ação do Buttao Salvar Votos

        btn_votar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                barraca.getCheckBox().setRecepcao(validarCheckBox(checkBoxRecepcao,value_seekbar[0]));
                barraca.getCheckBox().setUtilizacao_materiais(validarCheckBox(checkBoxUtilizacao,value_seekbar[1]));
                barraca.getCheckBox().setComidas_bebidas_tipicas(validarCheckBox(checkBoxComida,value_seekbar[2]));
                barraca.getCheckBox().setFluencia_lingua(validarCheckBox(checkBoxFluencia,value_seekbar[3]));
                barraca.getCheckBox().setInformacoes_pais_bandeira(validarCheckBox(checkBoxInformacoes,value_seekbar[4]));
                barraca.getCheckBox().setProducao_tecnologica(validarCheckBox(checkBoxProducao,value_seekbar[5]));
                barraca.getCheckBox().setJogos_interacao(validarCheckBox(checkBoxJogos,value_seekbar[6]));
                barraca.getCheckBox().setCriatividade(validarCheckBox(checkBoxCriatividade,value_seekbar[7]));
                barraca.getCheckBox().setOrganizacao(validarCheckBox(checkBoxOrganizacao,value_seekbar[8]));
                barraca.getCheckBox().save();

                barraca.setRecepcao(value_seekbar[0]);
                barraca.setUtilizacao_materiais(value_seekbar[1]);
                barraca.setComidas_bebidas_tipicas(value_seekbar[2]);
                barraca.setFluencia_lingua(value_seekbar[3]);
                barraca.setInformacoes_pais_bandeira(value_seekbar[4]);
                barraca.setProducao_tecnologica(value_seekbar[5]);
                barraca.setJogos_interacao(value_seekbar[6]);
                barraca.setCriatividade(value_seekbar[7]);
                barraca.setOrganizacao(value_seekbar[8]);
                barraca.setStatus_envio(2);
                barraca.save();
                finish();
            }
        });
    }

    private boolean validarCheckBox(CheckBox checkBox, int progressbar)
    {
        if(checkBox.isChecked() && progressbar <= 9)
        {
            return true;
        }
        return false;
    }
}
