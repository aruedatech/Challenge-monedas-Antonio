💱 Convertidor de Monedas en Java

🔹 Funcionalidades

Consultar tasa de conversión entre cualquier par de monedas.

Menú interactivo en consola.
Manejo de errores por códigos inválidos o problemas de conexión.
Código modular: Main, Consultar, Convertir y Moneda.

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
