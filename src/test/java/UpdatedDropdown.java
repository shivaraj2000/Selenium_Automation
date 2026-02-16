import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropdown {

    public static  void  main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).getText());

        driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).click();
        for(int i=0;i<5;i++)
        {
            driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
        }
        driver.findElement(By.xpath("//div[@data-testid='home-page-travellers-done-cta']")).click();

        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).getText());

        driver.close();
    }
}
