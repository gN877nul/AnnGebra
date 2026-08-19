package com.example.ann_gebraversion_beta;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ann_gebraversion_beta.utils.NumberParser;
import com.example.ann_gebraversion_beta.utils.Vectores;

public class vectoractivity extends AppCompatActivity {

    EditText editVectores;

    Button btnSumar, btnRestar;

    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_vector);

        editVectores = findViewById(R.id.editVectores);

        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);

        txtResultado = findViewById(R.id.txtResultado);

        btnSumar.setOnClickListener(v -> {

            try {

                double[][] vectores =
                        obtenerVectores();

                double[] resultado =
                        Vectores.sumaVectores(vectores);

                txtResultado.setText(
                        "Resultado:\n[" +
                                resultado[0] +
                                ", " +
                                resultado[1] + "]");

            } catch (Exception e){

                txtResultado.setText(
                        "Error: formato inválido.\nEjemplo:\n1,2\n3,4");
            }
        });

        btnRestar.setOnClickListener(v -> {

            try {

                double[][] vectores =
                        obtenerVectores();

                double[] resultado =
                        Vectores.restaVectores(vectores);

                txtResultado.setText(
                        "Resultado:\n[" +
                                resultado[0] +
                                ", " +
                                resultado[1] + "]");

            } catch (Exception e){

                txtResultado.setText(
                        "Error: formato inválido.\nEjemplo:\n1,2\n3,4");
            }
        });
    }

    private double[][] obtenerVectores() {

        String texto =
                editVectores.getText()
                        .toString()
                        .trim();

        String[] lineas = texto.split("\n");

        double[][] vectores =
                new double[lineas.length][2];

        for (int i = 0; i < lineas.length; i++) {

            String[] partes =
                    lineas[i].split(",");

            if(partes.length != 2){

                throw new IllegalArgumentException(
                        "Vector inválido");
            }

            vectores[i][0] =
                    NumberParser.parse(
                            partes[0].trim());

            vectores[i][1] =
                    NumberParser.parse(
                            partes[1].trim());
        }

        return vectores;
    }
}