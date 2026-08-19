package com.example.ann_gebraversion_beta;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ann_gebraversion_beta.utils.NumberParser;
import com.example.ann_gebraversion_beta.utils.inversa_c;

public class MatrizInversaActivity extends AppCompatActivity {

    EditText[][] inputs2x2 =
            new EditText[2][2];

    EditText[][] inputs3x3 =
            new EditText[3][3];

    GridLayout grid2x2,
            grid3x3;

    Button btnInversa2x2,
            btnInversa3x3;

    TextView txtResultado2x2,
            txtResultado3x3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_matriz_inversa);

        grid2x2 = findViewById(R.id.grid2x2);
        grid3x3 = findViewById(R.id.grid3x3);

        btnInversa2x2 =
                findViewById(R.id.btnInversa2x2);

        btnInversa3x3 =
                findViewById(R.id.btnInversa3x3);

        txtResultado2x2 =
                findViewById(R.id.txtResultado2x2);

        txtResultado3x3 =
                findViewById(R.id.txtResultado3x3);

        crearGrid2x2();
        crearGrid3x3();

        btnInversa2x2.setOnClickListener(v -> {

            try {

                double[][] m =
                        obtener2x2();

                String resultado =
                        inversa_c.inversa2x2(

                                m[0][0],
                                m[0][1],
                                m[1][0],
                                m[1][1]
                        );

                txtResultado2x2.setText(resultado);

            } catch (Exception e){

                txtResultado2x2.setText(
                        "Error: ingrese números válidos");
            }
        });

        btnInversa3x3.setOnClickListener(v -> {

            try {

                double[][] m =
                        obtener3x3();

                String resultado =
                        inversa_c.inversa3x3(

                                m[0][0],
                                m[0][1],
                                m[0][2],

                                m[1][0],
                                m[1][1],
                                m[1][2],

                                m[2][0],
                                m[2][1],
                                m[2][2]
                        );

                txtResultado3x3.setText(resultado);

            } catch (Exception e){

                txtResultado3x3.setText(
                        "Error: ingrese números válidos");
            }
        });
    }

    private void crearGrid2x2(){

        for(int i=0;i<2;i++){

            for(int j=0;j<2;j++){

                EditText edit =
                        new EditText(this);

                edit.setWidth(180);
                edit.setHint("0");

                inputs2x2[i][j] = edit;

                grid2x2.addView(edit);
            }
        }
    }

    private void crearGrid3x3(){

        for(int i=0;i<3;i++){

            for(int j=0;j<3;j++){

                EditText edit =
                        new EditText(this);

                edit.setWidth(180);
                edit.setHint("0");

                inputs3x3[i][j] = edit;

                grid3x3.addView(edit);
            }
        }
    }

    private double[][] obtener2x2(){

        double[][] matriz =
                new double[2][2];

        for(int i=0;i<2;i++){

            for(int j=0;j<2;j++){

                matriz[i][j] =
                        NumberParser.parse(

                                inputs2x2[i][j]
                                        .getText()
                                        .toString());
            }
        }

        return matriz;
    }

    private double[][] obtener3x3(){

        double[][] matriz =
                new double[3][3];

        for(int i=0;i<3;i++){

            for(int j=0;j<3;j++){

                matriz[i][j] =
                        NumberParser.parse(

                                inputs3x3[i][j]
                                        .getText()
                                        .toString());
            }
        }

        return matriz;
    }
}