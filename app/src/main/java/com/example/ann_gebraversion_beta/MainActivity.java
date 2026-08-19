package com.example.ann_gebraversion_beta;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CardView cardMatrices;
    CardView cardVectores;
    CardView cardEcuaciones;
    CardView cardInversa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        cardMatrices = findViewById(R.id.cardMatrices);
        cardVectores = findViewById(R.id.cardVectores);
        cardEcuaciones = findViewById(R.id.cardEcuaciones);
        cardInversa = findViewById(R.id.cardInversa);

        cardMatrices.setOnClickListener(v ->
                startActivity(new Intent(this, matricesactivity.class)));

        cardVectores.setOnClickListener(v ->
                startActivity(new Intent(this, vectoractivity.class)));

        cardEcuaciones.setOnClickListener(v ->
                startActivity(new Intent(this, EcuacionesActivity.class)));

        cardInversa.setOnClickListener(v ->
                startActivity(new Intent(this, MatrizInversaActivity.class)));

        };

    }
