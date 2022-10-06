package selenium_services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumWebConfig {
    private static SeleniumWebConfig seleniumWebConfig;
    private WebDriver driver;


    private SeleniumWebConfig() {
        System.setProperty("webdriver.chrome.driver", "D:\\pushpakumara\\Wixis\\investing.com\\lib\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();//Chrome browser hide ..................
        options.addArguments("--headless");
        options.addArguments("disable-notifications");
        driver = new ChromeDriver(options);
    }
    public static SeleniumWebConfig getInstance(){
        return seleniumWebConfig = seleniumWebConfig!=null ? seleniumWebConfig : new SeleniumWebConfig();
    }
    public WebDriver driver(){
        return driver;
    }
}
