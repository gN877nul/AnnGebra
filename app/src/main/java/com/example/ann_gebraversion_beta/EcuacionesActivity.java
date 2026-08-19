package com.example.ann_gebraversion_beta;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ann_gebraversion_beta.utils.Ecuaciones;
import com.example.ann_gebraversion_beta.utils.NumberParser;

public class EcuacionesActivity extends AppCompatActivity {

    EditText editX1,
            editY1,
            editE1,
            editX2,
            editY2,
            editE2;

    EditText[][] inputs3x3 =
            new EditText[3][4];

    GridLayout grid3x3;

    Button btnResolver2x2,
            btnResolver3x3;

    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ecuacion);

        editX1 = findViewById(R.id.editX1);
        editY1 = findViewById(R.id.editY1);
        editE1 = findViewById(R.id.editE1);

        editX2 = findViewById(R.id.editX2);
        editY2 = findViewById(R.id.editY2);
        editE2 = findViewById(R.id.editE2);

        grid3x3 = findViewById(R.id.grid3x3);

        btnResolver2x2 =
                findViewById(R.id.btnResolver2x2);

        btnResolver3x3 =
                findViewById(R.id.btnResolver3x3);

        txtResultado =
                findViewById(R.id.txtResultado);

        crearGrid3x3();

        btnResolver2x2.setOnClickListener(v -> {

            try {

                String resultado =
                        Ecuaciones.resolver2x2(

                                NumberParser.parse(
                                        editX1.getText().toString()),

                                NumberParser.parse(
                                        editY1.getText().toString()),

                                NumberParser.parse(
                                        editE1.getText().toString()),

                                NumberParser.parse(
                                        editX2.getText().toString()),

                                NumberParser.parse(
                                        editY2.getText().toString()),

                                NumberParser.parse(
                                        editE2.getText().toString())
                        );

                txtResultado.setText(resultado);

            } catch (Exception e) {

                txtResultado.setText(
                        "Error: ingrese números válidos");
            }
        });

        btnResolver3x3.setOnClickListener(v -> {

            try {

                double[][] valores =
                        obtenerValores3x3();

                String resultado =
                        Ecuaciones.resolver3x3(

                                valores[0][0],
                                valores[0][1],
                                valores[0][2],
                                valores[0][3],

                                valores[1][0],
                                valores[1][1],
                                valores[1][2],
                                valores[1][3],

                                valores[2][0],
                                valores[2][1],
                                valores[2][2],
                                valores[2][3]
                        );

                txtResultado.setText(resultado);

            } catch (Exception e) {

                txtResultado.setText(
                        "Error: ingrese números válidos");
            }
        });
    }

    private void crearGrid3x3() {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 4; j++) {

                EditText edit =
                        new EditText(this);

                edit.setWidth(170);

                edit.setHint("0");

                inputs3x3[i][j] = edit;

                grid3x3.addView(edit);
            }
        }
    }

    private double[][] obtenerValores3x3() {

        double[][] valores =
                new double[3][4];

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 4; j++) {

                valores[i][j] =
                        NumberParser.parse(

                                inputs3x3[i][j]
                                        .getText()
                                        .toString());
            }
        }

        return valores;
    }
}