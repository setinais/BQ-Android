package br.edu.vinnicyus.espanglish.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palco);


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

        //Desfile de Traje

        seekBarDesfile.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;

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

            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                countTempo.setText(seekBarProgress + " / " + seekBar.getMax());
            }

        });

    }
}
