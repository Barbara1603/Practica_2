
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Set;

public class GestionCiudades {
    private static Set<Ciudad> ciudades = new TreeSet<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            try {
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        añadirCiudad();
                        break;
                    case 2:
                        listarCiudades();
                        break;
                    case 3:
                        buscarCiudad();
                        break;
                    case 4:
                        salir = true;
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un número del 1 al 4.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE CIUDADES ---");
        System.out.println("1. Añadir ciudad");
        System.out.println("2. Listar ciudades (ordenadas por habitantes)");
        System.out.println("3. Buscar ciudad");
        System.out.println("4. Salir");
        System.out.print("Elige una opción: ");
    }

    private static void añadirCiudad() {
        System.out.print("Nombre de la ciudad: ");
        String nombre = scanner.nextLine();

        System.out.print("País: ");
        String pais = scanner.nextLine();

        System.out.print("Número de habitantes: ");
        try {
            int habitantes = Integer.parseInt(scanner.nextLine());
            Ciudad ciudad = new Ciudad(nombre, pais, habitantes);

            if (ciudades.add(ciudad)) {
                System.out.println("✅ Ciudad añadida.");
            } else {
                System.out.println("❌ La ciudad ya existe.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Los habitantes deben ser un número.");
        }
    }

    private static void listarCiudades() {
        if (ciudades.isEmpty()) {
            System.out.println("No hay ciudades registradas.");
            return;
        }

        System.out.println("\n--- LISTA DE CIUDADES ---");
        for (Ciudad ciudad : ciudades) {
            System.out.println(ciudad);
        }
    }

    private static void buscarCiudad() {
        System.out.print("Nombre de la ciudad a buscar: ");
        String nombre = scanner.nextLine();

        System.out.print("País: ");
        String pais = scanner.nextLine();

        for (Ciudad ciudad : ciudades) {
            if (ciudad.getNombre().equalsIgnoreCase(nombre) &&
                    ciudad.getPais().equalsIgnoreCase(pais)) {
                System.out.println("🔍 Resultado: " + ciudad);
                return;
            }
        }
        System.out.println("No se encontró la ciudad.");
    }
}