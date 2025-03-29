package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class MoviePage {
    WebDriver driver;

    By title = By.xpath("(//div[@class='sc-70a366cc-0 bxYZmb'])/div");
    By rating = By.xpath("//div[contains(@data-testid,'hero-rating-bar__aggregate-rating__score')]");
    By Genre = By.xpath("//div[@class='ipc-chip-list__scroller']//a");

    public MoviePage(WebDriver driver) {
        this.driver = driver;
    }

    public String movieTitle() {
        WebElement movieNameLocation = driver.findElement(title);
        return movieNameLocation.getText().split(":")[1];
    }

    public String movieRating() {
        List<WebElement> ratingElements = driver.findElements(rating);
        return (ratingElements.size() >= 2) ? ratingElements.get(1).getText().trim() : "Rating not found";
    }

    public String getGenres() {
        List<WebElement> Genres = driver.findElements(Genre);
        String genreName = Genres.stream()
                .map(g -> g.getText().trim())
                .filter(text -> !text.isEmpty())
                .collect(Collectors.joining(", "));
        return genreName;
        }
    }


