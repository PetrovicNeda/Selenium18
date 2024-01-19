import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class d18_01_2024_Zadatak1 {
    /*
    Koristeci Anotacije - Ulogujte se na demoqa(https://demoqa.com/ -> Book Store Application) preko cookies-a,
    dodati dve knjige na svoj nalog, zatim se izlogovati brisanjem cookies-a.
    Ulogovati se ponovo preko log-in forme i potvrditi da se knjige i dalje nalaze na nalogu
     */

    WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;
    String validUsername;
    String validPassword;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        validUsername = "Korisnik";
        validPassword = "Korisnik123!";

    }
    @BeforeMethod
    public void pageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        js = (JavascriptExecutor) driver;
        WebElement bookStoreAppButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[6]/div/div[3]"));
        js.executeScript("arguments[0].scrollIntoView(true);", bookStoreAppButton);
        bookStoreAppButton.click();
    }

    @Test
    public void test1() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));
        WebElement logInButton = driver.findElement(By.id("login"));
        logInButton.click();

//        Cookie cookie = new Cookie("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IktvcmlzbmlrIiwicGFzc3dvcmQiOiJLb3Jpc25pazEyMyEiLCJpYXQiOjE3MDU2NjgzMzJ9.2GYeJbctonxg83osgjEPCLaAdpg307joCVOtWb0__6U");
//        driver.manage().addCookie(cookie);
//        driver.navigate().refresh();

        WebElement usernameField = driver.findElement(By.id("userName"));
        usernameField.sendKeys(validUsername);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(validPassword);

        WebElement logIn = driver.findElement(By.id("login"));
        logIn.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("see-book-Git Pocket Guide")));
        WebElement book1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        book1.click();

        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        js.executeScript("arguments[0].scrollIntoView(true);", addButton);
        addButton.click();

        WebElement book2 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        book2.click();
        WebElement addButton2 = driver.findElement(By.id("addNewRecordButton"));
        js.executeScript("arguments[0].scrollIntoView(true);", addButton2);
        addButton2.click();

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        WebElement checkingLogInButton = driver.findElement(By.id("login"));
        Assert.assertTrue(checkingLogInButton.isDisplayed());

    }
    @Test
    public void test2() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));
        WebElement logInButton = driver.findElement(By.id("login"));
        logInButton.click();

        WebElement usernameField = driver.findElement(By.id("userName"));
        usernameField.sendKeys(validUsername);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(validPassword);

        WebElement logIn = driver.findElement(By.id("login"));
        logIn.click();

        WebElement bookStoreAppButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/span/div"));
        js.executeScript("arguments[0].scrollIntoView(true);", bookStoreAppButton);


        WebElement profileButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]"));
        profileButton.click();

        //Kada idem na Profile dugme me odloguje sa stranice pa moram ponovo da se logujem i tek onda mi otvori Profile,
        //ali ovo se ne desava kada rucno idem korak po korak
        //tako da sam zbog toga ubacila dodatno logovanje

        WebElement logIn2 = driver.findElement(By.linkText("login"));
        logIn2.click();

        WebElement usernameField1 = driver.findElement(By.id("userName"));
        usernameField1.sendKeys(validUsername);

        WebElement passwordField1 = driver.findElement(By.id("password"));
        passwordField1.sendKeys(validPassword);

        WebElement logIn3 = driver.findElement(By.id("login"));
        logIn3.click();

        //Implicit wait se ovde nalazi jer AssertFalse prolazi bez njega
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        List<WebElement> books = driver.findElements(By.cssSelector(".rt-tr-group"));
        for(int i = 0; i < books.size(); i++){
            Assert.assertTrue(books.get(i).isDisplayed());
        }

    }
//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }



}



