import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Scrolling_Assignment_7_8 {

    public static void main(String[] args)
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.manage().window().maximize();

        System.out.println("Row Nuymbers are " + driver.findElements(
                By.xpath("//*[@id='product' and @name='courses']/tbody/tr")).size());

        System.out.println("Col Nuymbers are " +driver.findElements(
                By.xpath("//*[@id='product' and @name='courses']/tbody/tr/th")).size());

        List<WebElement> list= driver.findElements(By.xpath("//*[@id='product' and @name='courses']/tbody/tr[3]/td"));

        for(WebElement n : list)
        {
            System.out.println(n.getText());
        }

        //Assigmnet 8
        String ValidateCountry = "india";
        String EnterThreeChar = "ind";

        WebElement input = driver.findElement(By.id("autocomplete"));
        input.sendKeys(EnterThreeChar);

        boolean isClicked = false;

        while (!isClicked) {
            // Navigate through suggestions
            input.sendKeys(Keys.ARROW_DOWN);

            // Get current value of the input box
            String currentValue = input.getAttribute("value");

            if (currentValue.equalsIgnoreCase(ValidateCountry)) {
                // Press ENTER to select the suggestion
                input.sendKeys(Keys.ENTER);
                System.out.println("Clicked on " + ValidateCountry);
                isClicked = true;
            }
        }

    }
}
