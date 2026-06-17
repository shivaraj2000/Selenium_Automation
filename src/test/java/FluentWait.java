import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWait {

    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//*[@id='start']/button")).click();

        Wait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

//        WebElement find = wait.until(new Function<WebDriver, WebElement>() {
//            @Override
//            public WebElement apply(WebDriver driver) {
//                if(driver.findElement(By.xpath("//*[@id='finish']/h4")).isDisplayed()) {
//                    return driver.findElement(By.xpath("//*[@id='finish']/h4"));
//                }
//                else{
//                    return  null;
//                }
//            }
//        });

        WebElement e =wait.until(driver2 -> {WebElement ex = driver.findElement(By.xpath("//*[@id='finish']/h4"));
            return ex.isDisplayed() ? ex :null;
        });

//        WebElement find = wait.until(driver1 -> {
//            WebElement el = driver.findElement(By.xpath("//*[@id='finish']/h4"));
//            return el.isDisplayed() ? el : null;
//        });
//        System.out.println(driver.findElement(By.xpath("//*[@id='finish']/h4")).isDisplayed());

}}
