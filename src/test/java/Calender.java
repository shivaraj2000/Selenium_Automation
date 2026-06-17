import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Calender {
    public static void main(String[] args)
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();

        String month="6";
        String date="15";
        String year="2027";
        String expected[]={month,date,year};

        driver.findElement(By.cssSelector("svg.react-date-picker__calendar-button__icon")).click();
        driver.findElement(By.cssSelector("span.react-calendar__navigation__label__labelText")).click();
        driver.findElement(By.cssSelector("span.react-calendar__navigation__label__labelText")).click();
        driver.findElement(By.xpath("//button[contains(text(),'"+year +"')]")).click();
        driver.findElements(By.cssSelector("button.react-calendar__year-view__months__month"))
                .get(Integer.parseInt(month)-1).click();
        driver.findElement(By.xpath("//abbr[contains(text(),'"+date+"')]")).click();

        List<WebElement> actual= driver.findElements(By.cssSelector("input.react-date-picker__inputGroup__input"));

        for(int i=0;i<actual.size();i++)
        {
            System.out.println(actual.get(i).getAttribute("value"));
            Assert.assertEquals(actual.get(i).getAttribute("value"),expected[i+1]);
        }
        //Assert.assertEquals(EnteredDate,);
    }
}
