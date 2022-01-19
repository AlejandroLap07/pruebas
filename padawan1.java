import java.util.InputMismatchException;
import java.util.Scanner;
import java.Arrays;

public class padawan1 {
    public static void main(String[] args) {
        Double numprecipitaciones, maxPrecipitaciones = 0.0, media = 0.0, mediana = 0.0, desviacion = 0.0;
        Double[] precipitaciones;
        precipitaciones = new Double[12];
        String[] mes = { "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre",
                "octubre", "noviembre", "deciembre" };
        Scanner teclado = new Scanner(System.in);
        int i = 0, posMaximo = 0;

        while (i < mes.length) {

            try {
                System.out.println(mes[i] + ": ");
                numprecipitaciones = teclado.nextDouble();
                precipitaciones[i] = numprecipitaciones;
                i++;
            } catch (InputMismatchException e) {
                System.out.println("Error: debe teclear un valor double");
                teclado.next();
            }

        }

        for (i = 0; i < precipitaciones.length; i++) {
            if (precipitaciones[i] > maxPrecipitaciones) {
                maxPrecipitaciones = precipitaciones[i];
                posMaximo = i;
            }
            media += precipitaciones[i];
        }

        media = media / precipitaciones.length;

        if (precipitaciones.length % 2 == 0) {
            int resultado = (int) (precipitaciones.length - 1) / 2;
            int n = resultado + 1;
            mediana = (precipitaciones[resultado] + precipitaciones[n]) / 2;
            Arrays.sort(precipitaciones);
        } else {
            int resultado = (int) precipitaciones.length / 2;
            mediana = (double) resultado;
        }

        for (i = 0; i < mes.length; i++) {
            desviacion += Math.pow((precipitaciones[i] - media), 2);
            desviacion /= 12;
        }
        desviacion = Math.sqrt(desviacion);
        System.out.printf("\n El mes mas lluvioso es %s con %5.2f mm", mes[posMaximo], maxPrecipitaciones);
        System.out.printf("\n Media: %4.2f", media);
        System.out.printf("\n Mediana: %4.2f", mediana);
        System.out.printf("\n Desviacion: %4.2f", desviacion);
        //Un cambio muy importante
    }
}
