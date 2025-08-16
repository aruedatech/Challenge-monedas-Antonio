import java.util.InputMismatchException;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class ConvertirMoneda {

    // Método que realiza la conversión de monedas
    public static void convertir(String from, String to, ConsultarMoneda consulta, Scanner scanner) {
        try {
            // Buscar información de la moneda usando la API
            Moneda moneda = consulta.buscarMoneda(from, to);

            if (moneda == null) {
                System.out.println("❌ No se pudo obtener información de la conversión.");
                return;
            }

            System.out.print("Ingrese la cantidad de " + from + ": ");

            double cantidad;
            try {
                cantidad = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("❌ Error: Debes ingresar un número válido.");
                scanner.next(); // limpiar la entrada incorrecta
                return;
            }

            if (cantidad <= 0) {
                System.out.println("❌ Error: La cantidad debe ser mayor que cero.");
                return;
            }

            scanner.nextLine(); // limpiar buffer

            // Calcular el resultado de la conversión
            double resultado = cantidad * moneda.conversion_rate();

            // Mostrar los resultados
            System.out.println("📈 Tasa actual: 1 " + from + " = " + moneda.conversion_rate() + " " + to);
            System.out.println("✔ " + cantidad + " " + from + " = " + resultado + " " + to);

        } catch (Exception e) {
            System.out.println("❌ Ocurrió un error al convertir: " + e.getMessage());
        }
    }

    // Método que pide al usuario los códigos de moneda y luego llama a convertir()
    public static void convertirMoneda(ConsultarMoneda consulta, Scanner scanner) {
        System.out.print("Ingrese el código de la moneda de origen (ej: USD): ");
        String from = scanner.nextLine().toUpperCase();

        System.out.print("Ingrese el código de la moneda de destino (ej: EUR): ");
        String to = scanner.nextLine().toUpperCase();

        if (from.isEmpty() || to.isEmpty()) {
            System.out.println("❌ Error: Los códigos de moneda no pueden estar vacíos.");
            return;
        }

        convertir(from, to, consulta, scanner);
    }
}
