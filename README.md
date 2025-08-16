💱 Convertidor de Monedas en Java

Este proyecto es un convertidor de monedas desarrollado en Java, que permite consultar tasas de cambio en tiempo real mediante la API de ExchangeRate.
Utiliza Gson para procesar respuestas JSON y cuenta con un menú interactivo en consola, ofreciendo una experiencia completa para el usuario.

🔹Funcionalidades

Consultar la tasa de conversión entre cualquier par de monedas soportadas por la API.
Filtrado de monedas específicas (ARS, BOB, BRL, CLP, COP, USD).
Menú interactivo en consola para convertir monedas o salir.
Manejo de errores por códigos inválidos o problemas de conexión.
Código modular: Main, ConsultarMoneda, ConvertirMoneda, Moneda.
Uso de buenas prácticas de programación: métodos específicos, modularidad y pruebas exhaustivas.

⚙️ Requisitos

Java 11+
Conexión a Internet
Librería Gson (lib/gson-2.10.1.jar)

📂 Estructura del proyecto

Challenge-monedas-Antonio/

├── lib/
│   └── gson-2.10.1.jar
├── src/
│   ├── Main.java
│   ├── ConsultarMoneda.java
│   ├── ConvertirMoneda.java
│   └── Moneda.java
└── README.md

🧩 Fases del proyecto

HttpRequest: Configuración de solicitudes HTTP para la API de ExchangeRate.
HttpResponse: Gestión de respuestas, análisis de códigos de estado, encabezados y cuerpo JSON.
Gson y JSON: Mapeo de respuestas JSON a objetos Java usando JsonObject y JsonParser.
Filtrado de monedas: Selección de monedas específicas mediante el atributo "Currency Code".
Conversión de monedas: Implementación de la lógica para calcular los valores convertidos usando las tasas obtenidas.
Interfaz de usuario: Menú interactivo en consola con Scanner, pruebas exhaustivas y manejo de errores.

🖥️ Cómo usar 

Desde consola

javac -cp ".;lib\gson-2.10.1.jar" -d out src\*.java
java -cp ".;out;lib\gson-2.10.1.jar" Main

🎯 Uso rápido

Ejecuta el programa y verás:

===== BIENVENIDO AL CONVERTIDOR DE MONEDAS =====
Seleccione una opción:
1. Convertir moneda
2. Salir
