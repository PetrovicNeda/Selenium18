import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P12_01_2024_Zadatak3 {
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

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea")).sendKeys("Wikipedia");

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[6]/center/input[1]")).click();

        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")).click();

        driver.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys("Nikola Tesla");

        driver.findElement(By.xpath("/html/body/div[3]/form/fieldset/button")).click();
    }
}