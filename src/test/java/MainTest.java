import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.log.Log;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class MainTest extends loginInformation {

    protected WebDriver driver;
    public static String baseUrl = "https://www.amazon.com.tr/";

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/PC/IdeaProjects/SeleniumTest/src/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(priority=1)
    public void login() throws InterruptedException {

        driver.get(baseUrl);
        driver.findElement(By.id("nav-link-accountList")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("ap_email")).sendKeys(c.getEmail());
        driver.findElement(By.id("continue")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("ap_password")).sendKeys(c.getPassword());
        driver.findElement(By.id("signInSubmit")).click();
    }

    @Test(priority=2)
    public void searchItem() throws InterruptedException {

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("İphone pro max 13");
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"s-result-sort-select_2\"]")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[10]/div/div/div/div/div[1]/span/a/div/img")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//*[@id=\"simpleBundleV2_feature_div\"]/div/div[1]/div/div/span[1]/div/label/input")).click();
        TimeUnit.SECONDS.sleep(2);
    }
    @Test(priority = 3)
    public void orderItem() throws InterruptedException {

        // add your order
        driver.findElement(By.id("add-to-cart-button")).click();
        TimeUnit.SECONDS.sleep(2);

        driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input")).click();
        TimeUnit.SECONDS.sleep(2);

        //delete an order
        driver.findElement(By.className("a-color-link")).click();
        TimeUnit.SECONDS.sleep(2);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("xiaomi headphones");
        TimeUnit.SECONDS.sleep(2);

        driver.findElement(By.id("nav-search-submit-button")).click();
        TimeUnit.SECONDS.sleep(1);

        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/div/div/div/div[1]/span/a/div/img")).click();
        TimeUnit.SECONDS.sleep(2);

        driver.findElement(By.id("add-to-cart-button")).click();
        TimeUnit.SECONDS.sleep(2);

        driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a")).click();
        TimeUnit.SECONDS.sleep(2);

    }
    @Test(priority = 4)
    public void deleteOrders() throws InterruptedException {

        driver.findElement(By.className("a-color-link")).click();
        TimeUnit.SECONDS.sleep(2);

        driver.findElement(By.className("a-color-link")).click();
        TimeUnit.SECONDS.sleep(2);

    }
    @Test(priority = 5)
    public void logout() throws InterruptedException {

        driver.findElement(By.id("nav-hamburger-menu")).click();
        TimeUnit.SECONDS.sleep(2);

        driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[16]/a")).click();
        TimeUnit.SECONDS.sleep(2);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
