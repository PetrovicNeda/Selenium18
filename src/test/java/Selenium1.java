import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {

    public static void main(String[] args) {

        //Stari nacin kako smo ucitavali chrome driver
        //Morali smo chromedriver.exe file da skinemo i smestimo u odredjen folder
        //Nakon toga komanda setProperty bi citala taj fajl
        //Postojao je problem kod odredjenih operativnih sistema gde je antivirus brisao ovaj fajl
        //i testovi bi padali jer fajl vise ne postoji pa ste morali da posesavate 'exception' za fajl

        //

        //Ovu komandu koristimo da podesimo chromedriver iz biblioteke koju smo uneli u pom fajl
        //Na pocetku klase mozete videti:
        //import io.github.bonigarcia.wdm.WebDriverManager;
        //gde se jasno vidi iz koje biblioteke se izvlaci komanda
        //To jeona treca biblioteka koju smo ubacili u pom fajl
        //Kada setujemo chromedriver potrebno je da napravimo obekat sa kojim cemo raditi
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); // ubacivanje objekta WebDriver

        //Komanda navigate().to() nam otvara zeljeni URL
        //Obratite paznju koju URL ubacujete
        //Ako link nije podvucen kao u ovom primeru, onda znaci da link nije validan
        driver.navigate().to("https://www.google.com"); //otvaranje stranice google
        //Sledeca komanda je za povecanje prozora u kom radimo
        //Slicna komanda je manage().windows(_
        driver.manage().window().maximize(); // povecavanje prozora na max

        driver.get("https://www.youtube.com"); // otvara youtube

        //get i navigate je isto tj otvaraju stranicu,
        // ali navigate to ne ceka da program reaguje da
        // nastavi dalje, a get ce sacekati da se stranica
        // aktivira pa ce nastaviti dalje posle,
        // ceka da sistem reaguje
        // get trazi povratnu informaciju npr ako zelimo da odemo na stranicu koja ne postoji

        System.out.println(driver.getCurrentUrl()); // da se odstampa na kojoj smo stranici, proveravamo da li nam je URL dobar ovo moze biti prva asertacija

        driver.navigate().refresh();

        driver.navigate().back(); // ide nazad na google

        System.out.println(driver.getCurrentUrl());

        driver.navigate().forward(); // ide na stranicu napred (yt ponovo)

        driver.quit(); //stavlja se kada zelimo da zatvorimo browser tj. kad zavrsimo sa testiranjem i vidimo da je sve ok tj. da sve radi
//        driver.close(); // trenutni tab zatvara na kome se nalazi
        /*
        import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {

    public static void main(String[] args) {

        // mvn repository sajt sa kog skidamo dependencies
        Stari nacin kako smo ucitavali chrome driver
        //Morali smo chromedriver.exe file da skinemo i smestimo u odredjen folder
        //Nakon toga komanda setProperty bi citala taj fajl
        //Postojao je problem kod odredjenih operativnih sistema gde je antivirus brisao ovaj fajl
        //i testovi bi padali jer fajl vise ne postoji pa ste morali da podesavate 'exception' za fajl

        //System.setProperty("webdrive.chrome.driver", "driver-lib\\chromedriver.exe"); --deprecated

        //Ovu komandu koristimo da podesimo chromedriver iz biblioteke koju smo uneli u pom fajl
        //Na pocetku klase mozete videti:
        //import io.github.bonigarcia.wdm.WebDriverManager;
        //gde se jasno vidi iz koje biblioteke se izvlaci komanda
        //To je ona treca biblioteka koju smo ubacili u pom fajl
        //Kada setujemo chromedriver potrebno je da napravimo objekat sa kojim cemo raditi
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Komanda navigate().to() nam otvara zeljeni URL
        //Obratite paznju koju URL ubacujete
        //Ako link NIJE podvucen kao u ovom primeru, onda znaci da link nije validan
        driver.navigate().to("https://www.google.com/");
        //Sledeca komanda je za povecanje prozora u kom radimo
        //Slicna komanda je manage().window().fullscreen()
        driver.manage().window().maximize();

        //Drugi nacin kako da odete na zeljeni URL je preko get() metode
        driver.get("https://www.youtube.com");

        //Razlike izmedju navigate i get mozete naci na narednom linku:
        //https://www.baeldung.com/selenium-webdriver-get-vs-navigate#:~:text=And%20because%20it's%20just%20an,driver.

        //Komanda za stampanje trenutno URL-a
        //Imajte u vidu da URL moze da se razlikuje od unetog iz prethodnog koraka
        System.out.println(driver.getCurrentUrl());

        //Komanda za refresh
        driver.navigate().refresh();

        //Komanda za vracanje na prethodnu stranicu
        driver.navigate().back();

        System.out.println(driver.getCurrentUrl());

        //Komanda za odlazak na narednu stranicu
        driver.navigate().forward();

        //quit() metoda se ostavlja za sam kraj i ona ce da ugasi browser u kome se radilo
        //Dok pravite testove nemojte da pisete tu metodu jer kao QA zelite da vidite sta vam
        //program radi, odnosno sta se testira
        //Tek kada ste sigurni da vam je test gotov i sve radi kako treba, onda koristite ovu metodu
        driver.quit();
        //driver.close();
        //close() metoda zatvara trenutni tab koji vam je otvoren
        //Ako radite u jednom tabu i na ovaj nacin zatvorite browser onda cete imati problema
        //sa testovima jer ce program cekati odgovor
    }
}
         */





    }
}
