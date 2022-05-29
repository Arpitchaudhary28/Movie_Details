package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Landing_Page_Wiki {
    WebDriver Driver;
    public Landing_Page_Wiki(WebDriver Driver)
    {
        this.Driver = Driver;
    }

    By searchBox= By.xpath("//input[@class='vector-search-box-input']");
    By movie= By.xpath("(//a[@class='mw-searchSuggest-link'])[1]");

    public void clickSearch()
    {
        Driver.findElement(searchBox).click();
    }
    public void movie(String movieName)
    {
        Driver.findElement(searchBox).sendKeys(movieName);
    }
    public void click ()
    {
        Driver.findElement(movie).click();
    }
}