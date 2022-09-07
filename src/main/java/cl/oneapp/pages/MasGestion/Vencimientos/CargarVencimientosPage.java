package cl.oneapp.pages.MasGestion.Vencimientos;

import cl.oneapp.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CargarVencimientosPage extends TestBase {
    public CargarVencimientosPage(WebDriver driver) {
        super(driver);
    }

    protected WebDriver driver;
    By menu = By.xpath("//*[@id=\"sidebar-left\"]/div[1]/div[2]");
    By masGestion = By.xpath("//span[contains(text(), \"+Gestión\")]");
    By vencimientos = By.xpath("//*[@id=\"menu\"]/ul/li[24]/ul/li[1]/a");
    By cargas = By.xpath("//span[contains(text(), \"Cargas de vencimientos\")]");
    By cargarVencimientos = By.xpath("//span[contains(text(), \"Cargar vencimientos\")]");

    By inputArchivo = By.id("VencimientoArchivo");

    By mesVencimiento = By.id("VencimientoPeriodoMonth");

    By annioVencimiento =  By.id("VencimientoPeriodoYear");

    By btnCargar = By.id("cargar");


    public void accesoVista() throws InterruptedException {
        Thread.sleep(2000);
        darClic(menu);
        Thread.sleep(2000);
        darClic(masGestion);
        Thread.sleep(2000);
        darClic(vencimientos);
        Thread.sleep(2000);
        darClic(cargas);
        Thread.sleep(2000);
        darClic(cargarVencimientos);
        Thread.sleep(5000);
    }

    public void cargaVencimientos(String ruta) throws InterruptedException {
        ingresarTexto(inputArchivo, ruta);
        seleccionarOpcion(mesVencimiento, "Septiembre");
        Thread.sleep(5000);
    }
}
