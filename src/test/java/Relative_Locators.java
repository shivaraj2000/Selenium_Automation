import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Relative_Locators {

    public  static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        //Above
        WebElement name= driver.findElement(By.cssSelector("[name='name']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(name)).getText());

        //below
        WebElement dob=driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dob)).click();

        //Left
        WebElement radiobtn=driver.findElement(By.cssSelector("[for='exampleCheck1']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(radiobtn)).click();

        //Right
        WebElement text=driver.findElement(By.id("inlineRadio1"));
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(text)).getText());

    }
}
