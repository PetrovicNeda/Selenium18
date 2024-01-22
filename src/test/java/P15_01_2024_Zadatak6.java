import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class P15_01_2024_Zadatak6 {
    public static void main(String[] args) {
        // Zadatak 6
// Testirati log out funkcionalnost

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/");
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLogInPage = driver.findElement(By.linkText("Test Login Page"));
        testLogInPage.click();

        String validUsername = "student";
        String validPassword = "Password123";

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys(validUsername);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(validPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        logOutButton.click();
        //-------------------------------------------------

//        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
//        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        Assert.assertNotEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/");

        username = driver.findElement(By.id("username"));
        Assert.assertTrue(username.isDisplayed());

        WebElement logInSection = driver.findElement(By.id("login"));
        Assert.assertTrue(logInSection.isDisplayed());

        WebElement submitButtonLogout = driver.findElement(By.id("submit"));
        Assert.assertTrue(submitButtonLogout.isDisplayed());
    }
}
