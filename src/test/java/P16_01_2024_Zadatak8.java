import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class P16_01_2024_Zadatak8 {
    public static void main(String[] args) throws InterruptedException {
        //Zadatak 8
        //Testirati log in na wordpress stranicu

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://wordpress.com/");
        WebElement logInButton = driver.findElement(By.linkText("Log In"));
        logInButton.click();

        String correctEmail = "nedapetrovic@live.com";
        String correctPassword = "WordPressItBoot";
        WebElement emailBox = driver.findElement(By.id("usernameOrEmail"));
        emailBox.sendKeys(correctEmail);
// button - type - submit kako napisati selektor
        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();
        //explicit wait nacini pravljenja
//        WebDriver wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.id("password")));

        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.sendKeys(correctPassword);

        WebElement secondLogInButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        secondLogInButton.click();
        // prvo koristiti thread sleep kako bi utvrdili da li je problem do ucitavanja ili do lokatora
        //kasnije menjamo ovaj thread sleep na neki wait

//        Thread.sleep(3000);
        //posto se menja URL radi se ovako
        wait.until(ExpectedConditions.urlToBe("https://wordpress.com/sites"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://wordpress.com/sites");

        /*
        import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Zadatak8 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://www.wordpress.com/");

        WebElement logInButton = driver.findElement(By.linkText("Log In"));
        logInButton.click();

        WebElement usernameField = driver.findElement(By.id("usernameOrEmail"));
        String username = "dragoljubqa";
        usernameField.sendKeys(username);

        // button - type - submit
        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Swordfish123!@#");

        continueButton.click();

        //Thread.sleep(3000);
        wait.until(ExpectedConditions.urlToBe("https://wordpress.com/home/dragoljubqa.wordpress.com"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://wordpress.com/home/dragoljubqa.wordpress.com");

        WebElement profileButton = driver.findElement(By.cssSelector(".gravatar.masterbar__item-me-gravatar"));
        profileButton.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("profile-gravatar__user-display-name"))));

        WebElement usernameTitle = driver.findElement(By.className("profile-gravatar__user-display-name"));
        String usernameText = usernameTitle.getText();

        Assert.assertEquals(usernameText, username);
    }
}
 */

    }
}
