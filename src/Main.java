import javax.swing.*;
import java.util.function.DoubleUnaryOperator;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Main {
    public static void main(String[] args) {
        while (true) {
            int opcion = ingresarEntero("Conversores Vikingos\n\n 1.¡Divisas del Valhalla!\n 2.¡Distancias Épicas!\n 3.¡Abandonar Batalla!");
            if (opcion == 3) {
                mostrarMensaje("¡Hasta la próxima! Que Odin te acompañe");
                return;
            } else if (opcion == 1) {
                divisas();
            } else if (opcion == 2) {
                distancia();
            } else {
                mostrarMensaje("¡Opción Incorrecta! Solo acepta números entre 1 y 3");
            }
        }
    }

    public static void distancia() {
        int distancia = ingresarEntero("¡Conversor de Distancias Épicas!\n\n 1.¡Metros Vikingos!\n 2.¡Retirada!");
        if (distancia == 1) {
            double metros = ingresarValor("Ingresa el valor en metros:");
            mostrarResultado(metros, "Milímetros Vikingos", valor -> valor * 1000);
            mostrarResultado(metros, "Centímetros Vikingos", valor -> valor * 100);
            mostrarResultado(metros, "Kilómetros Vikingos", valor -> valor * 0.001);
        } else if (distancia == 2) {
            mostrarMensaje("¡Retirada estratégica!");
        } else {
            mostrarMensaje("¡Opción Incorrecta!");
        }
    }

    private static int ingresarEntero(String mensaje) {
        return Integer.parseInt(showInputDialog(null, mensaje));
    }

    private static double ingresarValor(String mensaje) {
        return Double.parseDouble(showInputDialog(null, mensaje));
    }

    private static void mostrarMensaje(String mensaje) {
        showMessageDialog(null, mensaje);
    }

    private static void mostrarResultado(double valor, String unidad, DoubleUnaryOperator conversor) {
        double resultado = conversor.applyAsDouble(valor);
        mostrarMensaje(String.format("El valor es: %.2f %s", resultado, unidad));
    }

    public static void divisas() {
        String[] nombresDivisas = {"Dólar Nórdico", "Euro Valhalariano", "Libra Vikinga", "Yen de los Berserkers", "Won del Ragnarok"};
        String[] nombresUnidades = {"Pesos Vikingos", "Pesos Vikingos", "Pesos Vikingos", "Pesos Vikingos", "Pesos Vikingos"};
        float[] factoresConversion = {17, 20, 23, 0.17f, 0.015f};

        int divisa = ingresarEntero("¡Conversor de Divisas del Valhalla!\n\n 1.¡Dólar Nórdico!\n 2.¡Euro Valhalariano!\n 3.¡Libra Vikinga!\n 4.¡Yen de los Berserkers!\n 5.¡Won del Ragnarok!\n 6.¡Retirada!");
        if (divisa >= 1 && divisa <= 5) {
            String divisaOrigen = nombresDivisas[divisa - 1];
            String unidadOrigen = nombresUnidades[divisa - 1];
            float factorConversion = factoresConversion[divisa - 1];

            while (true) {
                int opcion = ingresarEntero(String.format("¡Conversor de %s!\n\n 1.¡Convertir de %s a %s!\n 2.¡Convertir de %s a %s!\n 3.¡Retirada!", divisaOrigen, unidadOrigen, divisaOrigen, divisaOrigen, unidadOrigen));
                if (opcion >= 1 && opcion <= 2) {
                    float cantidad = (float) ingresarValor(String.format("Ingresa la cantidad en %s", opcion == 1 ? unidadOrigen : divisaOrigen));
                    mostrarResultado(cantidad, opcion == 1 ? divisaOrigen : unidadOrigen, valor -> valor * (opcion == 1 ? (1 / factorConversion) : factorConversion));
                } else if (opcion == 3) {
                    return;
                } else {
                    mostrarMensaje("¡Opción Incorrecta! Solo acepta números entre 1 y 3");
                }
            }
        } else if (divisa == 6) {
            mostrarMensaje("¡Retirada táctica! ¡Que los dioses te acompañen!");
        } else {
            mostrarMensaje("¡Opción Incorrecta! ¡Que los dioses guíen tus elecciones!");
        }
    }
}
