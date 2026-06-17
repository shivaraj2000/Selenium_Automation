import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Windows {

    public static void main(String[] args)
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

        driver.findElement(By.xpath("//a[@class='blinkingText' and contains(text(),'Resume')]")).click();
        Set<String> window= driver.getWindowHandles();
        Iterator<String> it= window.iterator();
        String ParentId= it.next();
        String ChildId= it.next();
        driver.switchTo().window(ChildId);

        String Password=driver.findElement(By.cssSelector(".im-para.red")).getText();
        System.out.println(Password);

        String Username=Password.split("@")[1].split(" ")[0].trim();
        System.out.println(Username);
        driver.switchTo().window(ParentId);
        String UserNamePasswordfromParent=driver.findElement(By.cssSelector("p.text-center.text-white")).getText();
        String UserNamefromParent=UserNamePasswordfromParent.split("is")[1].trim().split(" ")[0].trim();
        String PasswordfromParent=UserNamePasswordfromParent.split("Password is")[1].trim().split("\\)")[0].trim();
        driver.findElement(By.cssSelector("input#username")).sendKeys(UserNamefromParent);
        driver.findElement(By.cssSelector("input#password")).sendKeys(PasswordfromParent);
        driver.findElement(By.cssSelector("input#terms")).click();
        driver.findElement(By.cssSelector("input#signInBtn")).click();




    }
}
