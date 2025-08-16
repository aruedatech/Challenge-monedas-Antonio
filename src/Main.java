import java.util.Scanner;

@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consultar consulta = new Consultar();

        System.out.println("===== BIENVENIDO AL CONVERTIDOR DE MONEDAS =====");

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Convertir moneda");
            System.out.println("2. Salir");
            System.out.print("Opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    Convertir.convertirMoneda(consulta, scanner);
                    break;
                case "2":
                    continuar = false;
                    System.out.println("Gracias por usar el convertidor. ¡Hasta luego! 👋");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor seleccione 1 o 2. ❌");
            }
        }

        scanner.close();
    }
}
