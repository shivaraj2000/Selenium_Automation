import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Final_Flow_Speiciject {

    public static  void  main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

       driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
//        //driver.findElement(By.xpath("//a[@value='BLR']")).click();
//        //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
//
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='DEL']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

        System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
        //driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
       // System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
        if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5"))
        {
            System.out.println("Disbaled");
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for(int i=0;i<3;i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
    }
}
