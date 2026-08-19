package com.example.ann_gebraversion_beta.utils;

public class Vectores {

    public static double[] sumaVectores(double[][] vectores) {

        double sumaX = 0;
        double sumaY = 0;

        for (double[] v : vectores) {

            sumaX += v[0];
            sumaY += v[1];
        }

        return new double[]{
                sumaX,
                sumaY
        };
    }

    public static double[] restaVectores(double[][] vectores) {

        double restaX = vectores[0][0];
        double restaY = vectores[0][1];

        for (int i = 1; i < vectores.length; i++) {

            restaX -= vectores[i][0];
            restaY -= vectores[i][1];
        }

        return new double[]{
                restaX,
                restaY
        };
    }
}