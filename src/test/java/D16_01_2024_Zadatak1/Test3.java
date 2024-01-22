package D16_01_2024_Zadatak1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Test3 {
    public static void main(String[] args) {

        //Valid username, empty password
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/");

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLogInPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLogInPageButton.click();

        String validUsername = "student";

        WebElement usernameBox = driver.findElement(By.id("username"));
        usernameBox.sendKeys(validUsername);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());

        Assert.assertEquals(errorMessage.getText(), "Your password is invalid!");

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }
}
