package Test_Scenarios;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import objects.Landing_Page_Wiki;
import objects.Movie_Page_Wiki;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.Landing_Page_IMDB;
import objects.Movie_Page_IMDB;


public class Landing_Test 
{

   WebDriver Driver;

   @BeforeTest
   public void launchURL()
   {
      WebDriverManager.chromedriver().setup();
      Driver=new ChromeDriver();
      Driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
      System.out.println("Choose 1 for IMDB results and 2 for Wiki results");
      Scanner sc= new Scanner(System.in);
      int choice= sc.nextInt();
      if(choice=='1')
      {
         Driver.get("https://www.imdb.com/");
      }
      else if(choice=='2')
      {
         Driver.get("https://en.wikipedia.org/");
      }
      else
      {
         System.out.println("Invalid choice");
      }
      Driver.manage().window().maximize();
   }


   @Test(priority = 0)
   public void searchMovie()
   {
      Driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
      String title= Driver.getTitle();
      if(title=="IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows")
      {
         Landing_Page_IMDB lp= new Landing_Page_IMDB(Driver);
         Driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
         lp.clickSearch();
         lp.movie("Pushpa: The Rise");
         Driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         lp.click();
         Driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
      }
      else if(title=="Wikipedia, the free encyclopedia")
      {
         Landing_Page_Wiki lp= new Landing_Page_Wiki(Driver);
         Driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
         lp.clickSearch();
         lp.movie("Pushpa: The Rise");
         Driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         lp.click();
         Driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
      }


   }
   
   @Test(priority = 1)
   public void movieDetails()
   {
      Driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
      String title= Driver.getTitle();
      if(title.contains("IMDB"))
      {
         Driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);
         Movie_Page_IMDB mp= new Movie_Page_IMDB(Driver);
         WebElement position= Driver.findElement(By.xpath("(//a[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link'])[24]"));
         ((JavascriptExecutor) Driver).executeScript("scroll(0,300)");
         Actions act=new Actions(Driver);
         act.moveToElement(position).build().perform();
         mp.getReleasedate();
         mp.getcountryofOrigin();
      }

      else if(title.contains("Wikipedia"))
      {
         Driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);
         Movie_Page_Wiki mp= new Movie_Page_Wiki(Driver);
         WebElement position= Driver.findElement(By.xpath("(//a[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link'])[24]"));
         ((JavascriptExecutor) Driver).executeScript("scroll(0,300)");
         Actions act=new Actions(Driver);
         act.moveToElement(position).build().perform();
         mp.getReleasedate();
         mp.getcountryofOrigin();
      }

   }
   
   
   @AfterTest
   public void tearDown()
   {
      Driver.close();
      Driver.quit();
   }
   
   

}
