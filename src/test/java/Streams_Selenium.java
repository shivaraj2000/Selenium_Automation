import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class Streams_Selenium {

    public  void sortColumnInWebpage(WebDriver driver)
    {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //Click on sorting buitton
        driver.findElement(By.xpath("//tr/th/span[contains(text(),'Veg/fruit name')]")).click();

        //get that resulst in list of webelement
        List<WebElement> webElementList= driver.findElements(By.xpath("//tbody/tr/td[1]"));

        //Convert the above list into gettext
        List<String>OriginalList= webElementList.stream().map(s->s.getText()).collect(Collectors.toList());

        //Verify Results using sorting
        List<String> Newlist=OriginalList.stream().sorted().collect(Collectors.toList());

        //Compare tye results
        Assert.assertTrue(OriginalList.equals(Newlist));
    }

    public  void getThePriceofBeans(WebDriver driver)
    {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //Click on sorting buitton
        driver.findElement(By.xpath("//tr/th/span[contains(text(),'Veg/fruit name')]")).click();

        //get that resulst in list of webelement
        List<WebElement> webElementList= driver.findElements(By.xpath("//tbody/tr/td[1]"));

        List<String> price = webElementList.stream().filter(s->s.getText().contains("Beans")).
                map(s->getPriceofVeggies(s)).collect(Collectors.toList());

        price.forEach(s->System.out.println(s));
    }

    public String getPriceofVeggies(WebElement s)
    {
        String pricr=s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return pricr;
    }

    public  void getThePriceofBeansusingPagination(WebDriver driver)
    {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //Click on sorting buitton
        driver.findElement(By.xpath("//tr/th/span[contains(text(),'Veg/fruit name')]")).click();

        List<String> Price;
        do {
            //get that resulst in list of webelement
            List<WebElement> webElementList = driver.findElements(By.xpath("//tbody/tr/td[1]"));

             Price = webElementList.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceofVeggies(s)).
                    collect(Collectors.toList());

             Price.forEach(s->System.out.println(s));
            if (Price.size() < 1) {
                driver.findElement(By.xpath("//*[@aria-label='Next']")).click();
            }
        }while(Price.size()<1);
    }

    public void filterVeggie(WebDriver driver)
    {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        String searchVeggie="Rice";

         driver.findElement(By.id("search-field")).sendKeys(searchVeggie);

         List<WebElement> searchedResults= driver.findElements(By.xpath("//tr/td[1]"));

         List<WebElement> VerifiedResults=searchedResults.stream().filter(s->s.getText().contains(searchVeggie))
                 .collect(Collectors.toList());

         Assert.assertTrue(searchedResults.equals(VerifiedResults));


    }

    public static void main(String[] args)

    {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        Streams_Selenium ss= new Streams_Selenium();
        //ss.sortColumnInWebpage(driver);
        //ss.getThePriceofBeans(driver);
        //ss.getThePriceofBeansusingPagination(driver);
        ss.filterVeggie(driver);

    }

}
