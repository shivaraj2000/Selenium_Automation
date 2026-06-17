import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Assesment_Windows {

    public static void main(String[] args)
    {
        WebDriver driver=new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[@href='/windows']")).click();
        driver.findElement(By.cssSelector("a[href='/windows/new']")).click();


        Set<String> windows= driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String ParentId=it.next();
        String ChildId=it.next();
        driver.switchTo().window(ChildId);
        String Childtitle= driver.findElement(By.cssSelector("div.example")).getText().trim();

        System.out.println(Childtitle);
        driver.switchTo().window(ParentId);
        String ParentTitle=driver.findElement(By.xpath("//h3[contains(text(),Opening)]")).getText().trim();
        System.out.println(ParentTitle);

    }
}
