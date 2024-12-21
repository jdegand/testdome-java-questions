import org.openqa.selenium.*; // TimeoutException comes from here
import java.io.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class PetWiki {

   // Private constructor to prevent instantiation
   private PetWiki() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   public static String getLoadedData(WebDriver driver) {

      // Don't need to grab the page with driver get -> already loaded by testdome

      WebElement loadBtn = driver.findElement(By.id("load-button"));
      Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(1))
            .pollingEvery(Duration.ofMillis(250))
            .ignoring(ElementNotInteractableException.class);

      loadBtn.click();

      try {
         wait.until(ExpectedConditions.elementToBeClickable(loadBtn));
         return driver.findElement(By.id("content")).getText();
      } catch (TimeoutException ex) {
         return null;
      }

   }
}