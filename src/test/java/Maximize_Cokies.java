import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Maximize_Cokies {

    public static  void main(String[] args)
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        Set<Cookie> c= driver.manage().getCookies();
        for(Cookie  ck:c)
        {
            System.out.println(ck.getName() + "=" + ck.getValue());
        }


        driver.manage().deleteAllCookies();
        driver.manage().deleteCookieNamed("__Secure-BUCKET");

    }
}
