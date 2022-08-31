package cl.oneapp.testcases;

import cl.oneapp.pages.Accesos.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class LoginPageTest {

    LoginPage loginPage;
    WebDriver driver;

    @Before
    public void beforeMethod(){
        loginPage = new LoginPage(driver);
        driver = loginPage.conexioNavegador();
        loginPage.visitarSitio("https://desarrollo.oneapp.cl/admin/admin/administradores/login");
    }

    @Test
    public void accesoApp(){
        loginPage.accesoLogin("admin","andain5546");
        System.out.println("Acceso correcto");
    }

    @After
    public void after(){
        loginPage.salirPrueba();
    }
}
