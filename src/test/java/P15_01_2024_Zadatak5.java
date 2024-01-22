import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class P15_01_2024_Zadatak5 {
    public static void main(String[] args) {
        /*
        // Zadatak 5
        // Testirati log in stranice https://practicetestautomation.com/
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/");
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLogInButton = driver.findElement(By.linkText("Test Login Page"));
        testLogInButton.click();
/*
Provera da li je id = username jedinstven na stranici
        List<WebElement> username = driver.findElement(By.id("username"));
        System.out.println("Lista " + username.size());
*/
        String validUsername = "sudent";
        String validPassword = "Password123";
        WebElement usernameBox = driver.findElement(By.id("username"));
        usernameBox.sendKeys(validUsername);

        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.sendKeys(validPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        /*
        Razlika izmedju testa i programa za logovanje
        Tj. kako znamo da je test prosao
        menjanje URL, tekst koji je ispisan..
         */
//-----------------------------------------------------

        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement pageTitle = driver.findElement(By.className("post-title"));
//        String successfullyLogedInText = pageTitle.getText();

        String successfullyLogedInTextExpected = "Logged In Successfully";
//        Assert.assertEquals(successfullyLogedInText, successfullyLogedInTextExpected);
        Assert.assertEquals(pageTitle.getText(), successfullyLogedInTextExpected);


        WebElement logOutButton = driver.findElement(By.className("wp-block-button__link"));
//      WebElement logOut = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutButton.isDisplayed());

        WebElement welocmeText = driver.findElement(By.className("has-text-align-center"));
        Assert.assertEquals(welocmeText.isDisplayed(), welocmeText.getText());
    }
}
