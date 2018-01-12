import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.CoreMatchers.containsString;

public class WithoutParamsTest {

    private WebDriver driver;
    private String url;

    @BeforeClass
    public static void createWebDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void startDriver() {
        driver = new ChromeDriver();
    }

    @After
    public void closeDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void getGoogle() {
        url = "https://www.google.ru/";
        driver.get(url);
        Assert.assertThat(driver.getCurrentUrl(), containsString(url) );
    }

    @Test
    public void getYandex() {
        url = "https://yandex.ru";
        driver.get(url);
        Assert.assertThat(driver.getCurrentUrl(), containsString(url) );
    }

    @Test
    public void sleepForAWhile() throws InterruptedException {
        driver.get("http://mail.ru");
        Thread.sleep(5000);
    }

}
