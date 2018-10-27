package com.example.user.temperature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static DecimalFormat df2 = new DecimalFormat(".##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button c_f_button = findViewById(R.id.c_f);
        Button f_c_button = findViewById(R.id.f_c);
        final TextView result = findViewById(R.id.result);
        final EditText edit_text = findViewById(R.id.edittext);

        c_f_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String raw_in = edit_text.getText().toString();

                if (raw_in.isEmpty()) {
                    alert_input_valid();
                } else {
                    Double input = Double.valueOf(raw_in);
                    result.setText(cal_c_to_f(input));
                }
            }
        });

        f_c_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String raw_in = edit_text.getText().toString();

                if (raw_in.isEmpty()) {
                    alert_input_valid();
                } else {
                    Double input = Double.valueOf(raw_in);
                    result.setText(cal_f_to_c(input));
                }
            }
        });

    }

    public String cal_c_to_f(Double input) {
        return df2.format(input * 1.8 + 32.0);
    }

    public String cal_f_to_c(Double input) {
        return df2.format((input - 32.0) / 1.8);
    }

    public void alert_input_valid() {

        Toast t = Toast.makeText(getApplicationContext(), R.string.input_some,Toast.LENGTH_LONG);
        t.show();

    }
}

