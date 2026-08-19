package com.example.ann_gebraversion_beta.utils;

public class NumberParser {

    public static double parse(String valor)
            throws NumberFormatException {

        valor = valor.trim();

        if(valor.contains("/")){

            String[] partes =
                    valor.split("/");

            if(partes.length != 2){

                throw new NumberFormatException(
                        "Fracción inválida");
            }

            double numerador =
                    Double.parseDouble(
                            partes[0]);

            double denominador =
                    Double.parseDouble(
                            partes[1]);

            if(denominador == 0){

                throw new NumberFormatException(
                        "División entre cero");
            }

            return numerador / denominador;
        }

        return Double.parseDouble(valor);
    }
}

