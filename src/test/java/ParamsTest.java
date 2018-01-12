import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.containsString;


@RunWith(Parameterized.class)
public class ParamsTest {

    private WebDriver driver;
    private String url;

    public ParamsTest(String url) {
        this.url = url;
    }

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
    public void getSearchEngine() {
        driver.get(url);
        Assert.assertThat(driver.getCurrentUrl(), containsString(url) );
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
            {"https://yandex.ru"},
            {"https://www.google.ru/"}
        });
    }


}
