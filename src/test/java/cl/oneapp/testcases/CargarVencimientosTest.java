package cl.oneapp.testcases;

import cl.oneapp.pages.Accesos.LoginPage;
import cl.oneapp.pages.MasGestion.Vencimientos.CargarVencimientosPage;
import com.itextpdf.text.DocumentException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CargarVencimientosTest {
    LoginPage loginPage;
    WebDriver driver;
    CargarVencimientosPage cargarVencimientosPage;
    @Before
    public void before(){
        loginPage =  new LoginPage(driver);
        driver = loginPage.conexioNavegador();
        loginPage.visitarSitio("http://certificacion.fcv-chile.oneapp.cl/admin");
        loginPage.accesoLogin("admin","andain5546");
        cargarVencimientosPage = new CargarVencimientosPage(driver);
    }

    @Test
    public void cargarVerncimientos() throws InterruptedException, DocumentException, IOException {
        cargarVencimientosPage.accesoVista();
        String url = driver.getCurrentUrl();
        String cliente = "http://certificacion.fcv-chile.oneapp.cl/admin/admin/vencimiento/vencimientos/carga";
        if(url.equals(cliente)){
            cargarVencimientosPage.crearEvidencia("Acceso a la vista","./Evidencias/Acertadas/vista_"+cargarVencimientosPage.fechaActual()+".pdf");
            System.out.println("Acceso correcto a la vista");
        }else{
            cargarVencimientosPage.crearEvidencia("Acceso fallido","./Evidencias/Fallidas/fallo_"+cargarVencimientosPage.fechaActual()+".pdf");
            System.out.println("No fue posible el acceso a la vista");
        }
    }

    @Test
    public void cargarVencimientos() throws InterruptedException {
        cargarVencimientosPage.cargaVencimientos("");
    }

    @After
    public void after(){
        cargarVencimientosPage.salirPrueba();
    }

}
