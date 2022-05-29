package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Movie_Page_IMDB
{
   WebDriver Driver;

   public Movie_Page_IMDB(WebDriver Driver)

   {
      this.Driver= Driver;

   }

   By releaseDate= By.xpath("(//a[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link'])[24]");
   By countryofOrigin= By.xpath("(//a[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link'])[25]");
   

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