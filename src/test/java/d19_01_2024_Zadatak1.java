import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class d19_01_2024_Zadatak1 {
    /*
    Otici na sajt Herkouapp(https://the-internet.herokuapp.com/)
    i napisati sto vise test case-eva (Vas izbor sta cete testirati).
     */

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void userGoToHomePageAfterClickingHomeButtonInDisappearingElements() {
        WebElement basicAuthButton = driver.findElement(By.linkText("Disappearing Elements"));
        basicAuthButton.click();
        WebElement homeButton = driver.findElement(By.linkText("Home"));
        homeButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/");

    }

    @Test
    public void userCanUseRemoveButton() {
        WebElement dynamicControlsButton = driver.findElement(By.linkText("Dynamic Controls"));
        dynamicControlsButton.click();
        WebElement removeButton = driver.findElement(By.cssSelector("button[type='button']"));
        removeButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
        WebElement message = driver.findElement(By.id("message"));
        Assert.assertTrue(message.isDisplayed());
    }

    @Test
    public void userCanUseAddButton() {
        WebElement dynamicControlsButton = driver.findElement(By.linkText("Dynamic Controls"));
        dynamicControlsButton.click();
        WebElement removeButton = driver.findElement(By.cssSelector("button[type='button']"));
        removeButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
        WebElement message = driver.findElement(By.id("message"));

        Assert.assertTrue(message.isDisplayed());

        WebElement addButton = driver.findElement(By.cssSelector("button[type='button']"));
        addButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
        WebElement message2 = driver.findElement(By.id("message"));
        String text = message2.getText();
        Assert.assertEquals(text, "It's back!");

    }

    @Test
    public void userCanUseEnableButton() {
        WebElement dynamicControlsButton = driver.findElement(By.linkText("Dynamic Controls"));
        dynamicControlsButton.click();
        List<WebElement> enableButton = driver.findElements(By.cssSelector("button[type='button']"));
        enableButton.get(1).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
        WebElement message = driver.findElement(By.id("message"));
        Assert.assertEquals(message.getText(), "It's enabled!");
    }

    @Test
    public void userCanUseDisableButton() {
        WebElement dynamicControlsButton = driver.findElement(By.linkText("Dynamic Controls"));
        dynamicControlsButton.click();
        List<WebElement> enableButton = driver.findElements(By.cssSelector("button[type='button']"));
        enableButton.get(1).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
        WebElement message = driver.findElement(By.id("message"));
        Assert.assertEquals(message.getText(), "It's enabled!");

        enableButton.get(1).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
        WebElement message2 = driver.findElement(By.id("message"));
        Assert.assertEquals(message2.getText(), "It's disabled!");
    }

    @Test
    public void whenUserHoverOverAppropriateUserNameIsDisplayed() {
        WebElement hovers = driver.findElement(By.linkText("Hovers"));
        hovers.click();

        List<WebElement> figures = driver.findElements(By.className("figure"));
        Actions action = new Actions(driver);

        List<WebElement> usernames = driver.findElements(By.cssSelector(".figcaption"));

        for (int i = 0; i < figures.size(); i++) {
            action.moveToElement(figures.get(i)).perform();
            Assert.assertTrue(usernames.get(i).isDisplayed());
            Assert.assertTrue(usernames.get(i).getText().contains("name: user" + (i + 1)));
            System.out.println(usernames.get(i).getText());
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
