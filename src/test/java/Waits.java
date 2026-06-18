import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Waits {

    public void AddItems(WebDriver driver, String[] productNames)
    {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ////h4[contains(text(), 'Cucumber')]/parent::div//button[text()='ADD TO CART']
        List<WebElement> products =driver.findElements(By.xpath("//h4[@class='product-name']"));
        int ItemsChecked=0;
        for(int i=0;i<=products.size();i++)
        {
            //Format the product/vegetable name
            String product=products.get(i).getText().split("-")[0].trim();
            //String productt= product.split("-")[0].trim();
            //String P1=product.replace("- 1 Kg","").trim();

            //Check product is there in our ProductNames or not
            //To check that we need use contains so convert the array to arrayList

            List<String> Itemsneed = Arrays.asList(productNames);
            if(Itemsneed.contains(product))
            {
                driver.findElements(By.xpath("//button[@type='button']")).get(i+1).click();
                ItemsChecked++;
                if(ItemsChecked==productNames.length)
                {
                    break;
                }
            }
        }
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        //Explicit wait
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }

    public static  void  main(String[] args) throws InterruptedException {

        Waits fs=new Waits();
        String[] productNames ={"Cucumber","Brocolli","Beetroot"};

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        fs.AddItems(driver,productNames);

    }
}
