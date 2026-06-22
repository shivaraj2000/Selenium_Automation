import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SSL_Certs {

    public static void main(String[] args)
    {

        ChromeOptions opt=new ChromeOptions();

        //SSL
        opt.setAcceptInsecureCerts(true);

        //Proxy
        Proxy p=new Proxy();
        p.setHttpProxy("URL/Port");
        opt.setCapability("proxy",p);

        //Block-Popup
        opt.setExperimentalOption("excludeSwitches",
                Arrays.asList("disable-popup-blocking"));

        //Download file to desired location
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "/directory/path");
        opt.setExperimentalOption("prefs", prefs);

        WebDriver driver=new ChromeDriver(opt);
        driver.get("https://expired.badssl.com/");
        driver.manage().window().maximize();
    }
}
