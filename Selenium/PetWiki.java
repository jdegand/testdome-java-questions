import org.openqa.selenium.*;
import java.io.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class PetWiki {
    public static String getLoadedData(WebDriver driver) {

      // Don't need to grab the page -> already loaded by testdome
      // driver.get("https://www.testdome.com/resources/media?name=cb8dcf4b-73ba-4ca3-aff4-7ba19d9a6a08/example_case.txt");
        
      WebElement loadBtn = driver.findElement(By.id("load-button"));
      Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(1))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(ElementNotInteractableException.class);

      driver.findElement(By.id("load-button")).click();
      
        try {
          
           wait.until(ExpectedConditions.elementToBeClickable(By.id("load-button")));
           WebElement content = driver.findElement(By.id("content"));
           return content.getText();
          
        } catch (TimeoutException ex) {
           return null;
        }
      
    }
}