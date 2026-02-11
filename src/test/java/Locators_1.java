import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Locators_1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("inputUsername")).sendKeys("Shiva");
        driver.findElement(By.name("inputPassword")).sendKeys("shiva");
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("sac");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("s.gmail.com");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        //driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("s.gmail.com");
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("yiwe@g.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("7625356");
        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.xpath("//button[contains(text(),'Go to Login')]")).click();
        driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("Shiva");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        Thread.sleep(2000);
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();



    }
}
