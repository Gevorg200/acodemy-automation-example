package lv.acodemy.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {

    @Getter @Setter
    public static String testName;

    private static final ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {
        if(ConfigurationProperties.getConfiguration().getBoolean("local.run")) {
            return new ChromeDriver();
        } else {
            return runRemotely();
        }
    });

//    private static final ThreadLocal<ChromeDriver> driver = ThreadLocal.withInitial(() -> {
//        ChromeDriver chromeDriver = new ChromeDriver();
//        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        return chromeDriver;
//});


    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver() {
        if(getDriver() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    @SneakyThrows
    public static RemoteWebDriver runRemotely() {
        FirefoxOptions browserOptions = new FirefoxOptions();
        browserOptions.setPlatformName("macOS 13");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-nmilka-b1b67");
        sauceOptions.put("accessKey", "9a4699ee-6d21-43d6-925d-4d2e5a1726b3");
        sauceOptions.put("build", "<your build id>");
        sauceOptions.put("name", getTestName());
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        return new RemoteWebDriver(url, browserOptions);
    }
}
