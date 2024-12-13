package utils;

import java.util.Scanner;
import management.AgenteManager;
import management.AnomaliaManager;

public class ConsoleUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static void limpiarBuffer() {
        if (scanner.hasNextLine()) {
            scanner.nextLine(); // Consumir el salto de línea sobrante
        }
    }

    public static void mostrarMenuInicial() {
        System.out.println("\nBienvenido a Matrix Reloaded: Salvando la Humanidad");
        System.out.println("Elige una píldora para continuar:");
        System.out.println("1. Píldora Roja: Agentes de la Resistencia");
        System.out.println("2. Píldora Azul: Control de Anomalías");
    }

    public static void validarOpcion() {
        int opcion = ConsoleUtils.leerEntero("Selecciona una opción (1 o 2): ");

        if (opcion == 1) {
            AgenteManager agenteManager = new AgenteManager();
            agenteManager.mostrarMenu();
        } else if (opcion == 2) {
            AnomaliaManager anomaliaManager = new AnomaliaManager();
            anomaliaManager.mostrarMenu();
        } else {
            System.out.println("Opción no válida. Adiós.");
        }
    }
    
}
