package cl.oneapp.testcases;

import cl.oneapp.pages.Accesos.LoginPage;
import com.itextpdf.text.DocumentException;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class LoginPageTest {

    LoginPage loginPage;
    WebDriver driver;

    @Before
    public void beforeMethod(){
        loginPage = new LoginPage(driver);
        driver = loginPage.conexioNavegador();
        loginPage.visitarSitio("http://certificacion.fcv-chile.oneapp.cl/admin/admin/administradores/login");
    }



    @Test
    public void accesoApp() throws InterruptedException, DocumentException, IOException {
        try{

            By spanNombre = By.className("name");
            loginPage.accesoLogin("admin","andain5546");
            if(loginPage.obtenerTexto(spanNombre).equals("Administrador")){
                loginPage.crearEvidencia("Acceso correcto","./Evidencias/Acertadas/acceso_"+loginPage.fechaActual()+"_test.pdf");
            }
        }catch ( Exception e){
            loginPage.crearEvidencia("Acceso fallido","./Evidencias/Fallidas/fallida_"+loginPage.fechaActual()+"_test.pdf");
        }
    }

    @After
    public void after(){
        loginPage.salirPrueba();
    }
}
