import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

    public static  void main(String[] args)
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();

        System.out.println(driver.findElements(By.tagName("iframe")).size());

        //Using index
        driver.switchTo().frame(0);

        //Using Webelement
        //driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));

        WebElement source= driver.findElement(By.cssSelector("div#draggable"));
        WebElement target= driver.findElement(By.cssSelector("div#droppable"));

        Actions a=new Actions(driver);
        a.dragAndDrop(source,target).build().perform();

        driver.switchTo().defaultContent();

    }
}
