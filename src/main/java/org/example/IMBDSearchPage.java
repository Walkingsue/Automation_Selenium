package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IMBDSearchPage {
    WebDriver driver;

    public IMBDSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    By searchBox = By.id("suggestion-search");
    By firstTitle = By.xpath("(//a[@class='sc-ksltVi jUkjoZ searchResult searchResult--const'])[2]");

    public void searchMovie(String movie) {
        WebElement movieName = driver.findElement(searchBox);
        movieName.sendKeys(movie);
        WebElement firstMatch = driver.findElement(firstTitle);
        firstMatch.click();

    }
}
