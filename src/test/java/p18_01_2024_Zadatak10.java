import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class p18_01_2024_Zadatak10 {
    public static void main(String[] args) throws InterruptedException {
        //Zadatak 10
//Otici na stranicu https://imgflip.com/memegenerator
//Uploadovati sliku od koje treba napraviti mim
//Mim mora biti vezan za IT, QA ili kurs
//Sliku rucno skinuti i ubaciti na Slack thread poruku
//Autor mima sa najvise lajkova dobija pivo na druzenju
//
//Napomena: Izazov zadatka je kod lokatora, assertove ne treba dodavati i ne treba raditi sa anotacijama

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://imgflip.com/memegenerator");

        WebElement uploadButton = driver.findElement(By.id("mm-show-upload"));
        uploadButton.click();

        String imageLocation = "C:\\Users\\nelej\\Downloads\\25xn7c.jpg";
        WebElement uploadButton2 = driver.findElement(By.id("mm-upload-file"));
        uploadButton2.sendKeys(imageLocation);

        WebElement uploadImage = driver.findElement(By.id("mm-upload-btn"));
        uploadImage.click();

        WebElement addTextBox = driver.findElement(By.className("mm-add-text"));
        addTextBox.click();
       // Thread.sleep(1000);
        List<WebElement> textBoxes = driver.findElements(By.className("mm-text"));
        textBoxes.get(0).click();
        textBoxes.get(0).sendKeys("SQL");
        textBoxes.get(2).click();
        textBoxes.get(2).sendKeys("JAVA");
        textBoxes.get(1).click();
        textBoxes.get(1).sendKeys("SELENIUM");









    }

}
