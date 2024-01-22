import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.openqa.selenium.Keys.ENTER;

public class Selenium4 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
/*
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea")).sendKeys("IT Bootcamp");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea")).sendKeys(ENTER);
        driver.navigate().back();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea")).sendKeys("Wikipedia");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea")).sendKeys(ENTER);
*/
//         Skracena verzija koda iznad
        WebElement searchBox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea\""));
        searchBox.sendKeys("IT Bootcamp");
        searchBox.sendKeys(ENTER);
        driver.navigate().back();
        searchBox.sendKeys("Wikipedia");
        searchBox.sendKeys(ENTER);

        //LOKATORI


//        Flaky testovi - koji nisu pouzdani
//        Vrste lokatora:
//        ID - najpouzdaniji i najstabilniji, u idealnoj situaciji je jedinstven (ne mora biti jedinstven), da bi videli da li je jedinstven prekopiramo naziv id-a i CTRL+f search box se otvori i pasteujemo ime
        WebElement searchBoxByID = driver.findElement(By.id("APjFqb"));

//        Name -
        WebElement searchBoxByName = driver.findElement(By.name("q"));

//        Class
        WebElement searchBoxByClass = driver.findElement(By.className("gLFyf"));

//        CSS Selector
        WebElement searchBoxByCSSSelector = driver.findElement(By.cssSelector("textarea[type='search']"));
//       Primer kada koristimo CSS Selector preko klase koja unutar vrednosti ima 'space'
        WebElement searchBoxByFakeClass = driver.findElement(By.className("search box google"));
        WebElement searchBoxByFakeCSS = driver.findElement(By.cssSelector(".search.box.google"));

//        Relative Xpath
        WebElement searchBoxRelativeXpath = driver.findElement(By.xpath("//div[2]/div/textarea"));

//        Absolute Xpath - Poslednji po hijerarhiji, najnestabilniji, moze se koristiti na pocetku dok se kreiraju testovi, ali zahteva
        WebElement searchBoxAbsoluteXpath = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea\""));
    }
}
