import org.testng.annotations.*;

public class Selenium8 {
    // Anotacija je sve sto se pise posle znaka @, oznacavanje sta sledeca metoda radi, kao kada bi dodali tag za neku sliku
    //kada zelimo da naglasimo neku metodu sta zeli da radi
    //vezuju se za prvu narednu metodu


    @BeforeClass
    public void method(){
        System.out.println("-----------------");
        System.out.println("OVO JE ISPIS IZ BEFORE CLASS");
        System.out.println("-----------------");
    }
    //Before Method se izvrsava se pre svake @Test anotacije
    //Izvrsavaju se od manjeg ka vecem
    //Ako metoda nema naznacen prioritet uzima se default vrednost 0
    //Metode mogu imati isti prioritet
    @BeforeMethod
    public void method2(){
        System.out.println("****************");
        System.out.println("OVO JE ISPIS IZ BEFORE METHOD");
        System.out.println("********************");
    }

    //Prioriteti odredjuju kojim redosledom se izvrsavaju @Test metode
//    Ako metoda
    @Test(priority = 10)
    //odredjuje koliko cemo imati before method i after method
    //ako imamo 2 test metode izvrsice se 2 before metode i 2 after metode
    //moze 1, 2, 3. ali Dragoljub stavlja da budu deljivi sa 10 jer moze izmedju lakse da ubaci testove, da ne menja sve brojeve
    public void test1(){
        System.out.println("========================");
        System.out.println("TEST 1");
        System.out.println("========================");
    }

    @Test(priority = 20)
    public void test2(){
        System.out.println("========================");
        System.out.println("TEST 2");
        System.out.println("========================");
    }

    @Test(priority = 30)
    public void test3(){
        System.out.println("========================");
        System.out.println("TEST 3");
        System.out.println("========================");
    }

    //After Method se izvrsava nakon svake @Test anotacije
    @AfterMethod
    public void method4(){
        System.out.println("//////////////////////");
        System.out.println("AFTER METHOD");
        System.out.println("/////////////////////////");
    }

    @AfterClass
    public void method5(){
        System.out.println("++++++++++++++++++++++++");
        System.out.println("AFTER METHOD");
        System.out.println("++++++++++++++++++++++++++");
    }
    /*
    import org.testng.annotations.*;

public class Selenium8 {

    // Before Class izvrsava se SAMO jednom i SAMO na pocetku (pre svih metoda)
    @BeforeClass
    public void method1() {
        System.out.println("-------------------");
        System.out.println("OVO JE ISPIS IZ BEFORE CLASS");
        System.out.println("-------------------");
    }

    // Before Method se izvrsava pre svake @Test anotacije
    @BeforeMethod
    public void method2() {
        System.out.println("+++++++++++++++++");
        System.out.println("OVO JE ISPIS IZ BEFORE METHOD");
        System.out.println("+++++++++++++++++");
    }

    // Prioriteti odredjuju kojim redosledim se izvrsavaju @Test metode
    // Ako metoda nema naznacen prioritet uzima se default vrednost 0
    // Prioriteti se izvrsavaju od manjeg ka vecem
    // Metode mogu imati isti prioritet
    @Test(priority = 10)
    public void test1() {
        System.out.println("====================");
        System.out.println("TEST 1");
        System.out.println("====================");
    }
    @Test(priority = 20)
    public void test2() {
        System.out.println("====================");
        System.out.println("TEST 2");
        System.out.println("====================");
    }
    @Test(priority = 30)
    public void test3() {
        System.out.println("====================");
        System.out.println("TEST 3");
        System.out.println("====================");
    }
    @Test(priority = 15)
    public void test4() {
        System.out.println("====================");
        System.out.println("TEST 1.5");
        System.out.println("====================");
    }

    // After Method se izvrsava nakon svake @Test anotacije
    @AfterMethod
    public void method4() {
        System.out.println("//////////////////");
        System.out.println("OVO JE ISPIS IZ AFTER METHOD");
        System.out.println("//////////////////");
    }

    // After Class izvrsava se SAMO jednom i SAMO na kraju klase (nakon svih metoda)
    @AfterClass
    public void method5() {
        System.out.println("...........................");
        System.out.println("OVO JE ISPIS IZ AFTER CLASS");
        System.out.println("...........................");
    }


}
     */


}
