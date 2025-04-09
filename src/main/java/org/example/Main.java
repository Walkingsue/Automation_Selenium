package org.example;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        String movieName = "rapidos y furiosos";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        // Ir a la pagina IMBD
        driver.get("https://www.imdb.com/es/");
        //Buscar pelicula
        IMBDSearchPage moviePage = new IMBDSearchPage(driver);
        moviePage.searchMovie(movieName);

        //Buscar el titulo
        MoviePage movie = new MoviePage(driver);
        String movieTitle = movie.movieTitle();
        saveFile("Titulo original: " + movieTitle, "src/output/resultado_test1.txt");

        //Conseguir el rating
        String rating = movie.movieRating();

        //Guardar los resultados
        StringBuilder addToFile = new StringBuilder();
        //Corresponde a resultados_test2.txt
        String generos = movie.getGenres();
        addToFile.append("Titulo original: ").append(movieTitle).append("\n");
        addToFile.append("Rating IMBD: ").append(rating).append("\n");
        addToFile.append("Generos: ").append(generos).append("\n");
        saveFile(addToFile.toString(), "src/output/resultado_test2.txt");

        //Cerrar chrome
        driver.quit();

    }
    private static void saveFile(String text, String fileName) {
        try (FileWriter writer = new FileWriter(fileName, true)) { // Escribir en el archivo
            writer.write(text);
        } catch (IOException e) {
            System.out.println("Error caught:" + e.getMessage());
        }
    }
}
