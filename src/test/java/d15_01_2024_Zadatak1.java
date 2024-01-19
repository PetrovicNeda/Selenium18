import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class d15_01_2024_Zadatak1 {
    public static void main(String[] args) {
        //Domaci Zadatak 2:
//https://demoqa.com/text-box napisati test case za dati text box

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/text-box");


        WebElement usernameBox = driver.findElement(By.id("userName"));
        usernameBox.sendKeys("Ime Prezime");

        WebElement emailBox = driver.findElement(By.id("userEmail"));
        emailBox.sendKeys("imeprezime@gmail.com");

        WebElement currentAddressBox = driver.findElement(By.id("currentAddress"));
        currentAddressBox.sendKeys("Adresa");

        WebElement permanentAddressBox = driver.findElement(By.id("permanentAddress"));
        permanentAddressBox.sendKeys("Adresa1");

        WebElement submitButton = driver.findElement(By.id("submit"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", submitButton);

        WebElement enteredUserNameBox = driver.findElement(By.id("name"));
        Assert.assertTrue(enteredUserNameBox.isDisplayed());

        String enteredUsername = enteredUserNameBox.getText();
        String expectedUsername = "Name:Ime Prezime";
        Assert.assertEquals(enteredUsername, expectedUsername);

        WebElement enteredEmailBox = driver.findElement(By.id("email"));
        Assert.assertTrue(enteredEmailBox.isDisplayed());

        String enteredEmail = enteredEmailBox.getText();
        String expectedEmail = "Email:imeprezime@gmail.com";
        Assert.assertEquals(enteredEmail, expectedEmail);

        List<WebElement> enteredCurrentAddressBox = driver.findElements(By.id("currentAddress"));
        Assert.assertTrue(enteredCurrentAddressBox.get(1).isDisplayed());

        String enteredCurrentAddress = enteredCurrentAddressBox.get(1).getText();
        String expectedCurrentAddress = "Current Address :Adresa";
        Assert.assertEquals(enteredCurrentAddress, expectedCurrentAddress);

        List<WebElement> enteredPermanentAddressBox = driver.findElements(By.id("permanentAddress"));
        Assert.assertTrue(enteredPermanentAddressBox.get(1).isDisplayed());

        String enteredPermanentAddress = enteredPermanentAddressBox.get(1).getText();
        String expectedPermanentAddress = "Permananet Address :Adresa1";
        Assert.assertEquals(enteredPermanentAddress, expectedPermanentAddress);















    }
}
