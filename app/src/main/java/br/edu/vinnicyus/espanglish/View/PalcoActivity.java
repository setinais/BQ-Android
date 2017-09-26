package br.edu.vinnicyus.espanglish.View;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.vinnicyus.espanglish.Model.CheckBoxPalco;
import br.edu.vinnicyus.espanglish.Model.Jurado;
import br.edu.vinnicyus.espanglish.Model.Pais;
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

    private CheckBox checkBoxDesfile;
    private CheckBox checkBoxFluencia;
    private CheckBox checkBoxPresenca;
    private CheckBox checkBoxQualidade;
    private CheckBox checkBoxApresentacao;
    private CheckBox checkBoxTempo;

    private Button btn_votar;

    private ImageView imageViewPais;

    private int[] value_seekbar;

    private String pais;
    private String codigo_pais;
    private String jurado;

    private Palco palco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palco);


        Intent itent = getIntent();
        Bundle dados = itent.getExtras();
        codigo_pais = Pais.getCodigoPais(dados.getString("pais"));
        pais = dados.getString("pais");
        jurado = dados.getString("jurado");

        getSupportActionBar().setTitle("Avaliação Palco -> "+pais);

        imageViewPais = (ImageView) findViewById(R.id.imageView);

        switch (pais)
        {
            case "Espanha":
                imageViewPais.setImageResource(R.mipmap.espanha);
                break;
            case "México":
                imageViewPais.setImageResource(R.mipmap.mexico32);
                break;
            case "Porto Rico":
                imageViewPais.setImageResource(R.mipmap.portorico32);
                break;
            case "Bolívia":
                imageViewPais.setImageResource(R.mipmap.bolivia32);
                break;
            case "EUA":
                imageViewPais.setImageResource(R.mipmap.eua32);
                break;
            case "Inglaterra":
                imageViewPais.setImageResource(R.mipmap.inglaterra32);
                break;
            case "Nova Zelândia":
                imageViewPais.setImageResource(R.mipmap.novazelandia32);
                break;
            case "Jamaica":
                imageViewPais.setImageResource(R.mipmap.jamaica32);
                break;
            case "África do Sul":
                imageViewPais.setImageResource(R.mipmap.africadosul32);
                break;
            default:
                imageViewPais.setImageResource(R.mipmap.logo720x360);
                break;
        }

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

        checkBoxDesfile = (CheckBox) findViewById(R.id.checkBoxDesfile);
        checkBoxFluencia = (CheckBox) findViewById(R.id.checkBoxFluencia);
        checkBoxPresenca = (CheckBox) findViewById(R.id.checkBoxPresenca);
        checkBoxQualidade = (CheckBox) findViewById(R.id.checkBoxQualidade);
        checkBoxApresentacao = (CheckBox) findViewById(R.id.checkBoxApresentacao);
        checkBoxTempo = (CheckBox) findViewById(R.id.checkBoxTempo);

        btn_votar = (Button) findViewById(R.id.btnSalvar);

        value_seekbar = new int[6];

        palco = Palco.getVotos(codigo_pais+"."+jurado);
        if(palco != null)
        {
            seekBarDesfile.setProgress(palco.getDesfile_traje());
            countDesfile.setText(palco.getDesfile_traje() + " / " + seekBarDesfile.getMax());
            value_seekbar[0] = palco.getDesfile_traje();
            if(palco.getCheckbox().isDesfile_traje())
                checkBoxDesfile.setChecked(true);

            seekBarFluencia.setProgress(palco.getFluencia_lingua());
            countFluencia.setText(palco.getFluencia_lingua() + " / " + seekBarFluencia.getMax());
            value_seekbar[1] = palco.getFluencia_lingua();
            if(palco.getCheckbox().isFluencia_lingua())
                checkBoxFluencia.setChecked(true);

            seekBarPresenca.setProgress(palco.getPresenca_de_palco());
            countPresenca.setText(palco.getPresenca_de_palco() + " / " + seekBarPresenca.getMax());
            value_seekbar[2] = palco.getPresenca_de_palco();
            if(palco.getCheckbox().isPresenca_de_palco())
                checkBoxPresenca.setChecked(true);

            seekBarQualidade.setProgress(palco.getQualidade_slide());
            countQualidade.setText(palco.getQualidade_slide() + " / " + seekBarQualidade.getMax());
            value_seekbar[3] = palco.getQualidade_slide();
            if(palco.getCheckbox().isQualidade_slide())
                checkBoxQualidade.setChecked(true);

            seekBarApresentacao.setProgress(palco.getApresentacao_cultural());
            countApresentacao.setText(palco.getApresentacao_cultural() + " / " + seekBarApresentacao.getMax());
            value_seekbar[4] = palco.getApresentacao_cultural();
            if(palco.getCheckbox().isApresentacao_cultural())
                checkBoxApresentacao.setChecked(true);

            seekBarTempo.setProgress(palco.getUso_tempo());
            countTempo.setText(palco.getUso_tempo() + " / " + seekBarTempo.getMax());
            value_seekbar[5] = palco.getUso_tempo();
            if(palco.getCheckbox().isUso_tempo())
                checkBoxTempo.setChecked(true);
        }
        else
        {
            palco = new Palco();
            palco.setCodigo(codigo_pais+"."+jurado);
            palco.setCheckbox(new CheckBoxPalco());
        }

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

                palco.getCheckbox().setDesfile_traje(validarCheckBox(checkBoxDesfile,value_seekbar[0]));
                palco.getCheckbox().setApresentacao_cultural(validarCheckBox(checkBoxApresentacao,value_seekbar[4]));
                palco.getCheckbox().setFluencia_lingua(validarCheckBox(checkBoxFluencia,value_seekbar[1]));
                palco.getCheckbox().setPresenca_de_palco(validarCheckBox(checkBoxPresenca,value_seekbar[2]));
                palco.getCheckbox().setQualidade_slide(validarCheckBox(checkBoxQualidade,value_seekbar[3]));
                palco.getCheckbox().setUso_tempo(validarCheckBox(checkBoxTempo,value_seekbar[5]));
                palco.getCheckbox().save();

                palco.setDesfile_traje(value_seekbar[0]);
                palco.setFluencia_lingua(value_seekbar[1]);
                palco.setPresenca_de_palco(value_seekbar[2]);
                palco.setQualidade_slide(value_seekbar[3]);
                palco.setApresentacao_cultural(value_seekbar[4]);
                palco.setUso_tempo(value_seekbar[5]);
                palco.setStatus_envio(2);
                palco.save();
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
