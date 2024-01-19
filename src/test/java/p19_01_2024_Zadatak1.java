import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class p19_01_2024_Zadatak1 {
    /*
    Za pocetak nastavite pisanje testova za login sto smo poceli juce.
    Ideja je da u jednoj klasi imate sve metode (test kejseve) za testiranje ove funkcionalnosti.
    To bi bio log in, log out i neuspeli pokusaji
    Mozete da radite sve testove u jednom browseru ili svaki test u posebnom
     */

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void pageSetUp(){

    }


}
