package com.example.ann_gebraversion_beta;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ann_gebraversion_beta.utils.Calculadora_matriz;
import com.example.ann_gebraversion_beta.utils.NumberParser;

public class matricesactivity extends AppCompatActivity {

    GridLayout gridA, gridB;

    EditText[][] matrizAInputs =
            new EditText[2][2];

    EditText[][] matrizBInputs =
            new EditText[2][2];

    Button btnSuma,
            btnResta,
            btnMultiplicar;

    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_matrix);

        gridA = findViewById(R.id.gridA);
        gridB = findViewById(R.id.gridB);

        btnSuma = findViewById(R.id.btnSuma);
        btnResta = findViewById(R.id.btnResta);
        btnMultiplicar =
                findViewById(R.id.btnMultiplicar);

        txtResultado =
                findViewById(R.id.txtResultado);

        crearMatrices();

        btnSuma.setOnClickListener(v -> {

            try {

                double[][] A = obtenerMatriz(
                        matrizAInputs);

                double[][] B = obtenerMatriz(
                        matrizBInputs);

                double[][] resultado =
                        Calculadora_matriz.suma(A, B);

                txtResultado.setText(
                        Calculadora_matriz
                                .matrizToString(resultado));

            } catch (Exception e){

                txtResultado.setText(
                        "Error: ingrese números válidos");
            }
        });

        btnResta.setOnClickListener(v -> {

            try {

                double[][] A = obtenerMatriz(
                        matrizAInputs);

                double[][] B = obtenerMatriz(
                        matrizBInputs);

                double[][] resultado =
                        Calculadora_matriz.resta(A, B);

                txtResultado.setText(
                        Calculadora_matriz
                                .matrizToString(resultado));

            } catch (Exception e){

                txtResultado.setText(
                        "Error: ingrese números válidos");
            }
        });

        btnMultiplicar.setOnClickListener(v -> {

            try {

                double[][] A = obtenerMatriz(
                        matrizAInputs);

                double[][] B = obtenerMatriz(
                        matrizBInputs);

                double[][] resultado =
                        Calculadora_matriz
                                .multiplicar(A, B);

                txtResultado.setText(
                        Calculadora_matriz
                                .matrizToString(resultado));

            } catch (Exception e){

                txtResultado.setText(
                        "Error: ingrese números válidos");
            }
        });
    }

    private void crearMatrices(){

        for(int i=0;i<2;i++){

            for(int j=0;j<2;j++){

                EditText editA =
                        new EditText(this);

                editA.setWidth(180);

                editA.setHint("0");

                matrizAInputs[i][j] = editA;

                gridA.addView(editA);

                EditText editB =
                        new EditText(this);

                editB.setWidth(180);

                editB.setHint("0");

                matrizBInputs[i][j] = editB;

                gridB.addView(editB);
            }
        }
    }

    private double[][] obtenerMatriz(
            EditText[][] inputs){

        double[][] matriz =
                new double[2][2];

        for(int i=0;i<2;i++){

            for(int j=0;j<2;j++){

                matriz[i][j] =
                        NumberParser.parse(
                                inputs[i][j]
                                        .getText()
                                        .toString());
            }
        }

        return matriz;
    }
}