import org.example.IMBDSearchPage;
import org.example.MoviePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class test {
    WebDriver driver;
    String wantedMovie = "The Matrix";

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.imdb.com/es/");
    }

    @Test
    public void searchForMovie() {
        IMBDSearchPage IMBDLandingPage = new IMBDSearchPage(driver);
        IMBDLandingPage.searchMovie(wantedMovie);
    }

    @Test(dependsOnMethods = "searchForMovie")
    public void searchForTitle() {
        MoviePage movie = new MoviePage(driver);
        String movieResult = movie.movieTitle().trim();
        Assert.assertEquals(movieResult, wantedMovie);
    }
    @Test(dependsOnMethods = "searchForMovie")
    public void searchForRating() {
        MoviePage rating = new MoviePage(driver);
        rating.movieRating();
    }

    @Test(dependsOnMethods = "searchForMovie")
    public void searchForGenre() {
        MoviePage genre = new MoviePage(driver);
        genre.getGenres();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
