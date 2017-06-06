import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class GoogleSample {

    public static final String USERNAME = ""; //add your login
    public static final String AUTOMATE_KEY = ""; //add your password
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void testing() throws Exception {

        /*
        *********
        List of devices / machines
        https://www.browserstack.com/list-of-browsers-and-platforms?product=automate

        First you nee to have the tunnel between your machine and browserstack, so run in terminal:
            ./BrowserStackLocal --key xxx --force-local
        where xxx is your key of access.
        **********
        */

        DesiredCapabilities caps = new DesiredCapabilities();

        /*Access your local server in remote browser*/
        caps.setCapability("browserstack.local", "true");

        /*Set environment for Windows 10 - Internet Explorer 11*/
        //caps.setCapability("browser", "IE");
        //caps.setCapability("browser_version", "11");
        //caps.setCapability("os", "Windows");
        //caps.setCapability("os_version", "10");

        /*Set debug*/
        //caps.setCapability("browserstack.debug", "true");


        /*Set environment for Samsung Galaxy S5 - Chrome*/
        caps.setCapability("browserName", "chrome");
        caps.setPlatform(Platform.ANDROID); //or Platform.MAC
        caps.setCapability("device", "Samsung Galaxy S5");
        caps.setCapability("browserstack.debug", "true");

        /*Name of the build and name of project*/
        caps.setCapability("build", "TestOut");
        caps.setCapability("project", "automation");

        /*True to save the video of the test in browserstack*/
        caps.setCapability("browserstack.video", "false");

        /*Testing...*/
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("https://google.com");
        String value = driver.getTitle();
        System.out.println(driver.getTitle());
        driver.quit();
        assert value.contains("Google");
    }
}
