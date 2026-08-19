package com.example.ann_gebraversion_beta.utils;

public class Ecuaciones {

    public static String resolver2x2(
            double x1,
            double y1,
            double e1,
            double x2,
            double y2,
            double e2){

        double D =
                (x1*y2)-(x2*y1);

        if(D == 0){
            return "Sin solución";
        }

        double Dx =
                ((e1*y2)-(e2*y1))/D;

        double Dy =
                ((x1*e2)-(x2*e1))/D;

        return "x = " + Dx +
                "\ny = " + Dy;
    }

    public static String resolver3x3(
            double x1,
            double y1,
            double z1,
            double e1,
            double x2,
            double y2,
            double z2,
            double e2,
            double x3,
            double y3,
            double z3,
            double e3){

        double D =
                ((x1*y2*z3)+(y1*z2*x3)+(z1*x2*y3))
                        -
                        ((z1*y2*x3)+(y1*x2*z3)+(x1*z2*y3));

        if(D == 0){
            return "Sin solución";
        }

        double Dx =
                (((e1*y2*z3)+(y1*z2*e3)+(z1*e2*y3))
                        -
                        ((z1*y2*e3)+(y1*e2*z3)+(e1*z2*y3))) / D;

        double Dy =
                (((x1*e2*z3)+(e1*z2*x3)+(z1*x2*e3))
                        -
                        ((z1*e2*x3)+(e1*x2*z3)+(x1*z2*e3))) / D;

        double Dz =
                (((x1*y2*e3)+(y1*e2*x3)+(e1*x2*y3))
                        -
                        ((e1*y2*x3)+(y1*x2*e3)+(x1*e2*y3))) / D;

        return "x = " + Dx +
                "\ny = " + Dy +
                "\nz = " + Dz;
    }
}