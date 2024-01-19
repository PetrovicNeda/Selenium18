import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class p15_01_2024_Zadatak7 {
    public static void main(String[] args) {
        // Zadatak 7
// Testirati neuspesan log in

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/");

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLogInPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLogInPageButton.click();

        WebElement usernameBox = driver.findElement(By.id("username"));
        usernameBox.sendKeys("student");
//Invalid password
        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.sendKeys("Password12345");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement errorNote = driver.findElement(By.id("error"));
        Assert.assertTrue(errorNote.isDisplayed());
        //issue poruka bi trebalo da se odnosi i na username i na password da bude univerzalna, tj pisao bi se bug report
//        Assert.assertEquals(errorNote.getText(), "Your username is invalid!");

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
        Assert.assertTrue(submitButton.isDisplayed());


    }
}
