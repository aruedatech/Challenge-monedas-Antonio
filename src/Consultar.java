import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SuppressWarnings("ALL")
public class Consultar {

    public Moneda buscarMoneda(String from, String to) {
        try {
            // URL de la API con los códigos de moneda
            URI url = URI.create("https://v6.exchangerate-api.com/v6/5f81b1c61c47a764f7e175f4/pair/" + from + "/" + to);

            // Cliente HTTP y solicitud
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(url).build();

            // Obtener respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            // Convertir JSON a objeto
            Gson gson = new Gson();
            JsonObject json = gson.fromJson(responseBody, JsonObject.class);

            // Verificar errores de la API
            if (json.has("result") && json.get("result").getAsString().equals("error")) {
                String errorType = json.has("error-type") ? json.get("error-type").getAsString() : "desconocido";
                throw new RuntimeException("Error en la API: " + errorType + " ❌");
            }

            // Crear objeto Moneda con la información de conversión
            double rate = json.get("conversion_rate").getAsDouble();
            return new Moneda(from, to, rate);

        } catch (Exception e) {
            System.out.println("No se pudo obtener la tasa de cambio. Revisa los códigos de moneda o tu conexión. ❌");
            return null;
        }
    }

    // 👇 Aquí sí es válido
    public static void main(String[] args) {
        Consultar consulta = new Consultar();
        Moneda moneda = consulta.buscarMoneda("USD", "MXN");
        System.out.println(moneda);
    }
}
