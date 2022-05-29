package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Movie_Page_Wiki {
    WebDriver Driver;

    public Movie_Page_Wiki(WebDriver Driver)

    {
        this.Driver= Driver;

    }

    By releaseDate= By.xpath("(//div[@class='plainlist'])[4]");
    By countryofOrigin= By.xpath("(//td[@class='infobox-data'])[12]");


    public void getReleasedate()
    {
        String date= Driver.findElement(releaseDate).getText();
        System.out.println("Release date is:"+date);

    }
    public void getcountryofOrigin()
    {
        String count= Driver.findElement(countryofOrigin).getText();
        System.out.println("Country of origin is:"+count);
    }


}
