import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Scrolling {

    public static void main(String[] args)
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)");

        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        List<WebElement> list=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum=0;
        for(WebElement n:list)
        {
            sum=sum+ Integer.parseInt(n.getText());
        }
            System.out.println(sum);
       int amountFromUI= Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
        System.out.println(amountFromUI);

        Assert.assertEquals(sum,amountFromUI);

        List<WebElement> list2= driver.findElements(By.xpath("//*[@id='product' and @name='courses']/tbody/tr/td[3]"));
        int sum1=0;

        for(WebElement n:list2)
        {
            sum1=sum1+Integer.parseInt(n.getText());
        }
        System.out.println(sum1);
    }

}
