package management;

import entities.Agente;
import java.util.ArrayList;
import utils.ConsoleUtils;

public class AgenteManager {
    private ArrayList<Agente> agentes;

    public AgenteManager() {
        this.agentes = new ArrayList<>();
    }

    public void registrarAgente() {
        int id = ConsoleUtils.leerEntero("Ingrese el ID del agente: ");
        ConsoleUtils.limpiarBuffer(); // Consumir cualquier salto de línea residual

        String nombre = ConsoleUtils.leerTexto("Ingrese el nombre del agente: ");
        String habilidad = ConsoleUtils.leerTexto("Ingrese la habilidad especial del agente: ");
        int nivelInicial = ConsoleUtils.leerEntero("Ingresa el nivel inicial del agente: ");

        Agente nuevoAgente = new Agente(id, nombre, habilidad, nivelInicial);
        agentes.add(nuevoAgente);
        System.out.println("Agente registrado con éxito.");
    }

    public void mostrarAgentes() {
        if (agentes.isEmpty()) {
            System.out.println("No hay agentes registrados.");
            return;
        }
        System.out.println("=== Lista de Agentes ===");
        for (Agente agente : agentes) {
            System.out.println(agente);
        }
    }

    //Metodo para incrementar el nivel del agente 
    public void incrementarNivelAgente() {
        if (agentes.isEmpty()) {
            System.out.println("Debes crear minimo un agente");
        } else {
            int id = ConsoleUtils.leerEntero("Ingrese el ID del agente al que quieres incrementar su nivel: ");
            ConsoleUtils.limpiarBuffer(); // Consumir cualquier salto de línea residual
            for (Agente agente : agentes) {
                if (agente.getId() == id) {
                    System.out.println("Agente encontrado: " + agente.getNombre() + " Nivel Inicial: " + agente.getNivel());
                    agente.incrementarNivel();
                    System.out.println("Luego de incrementar el nievel del agente: " + agente.getNivel());
                } else {
                    System.out.println("Su id " + id + " no coincide con ningun agente.");
                }
            }
        }
    }

    public void mostrarMenu() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== Menú Agentes ===");
            System.out.println("1. Registrar Agente");
            System.out.println("2. Mostrar Agentes");
            System.out.println("3. Incrementar nivel del agente.");
            System.out.println("4. Volver al inicio");
            System.out.println("5. Salir");
            int opcion = ConsoleUtils.leerEntero("Seleccione una opción: ");
            ConsoleUtils.limpiarBuffer(); // Consumir cualquier salto de línea residual

            switch (opcion) {
                case 1 -> registrarAgente();
                case 2 -> mostrarAgentes();
                case 3 -> incrementarNivelAgente();
                case 4 -> {
                    ConsoleUtils.mostrarMenuInicial();
                    ConsoleUtils.validarOpcion();
                }
                case 5 -> continuar = false;
                default -> System.out.println("Opción no válida.");
            }
        }
    }
}