import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.sql.Time;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Link_Count_Page {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        //1 To get all count in whole page
        System.out.println(driver.findElements(By.tagName("a")).size());

        //2 To get all count in footer section and by scoping only footer section
        WebElement footer= driver.findElement(By.id("gf-BIG"));
        System.out.println(footer.findElements(By.tagName("a")).size());

        //3 to get the only first column links from footer
        WebElement firstcolfooter=footer.findElement(By.xpath("//*[@class='gf-t']/tbody/tr/td[1]/ul"));
        System.out.println(firstcolfooter.findElements(By.tagName("a")).size());

        //4 Click on each link in the column and print child widow title
        for(int i=1;i<firstcolfooter.findElements(By.tagName("a")).size();i++)
        {
            //String ClickonElemnt= Keys.chord(Keys.CONTROL,Keys.ENTER);
            firstcolfooter.findElements(By.tagName("a")).get(i).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));

            Thread.sleep(5000);
        }

        //5 To get child window title
        Set<String> childwimdows=driver.getWindowHandles();
        Iterator<String> it = childwimdows.iterator();

        while(it.hasNext())
        {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }

    }
}
