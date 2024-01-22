import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.openqa.selenium.Keys.ENTER;

public class P15_01_2024_Zadatak4 {
    public static void main(String[] args) {
        //Zadatak 3
        //Otici na Google
        //Zatim ukucati "Wikipedia" u polje za pretragu
        //Odraditi pretragu i otvoriti stranicu
        //Na stranici Wikipedia pretraziti "Nikola Tesla"

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Wikipedia");
        searchBox.sendKeys(ENTER);

        WebElement wikipediaLink = driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));
        wikipediaLink.click();

        WebElement wikipediaSearch = driver.findElement(By.id("searchInput"));
        wikipediaSearch.sendKeys("Nikola Tesla");

//WebElement wikipediaButton = driver.findElement(By.cssSelector(".pure-button.pure-button-primary-progressive"));
        WebElement wikipediaButton = driver.findElement(By.cssSelector("button[type='submit']"));
        wikipediaButton.click();

        //-------------------------------------------

        String expectedURL = "https://en.wikipedia.org/wiki/Nikola_Tesla";

        //Kada koristimo assertEquals sa leve strane je REALAN rezultat, a sa desne je OCEKIVAN rezultat
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        //kada radimo asertaciju uvek proverimo tako da padne test, tj pogresne podatke unesemo kako bi bili sigurni da radi dobro

        WebElement pageTitle = driver.findElement(By.className("mw-page-title-main"));
        String pageTitleText = pageTitle.getText(); //ova metoda pronalazi element iznad i izvlaci tekst
        String expectedTitle = "Nikola Tesla";

        Assert.assertEquals(pageTitleText, expectedTitle);

        WebElement pageImage = driver.findElement(By.className("infobox-image"));

        Assert.assertTrue(pageImage.isDisplayed()); //proveravamo da li je u redu tako sto umesto True ukucamo False, trebalo bi da padne test
    }
}
