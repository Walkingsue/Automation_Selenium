🎬 IMDb Movie Info Scraper
Este proyecto automatiza la búsqueda de información de películas en IMDb utilizando Java, Selenium WebDriver, y JUnit/TestNG.

🚀 Funcionalidad
🔍 Busca películas por nombre desde la barra de búsqueda.

🎯 Encuentra coincidencias en los resultados y navega a la página correcta.

📝 Extrae información como:

Título de la película

Valoración (rating)

Géneros

💾 Guarda los resultados en archivos .txt

🛠️ Tecnologías
Java 17+

Selenium WebDriver

WebDriverManager (opcional)

TestNG

Maven (recomendado)

🧰 Estructura del Proyecto
src/
├── main/
│   └── java/
│       └── imdb/
│           └── org.example/
│               └── IMDbSearchPage.java
|               └── MoviePage.java
|               └── Main.java
├── test/
│   └── java/
│           └── Test.java

📦 Instalación
Clona el repositorio:

git clone https://github.com/Walkingsue/Automation_Selenium.git
cd tu-repo-imdb
Asegúrate de tener Maven instalado y configura el pom.xml con las dependencias necesarias:

selenium-java

testng o junit

webdrivermanager (opcional pero recomendado)

Ejecuta las pruebas:

mvn test

🧪 Ejemplo de uso

IMDbSearchPage page = new IMDbSearchPage(driver);
page.searchMovie("The Matrix");
String title = page.movieTitle();
📁 Archivos de salida
Los resultados extraídos se guardan en:

resultado_test2.txt

Ejemplo:

Title: The Matrix
The rating is: 8.7/10
Generos: Action, Sci-Fi

⚠️ Notas
Asegúrate de tener el chromedriver compatible con tu versión de Chrome.

Usa WebDriverWait para evitar errores de sincronización.

El proyecto actualmente soporta solo la versión de escritorio del sitio IMDb.

🙌 Autor
Creado por Josue Lopez

