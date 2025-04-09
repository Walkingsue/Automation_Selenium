package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class MoviePage {
    WebDriver driver;

    //(//div[@class='sc-70a366cc-0 bxYZmb'])/div
    //(//ul[@role='presentation'])[1]
    By titleContainer = By.xpath("//div[@class='sc-70a366cc-0 bxYZmb']");
    By rating = By.xpath("//div[contains(@data-testid,'hero-rating-bar__aggregate-rating__score')]");
    By Genre = By.xpath("//div[@class='ipc-chip-list__scroller']//a");

    public MoviePage(WebDriver driver) {
        this.driver = driver;
    }

    public String movieTitle() {
        WebElement mainTitle = driver.findElement(titleContainer);
        String titleText;
        List<WebElement> ogTitle = mainTitle.findElements(By.xpath(".//div"));
        if(ogTitle.isEmpty()) {
            titleText = mainTitle.findElement(By.tagName("h1")).getText().trim();
        } else {
            titleText = ogTitle.get(0).getText().split(":")[1];
        }
        return titleText;
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


