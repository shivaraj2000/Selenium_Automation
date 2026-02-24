import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

    public static  void  main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.findElement(By.name("name")).sendKeys("Shivaraj");
        driver.findElement(By.name("email")).sendKeys("Shiva@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("123456");
        driver.findElement(By.id("exampleCheck1")).click();

        WebElement dropdownlist = driver.findElement(By.id("exampleFormControlSelect1"));
        Select dropdown = new Select(dropdownlist);
        dropdown.selectByVisibleText("Female");
        driver.findElement(By.id("inlineRadio2")).click();
        driver.findElement(By.name("bday")).sendKeys("01-01-2000");

        driver.findElement(By.xpath("//input[@class='btn btn-success' and @type='submit']")).click();
        String s= driver.findElement(By.xpath("//div[contains(@class,'success')]")).getText();
        System.out.println(s);


    }
}
