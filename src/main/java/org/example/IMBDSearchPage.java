package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

public class IMBDSearchPage {
    WebDriver driver;

    public IMBDSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    //(//ul[@role='presentation'])[1]
    //a[@class='sc-ksltVi jUkjoZ searchResult searchResult--const'])[2]
    By searchBox = By.id("suggestion-search");
    By firstTitle = By.xpath("//ul[@role='presentation'][1]//li");

    public void searchMovie(String movie) {
        WebElement movieName = driver.findElement(searchBox);
        movieName.sendKeys(movie);
        movieName.submit();

        List<WebElement> allMovies = driver.findElements(firstTitle);
        Optional<WebElement> matchingResult = allMovies.stream().filter(webElement -> webElement.getText().toLowerCase().contains("matrix")).findFirst();

        matchingResult.ifPresent(WebElement::click);

    }
}
