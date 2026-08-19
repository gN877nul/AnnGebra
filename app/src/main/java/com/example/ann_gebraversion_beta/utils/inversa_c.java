package com.example.ann_gebraversion_beta.utils;

public class inversa_c {

    public static String inversa2x2(
            double p1,
            double p2,
            double p3,
            double p4){

        double D =
                (p1*p4)-(p2*p3);

        if(D == 0){

            return "La matriz no tiene inversa";
        }

        return
                String.format(
                        "%.3f   %.3f\n%.3f   %.3f",
                        (p4/D),
                        (-(p2)/D),
                        (-(p3)/D),
                        (p1/D)
                );
    }

    public static String inversa3x3(

            double p1,
            double p2,
            double p3,

            double p4,
            double p5,
            double p6,

            double p7,
            double p8,
            double p9){

        double D =
                ((p1*p5*p9)+(p4*p8*p3)+(p7*p2*p6))
                        -
                        ((p7*p5*p3)+(p1*p8*p6)+(p4*p2*p9));

        if(D == 0){

            return "La matriz no tiene inversa";
        }

        double[][] og =
                new double[3][3];

        double[][] inversa =
                new double[3][3];

        og[0][0] = (p5*p9)-(p6*p8);
        og[0][1] = (p4*p9)-(p7*p6);
        og[0][2] = (p4*p8)-(p7*p5);

        og[1][0] = (p2*p9)-(p8*p3);
        og[1][1] = (p1*p9)-(p7*p3);
        og[1][2] = (p1*p8)-(p7*p2);

        og[2][0] = (p2*p6)-(p5*p3);
        og[2][1] = (p1*p6)-(p4*p3);
        og[2][2] = (p1*p5)-(p4*p2);

        for(int i=0;i<3;i++){

            for(int j=0;j<3;j++){

                inversa[i][j] =
                        og[j][i]/D;
            }
        }

        return String.format(

                "%.3f   %.3f   %.3f\n" +
                        "%.3f   %.3f   %.3f\n" +
                        "%.3f   %.3f   %.3f",

                inversa[0][0],
                -inversa[0][1],
                inversa[0][2],

                -inversa[1][0],
                inversa[1][1],
                -inversa[1][2],

                inversa[2][0],
                -inversa[2][1],
                inversa[2][2]
        );
    }
}
