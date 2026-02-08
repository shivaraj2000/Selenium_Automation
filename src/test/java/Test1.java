import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Set;

public class Test1 {

    public static  void main(String[] args)
    {
            //WebDriver driver=new ChromeDriver();
            //WebDriver driver=new FirefoxDriver();
            WebDriver driver=new EdgeDriver();
            driver.get("https://www.google.com/");
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());
            driver.close();

    }
}
