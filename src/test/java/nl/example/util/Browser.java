package nl.example.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

/**
 * This class is responsible for all interactions with a web browser.
 */
public class Browser {

    private static Browser browser;

    private WebDriver driver;
    private WebDriverWait wait;
    private final Environment environment = Environment.getInstance();

    private static final int EXPLICIT_WAIT_TIME = 10;

    private static final String BROWSER_PROPERTY_NAME = "browser";
    private static final String BASE_URL_PROPERTY_NAME = "baseUrl";
    private static final String GET_PAGE_READYSTATE = "return document.readyState";
    private static final String READYSTATE_COMPLETE = "complete";

    private Browser() {
    }

    /**
     * Creates a new browser instance if one does not already exist.
     * If one already exists, it returns that instance.
     *
     * @return browser
     */
    public static Browser getInstance() {
        if (browser == null) {
            browser = new Browser();
        }
        return browser;
    }

    /**
     * Instantiates the web driver. It retrieves the wanted browser type from the system properties at runtime.
     * Makes use of {@link io.github.bonigarcia} to download the latest driver binaries.
     */
    public void startBrowser() {
        BrowserType browserType = BrowserType.valueOf(System.getProperty(BROWSER_PROPERTY_NAME).toUpperCase());

        if (browserType.equals(BrowserType.CHROME)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserType.equals(BrowserType.FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserType.equals(BrowserType.SAFARI)) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        } else {
            throw new UnsupportedOperationException("BrowserType: " + browserType.name() + " not supported.");
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIME));
        driver.manage().window().maximize();
    }

    /**
     * Appends the URI value to the base URL specified in the environment.properties file.
     * Then goes on to load a new web page in the current browser window.
     *
     * @param uri   The URI to append to the base URL.
     */
    public void get(String uri) {
        driver.get(environment.getProperty(BASE_URL_PROPERTY_NAME) + uri);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    /**
     * Finds all web elements that match the CSS selector.
     * Waits for the page to be fully loaded before searching the web elements.
     *
     * @param selector  CSS selector
     * @return          List of all matching elements
     */
    public List<WebElement> findElements(String selector) {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript(GET_PAGE_READYSTATE).equals(READYSTATE_COMPLETE));
        return driver.findElements(By.cssSelector(selector));
    }

    /**
     * Returns the first web element that matches the CSS selector.
     * Waits for the page to be fully loaded before searching the web element.
     *
     * @param selector  CSS selector
     * @return          WebElement
     */
    public WebElement findElement(String selector) {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript(GET_PAGE_READYSTATE).equals(READYSTATE_COMPLETE));
        return driver.findElement(By.cssSelector(selector));
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public WebDriver.TargetLocator switchTo() {
        return driver.switchTo();
    }

    public WebDriver.Navigation navigate() {
        return driver.navigate();
    }

    public WebDriver.Options manage() {
        return driver.manage();
    }

    public byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
