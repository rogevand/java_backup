package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class sampletest {

    private WebDriver driver;
    String appURL = "https://iqt--iqtsfsit.lightning.force.com/lightning/page/home";

    @BeforeClass
    public void testSetUp() {
        ChromeOptions cho = new ChromeOptions();
        FirefoxOptions fo = new FirefoxOptions();
        cho.setHeadless(false);
        cho.addArguments("~/Library/Application Support/Google/Chrome/Default");
        fo.setHeadless(true);
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        //driver = new FirefoxDriver(fo);
        driver = new ChromeDriver(cho);
    }

    @Test
    public void sfLogin() throws InterruptedException {
        String uname = "rvandeburgh@iqt.org.iqtsfsit";
        String pwd = "Cada.41324132";
        String unamex = "//*[@id=\"username\"]";
        String pwdx = "//*[@id=\"password\"]";
        String loginbtn = "//*[@id=\"Login\"]";

        driver.navigate().to(appURL);
        driver.findElement(By.xpath(unamex)).sendKeys(uname);
        driver.findElement(By.xpath(pwdx)).sendKeys(pwd);
        driver.findElement(By.xpath(loginbtn)).click();

        TimeUnit.SECONDS.sleep(4);

        String sitenamex = "//*[@id=\"oneHeader\"]/div[3]/one-appnav/div/div/div/span/span";
        String sitename = driver.findElement(By.xpath(sitenamex)).getText();
        System.out.println("\n \n \n This is the Sitename: " + sitename + "\n \n \n");

    }

    @Test
    public void verifyTitle() {
        driver.navigate().to(appURL);
        String getTitle = driver.getTitle();
        Assert.assertEquals(getTitle, "Lightning Experience");
    }

    @Test
    public void createAccount() {
        driver.navigate().to(appURL);
        String getTitle = driver.getTitle();
        Assert.assertEquals(getTitle, "Lightning Experience");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}

