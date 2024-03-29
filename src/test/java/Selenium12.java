import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium12 {

    // SVI testovi se izvrsavaju u POSEBNOM browseru
    WebDriver driver;
    WebElement usernameField;
    WebElement passwordField;
    WebElement submitButton;
    String validUsername, validPassword, invalidUsername, loggedInURL, invalidPassword;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        validUsername = "student";
        invalidUsername = "student1";
        validPassword = "Password123";
        invalidPassword = "password";
        loggedInURL = "https://practicetestautomation.com/logged-in-successfully/";
    }

    @BeforeMethod
    public void pageSetUp() {
        // U ovoj klasi cemo inicijalizaciju drivera raditi u BeforeMethod
        // To znaci da ce svaki test da se pokrece u posebnom browseru
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement linkButton = driver.findElement(By.linkText("Test Login Page"));
        linkButton.click();

        usernameField = driver.findElement(By.id("username"));
        passwordField = driver.findElement(By.id("password"));
        submitButton = driver.findElement(By.id("submit"));
    }

    @Test(priority = 10)
    public void userCanLogIn() {
        usernameField.clear();

        usernameField.sendKeys(validUsername);
        passwordField.sendKeys(validPassword);
        submitButton.click();

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), loggedInURL);
        WebElement profileTitle = driver.findElement(By.className("post-title"));
        Assert.assertTrue(profileTitle.isDisplayed());
    }

    @Test(priority = 20)
    public void userCannotLogInWithInvalidUsername(){
        usernameField.clear();

        usernameField.sendKeys(invalidUsername);
        passwordField.clear();
        passwordField.sendKeys(validPassword);
        submitButton.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("show"))));
        WebElement error = driver.findElement(By.id("error"));
        String errorMessage = error.getText();

        Assert.assertEquals(errorMessage, "Your username is invalid!");
        Assert.assertNotEquals(driver.getCurrentUrl(), loggedInURL);

    }
    @Test(priority = 30)
    public void userCannotLogInWithInvalidPassword(){
        usernameField.clear();
        usernameField.sendKeys(validUsername);
        passwordField.clear();
        passwordField.sendKeys(invalidPassword);
        submitButton.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("show"))));
        WebElement error = driver.findElement(By.id("error"));
        String errorMessage = error.getText();

        Assert.assertEquals(errorMessage, "Your password is invalid!");
        Assert.assertNotEquals(driver.getCurrentUrl(), loggedInURL);

    }

    @Test(priority = 40)
    public void userCannotLogInWithEmptyUsernameField(){
        usernameField.clear();
        passwordField.sendKeys(validPassword);
        passwordField.clear();
        submitButton.click();

        WebElement error = driver.findElement(By.id("error"));
        String errorMessage = error.getText();
        Assert.assertEquals(errorMessage, "Your username is invalid!");
        Assert.assertNotEquals(driver.getCurrentUrl(), loggedInURL);
    }
    @Test(priority = 50)
    public void userCannotLogInWithEmptyPasswordField(){
        usernameField.clear();

        usernameField.sendKeys(validUsername);
        passwordField.clear();
        submitButton.click();

        WebElement error = driver.findElement(By.id("error"));
        Assert.assertEquals(error.getText(), "Your password is invalid!");
        Assert.assertNotEquals(driver.getCurrentUrl(), loggedInURL);
    }
    @Test(priority = 60)
    public void userCannotLogInWithEmptyUsernameAndPasswordFields(){
       //prvi nacin
        usernameField.sendKeys("");
        passwordField.sendKeys("");
       //drugi nacin
        //jednostavno ne uneti nista nemati akciju

        //treci nacin - najbolji nacin
        usernameField.clear();
        passwordField.clear();


        submitButton.click();

        WebElement error = driver.findElement(By.id("error"));
        Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.getText(), "Your username is invalid!");
    }
    @Test(priority = 70)
    public void userCannotLogInWithInvalidUsernameAndInvalidPassword(){
        usernameField.clear();
        usernameField.sendKeys(invalidUsername);
        passwordField.clear();
        usernameField.sendKeys(invalidPassword);
        submitButton.click();

        WebElement error = driver.findElement(By.id("error"));
        Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.getText(), "Your username is invalid!");
    }
    @Test(priority = 80)
    public void userCanLogOut(){
        usernameField.clear();
        usernameField.sendKeys(validUsername);
        passwordField.clear();
        passwordField.sendKeys(validPassword);
        submitButton.click();

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));

        Assert.assertTrue(logOutButton.isDisplayed());

        logOutButton.click();

//        Assert.assertFalse(logOutButtonAfterLoggingOut.isDisplayed());

        boolean isButtonPresent = false;

        try {
            WebElement logOutButtonAfterLoggingOut = driver.findElement(By.linkText("Log out"));
            isButtonPresent = logOutButtonAfterLoggingOut.isDisplayed();
        } catch (Exception e){
            System.out.println(e);
        }

        Assert.assertFalse(isButtonPresent);
    }

    @AfterMethod
    public void tearDown() {
        // driver.quit smo stavili u AfterMethod jer zelimo da zatvorimo svaki browser kada se  test zavrsi
        // Ako bismo stavili quit u AfterClass onda bi se samo poslednji browser zatvorio
        driver.quit();
    }


}
