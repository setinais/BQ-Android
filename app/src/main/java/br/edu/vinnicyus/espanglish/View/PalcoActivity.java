package br.edu.vinnicyus.espanglish.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.vinnicyus.espanglish.Model.Palco;
import br.edu.vinnicyus.espanglish.R;

public class PalcoActivity extends AppCompatActivity {

    private SeekBar seekBarDesfile;
    private SeekBar seekBarFluencia;
    private SeekBar seekBarPresenca;
    private SeekBar seekBarQualidade;
    private SeekBar seekBarApresentacao;
    private SeekBar seekBarTempo;

    private TextView countDesfile;
    private TextView countFluencia;
    private TextView countPresenca;
    private TextView countQualidade;
    private TextView countApresentacao;
    private TextView countTempo;

    private Button btn_votar;

    private TextView textviewPais;

    private int[] value_seekbar;

    private String pais;
    private String jurado;

    private Palco palco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palco);

        Intent itent = getIntent();
        Bundle dados = itent.getExtras();
        pais = dados.getString("pais");
        jurado = dados.getString("jurado");

        textviewPais = (TextView) findViewById(R.id.textviewPais);

        seekBarDesfile = (SeekBar) findViewById(R.id.seekBarDesfile);
        seekBarFluencia = (SeekBar) findViewById(R.id.seekBarFluencia);
        seekBarPresenca = (SeekBar) findViewById(R.id.seekBarPresenca);
        seekBarQualidade = (SeekBar) findViewById(R.id.seekBarQualidade);
        seekBarApresentacao = (SeekBar) findViewById(R.id.seekBarApresentacao);
        seekBarTempo = (SeekBar) findViewById(R.id.seekBarTempo);

        countDesfile = (TextView) findViewById(R.id.countDesfile);
        countFluencia = (TextView) findViewById(R.id.countFluencia);
        countPresenca = (TextView) findViewById(R.id.countPresenca);
        countQualidade = (TextView) findViewById(R.id.countQualidade);
        countApresentacao = (TextView) findViewById(R.id.countApresentacao);
        countTempo = (TextView) findViewById(R.id.countTempo);

        btn_votar = (Button) findViewById(R.id.btnSalvar);

        value_seekbar = new int[6];

        palco = Palco.getVotos(pais+";"+jurado);
        if(palco != null)
        {
            seekBarDesfile.setProgress(palco.getDesfile_traje());
            countDesfile.setText(palco.getDesfile_traje() + " / " + seekBarDesfile.getMax());

            seekBarFluencia.setProgress(palco.getFluencia_lingua());
            countFluencia.setText(palco.getFluencia_lingua() + " / " + seekBarFluencia.getMax());

            seekBarPresenca.setProgress(palco.getPresenca_de_palco());
            countPresenca.setText(palco.getPresenca_de_palco() + " / " + seekBarPresenca.getMax());

            seekBarQualidade.setProgress(palco.getQualidade_slide());
            countQualidade.setText(palco.getQualidade_slide() + " / " + seekBarQualidade.getMax());

            seekBarApresentacao.setProgress(palco.getApresentacao_cultural());
            countApresentacao.setText(palco.getApresentacao_cultural() + " / " + seekBarApresentacao.getMax());

            seekBarTempo.setProgress(palco.getUso_tempo());
            countTempo.setText(palco.getUso_tempo() + " / " + seekBarTempo.getMax());
        }
        else
        {
            palco = new Palco();
            palco.setCodigo(pais+";"+jurado);
        }
        textviewPais.setText("Palco -> "+pais);

        //Desfile de Traje

        seekBarDesfile.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;
                value_seekbar[0] = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                countDesfile.setText(seekBarProgress + " / " + seekBar.getMax());
            }

        });

        //Fluência na Língua Estrangeira

        seekBarFluencia.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;
                value_seekbar[1] = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                countFluencia.setText(seekBarProgress + " / " + seekBar.getMax());
            }

        });

        //Presença de palco

        seekBarPresenca.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;
                value_seekbar[2] = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                countPresenca.setText(seekBarProgress + " / " + seekBar.getMax());
            }

        });

        //Qualidade dos slides

        seekBarQualidade.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;
                value_seekbar[3] = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                countQualidade.setText(seekBarProgress + " / " + seekBar.getMax());
            }

        });

        //Apresentação cultural

        seekBarApresentacao.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;
                value_seekbar[4] = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                countApresentacao.setText(seekBarProgress + " / " + seekBar.getMax());
            }

        });

        //Uso do tempo

        seekBarTempo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;
                value_seekbar[5] = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                countTempo.setText(seekBarProgress + " / " + seekBar.getMax());
            }

        });



        //Ação do Buttao Salvar Votos

        btn_votar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                palco.setDesfile_traje(value_seekbar[0]);
                palco.setFluencia_lingua(value_seekbar[1]);
                palco.setPresenca_de_palco(value_seekbar[2]);
                palco.setQualidade_slide(value_seekbar[3]);
                palco.setApresentacao_cultural(value_seekbar[4]);
                palco.setUso_tempo(value_seekbar[5]);
                palco.save();
                finish();
            }
        });

    }
}
