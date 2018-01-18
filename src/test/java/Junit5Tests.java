import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.containsString;

class Junit5Tests {
    private static WebDriver driver;
    private String url;

    @BeforeAll
    static void createWebDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void startDriver() {
        driver = new ChromeDriver();
    }


    @DisplayName("😱")
    @ParameterizedTest
    @MethodSource("stringProvider")
    void getSearchEngine(String url) {
        driver.get(url);
        Assert.assertThat(driver.getCurrentUrl(), containsString(url));
    }

    static Stream<String> stringProvider() {
        return Stream.of("https://yandex.ru", "https://www.google.ru/");
    }

    @Disabled("for demonstration purposes")
    @Test
    void skippedTest() {
        System.out.println("Was the test ignored?");
    }


    @AfterEach
    void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}