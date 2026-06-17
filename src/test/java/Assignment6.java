import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Assignment6 {

    public static void main(String[] args)
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        //Click on check and get the test
        driver.findElement(By.cssSelector("input[name='checkBoxOption2']")).click();
        String checkboxval=driver.findElement(By.cssSelector("label[for='benz']")).getText();
        System.out.println(checkboxval);

        //Select the drop down value from grabbed text
        WebElement selects=driver.findElement(By.id("dropdown-class-example"));
        Select select = new Select(selects);
        select.selectByVisibleText(checkboxval);

        //Enter the text in freetext
        driver.findElement(By.id("name")).sendKeys(checkboxval);
        driver.findElement(By.id("alertbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        String Alerttext=driver.switchTo().alert().getText();
        if(Alerttext.contains(checkboxval))
            System.out.println("The given option is present");
        else
            System.out.println("The given option is not present");

        driver.switchTo().alert().accept();



    }
}
