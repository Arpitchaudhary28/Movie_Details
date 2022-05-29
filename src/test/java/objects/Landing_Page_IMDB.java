package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Landing_Page_IMDB {
	WebDriver Driver;

	public Landing_Page_IMDB(WebDriver Driver) {
		this.Driver = Driver;
	}

	By searchBox = By.xpath("//input[@id='suggestion-search']");
	By movie = By.xpath("(//a[@class='sc-bqyKva ehfErK searchResult searchResult--const'])[1]");

	public void clickSearch() {
		Driver.findElement(searchBox).click();
	}

	public void movie(String movieName) {
		Driver.findElement(searchBox).sendKeys(movieName);
	}

	public void click() {
		Driver.findElement(movie).click();
	}

}
