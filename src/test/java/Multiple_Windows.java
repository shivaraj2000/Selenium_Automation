import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class Multiple_Windows {

    public  static  void main(String[] args) throws IOException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //Switching tabs/window
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB); //WINDOW

        Set<String> windows=driver.getWindowHandles();
       Iterator<String> it= windows.iterator();
       String parentId= it.next();
       String childId= it.next();

       driver.switchTo().window(childId);
       driver.get("https://rahulshettyacademy.com/course-library");
       //driver.findElement(By.cssSelector("[href='/course-library']")).click();
       String courseName=driver.findElements(By.xpath("//div[contains(@class,'group')]/div/h3")).get(0).getText();

       driver.switchTo().window(parentId);
        WebElement name=driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(courseName);

       //driver.quit();

        //Taking the specici screenshot
       File src= name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("logo.png"));

        //Taking width and height of webelement
        System.out.println(name.getRect().getDimension().height);
        System.out.println(name.getRect().getDimension().width);
        System.out.println(name.getRect().getHeight());
        System.out.println(name.getRect().getWidth());

    }
}
