import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Action {

    public static void main (String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        //Thread.sleep(5000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement hover= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));
       //WebElement hover=driver.findElement(By.xpath("//a[contains(@class,'nav-progressive-attribute') and @data-nav-role='signin']"));

        Actions a = new Actions(driver);

        //To hover on element
        a.moveToElement(hover).build().perform();

        a.moveToElement(driver.findElement(By.cssSelector("input#twotabsearchtextbox"))).
                click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        a.moveToElement(hover).contextClick().build().perform();


    }
}
