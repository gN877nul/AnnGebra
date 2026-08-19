package com.example.ann_gebraversion_beta.utils;

public class Calculadora_matriz {

    public static double[][] suma(
            double[][] A,
            double[][] B){

        int filas = A.length;
        int columnas = A[0].length;

        double[][] resultado =
                new double[filas][columnas];

        for(int i=0;i<filas;i++){

            for(int j=0;j<columnas;j++){

                resultado[i][j] =
                        A[i][j] + B[i][j];
            }
        }

        return resultado;
    }

    public static double[][] resta(
            double[][] A,
            double[][] B){

        int filas = A.length;
        int columnas = A[0].length;

        double[][] resultado =
                new double[filas][columnas];

        for(int i=0;i<filas;i++){

            for(int j=0;j<columnas;j++){

                resultado[i][j] =
                        A[i][j] - B[i][j];
            }
        }

        return resultado;
    }

    public static double[][] multiplicar(
            double[][] A,
            double[][] B){

        int filas = A.length;
        int columnas = B[0].length;
        int comun = B.length;

        double[][] resultado =
                new double[filas][columnas];

        for(int i=0;i<filas;i++){

            for(int j=0;j<columnas;j++){

                double suma = 0;

                for(int k=0;k<comun;k++){

                    suma += A[i][k] * B[k][j];
                }

                resultado[i][j] = suma;
            }
        }

        return resultado;
    }

    public static String matrizToString(
            double[][] matriz){

        StringBuilder builder =
                new StringBuilder();

        for(double[] fila : matriz){

            for(double valor : fila){

                builder.append(valor)
                        .append("   ");
            }

            builder.append("\n");
        }

        return builder.toString();
    }
}