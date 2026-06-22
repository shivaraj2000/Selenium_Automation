import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Broken_Links {

    public static void main (String[] args) throws URISyntaxException, IOException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> link= driver.findElements(By.xpath("//table[@class='gf-t']//a"));
        SoftAssert a= new SoftAssert();
        for(WebElement w:link)
        {
            String url= w.getAttribute("href");
            HttpURLConnection conn= (HttpURLConnection) new URI(url).toURL().openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int resp=conn.getResponseCode();
            a.assertTrue(resp<400,"The link "+url + " and the text in the UI " +w.getText() + " is broken with the status code "+ resp);
            System.out.println(resp);
//            if(resp>=400)
//            {
//                System.out.println("The link "+url + " and the text in the UI " +w.getText() + " is broken with the status code "+ resp);
//                Assert.assertTrue(false);
//            }
        }
        a.assertAll();
    }
}
