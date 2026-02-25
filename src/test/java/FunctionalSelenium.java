import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class FunctionalSelenium {

    public static  void  main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        ////h4[contains(text(), 'Cucumber')]/parent::div//button[text()='ADD TO CART']
        String[] productNames ={"Cucumber","Brocolli","Beetroot"};
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
    }
}
