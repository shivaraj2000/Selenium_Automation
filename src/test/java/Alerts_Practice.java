import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts_Practice {

    public static  void  main(String[] args) throws InterruptedException {
        String name="Shiva";
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("alertbtn")).click();
        String s =driver.switchTo().alert().getText();
        if(s.contains(name)) {
            System.out.println("Valid Alert Printed");
        } else {
            System.out.println("Valid Alert not Printed");
        }
        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        //driver.switchTo().alert().accept();


    }
}
