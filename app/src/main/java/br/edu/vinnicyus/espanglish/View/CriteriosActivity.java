package br.edu.vinnicyus.espanglish.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import br.edu.vinnicyus.espanglish.R;

public class CriteriosActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView textView;
    SeekBar seekBar2;
    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criterios);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textView = (TextView) findViewById(R.id.count);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        text2 = (TextView) findViewById(R.id.count2);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;

            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText("Progress: " + seekBarProgress + " / " + seekBar.getMax());
            }

        });

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            int seekbarprogress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekbarprogress = progress;

            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                text2.setText( seekbarprogress + " / " + seekBar2.getMax());
            }
        });
    }

}
