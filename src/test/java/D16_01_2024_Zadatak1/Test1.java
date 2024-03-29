package D16_01_2024_Zadatak1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Test1 {
    public static void main(String[] args) {

        //Invalid username, valid password
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/");

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLogInPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLogInPageButton.click();

        String invalidUsername = "Student1";
        String validPassword = "Password123";

        WebElement usernameBox = driver.findElement(By.id("username"));
        usernameBox.sendKeys(invalidUsername);

        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.sendKeys(validPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());

        Assert.assertEquals(errorMessage.getText(), "Your username is invalid!");

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }
}
