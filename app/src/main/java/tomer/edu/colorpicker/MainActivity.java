package tomer.edu.colorpicker;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    EditText etRed, etGreen, etBlue;
    EditText etResult;
    SeekBar sbRed, sbGreen, sbBlue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etRed = (EditText) findViewById(R.id.etRed);
        etBlue = (EditText) findViewById(R.id.etBlue);
        etGreen = (EditText) findViewById(R.id.etGreen);

        etResult = (EditText) findViewById(R.id.etResult);


        sbRed = (SeekBar) findViewById(R.id.sbRed);
        sbGreen = (SeekBar) findViewById(R.id.sbGreen);
        sbBlue = (SeekBar) findViewById(R.id.sbBlue);

        sbRed.setOnSeekBarChangeListener(this);
        sbGreen.setOnSeekBarChangeListener(this);
        sbBlue.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        if (seekBar == sbRed){
            etRed.setText(String.valueOf(progress));
        }
        else if (seekBar == sbGreen){
            etGreen.setText(String.valueOf(progress));
        }
        else if (seekBar == sbBlue){
            etBlue.setText(String.valueOf(progress));
        }


        int red = sbRed.getProgress();
        int green = sbGreen.getProgress();
        int blue = sbBlue.getProgress();

        int rgb = Color.rgb(red, green, blue);
        etResult.setBackgroundColor(rgb);

        String hexString = Integer.toHexString(rgb);
        etResult.setText(hexString);

        /*etRed.setText(String.valueOf(sbRed.getProgress()));
        etGreen.setText(String.valueOf(sbGreen.getProgress()));
        etBlue.setText(String.valueOf(sbBlue.getProgress()));*/
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
