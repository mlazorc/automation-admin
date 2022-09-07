package cl.oneapp.base;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestBase {

    private WebDriver driver;

    public TestBase(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver conexioNavegador(){
        System.setProperty("web-driver.chrome.driver", "/Users/marcolazo/Documents/Testing/admin-automation/Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public void visitarSitio(String url){
        driver.get(url);
    }

    public void darClic(By elemento){
        driver.findElement(elemento).click();
    }

    public void ingresarTexto(By elemento, String texto){
        driver.findElement(elemento).sendKeys(texto);
    }

    public void salirPrueba(){
        driver.quit();
    }

    public String fechaActual(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public void capturarPantalla(String ruta){
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File print = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(print, new File(ruta));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crearEvidencia(String titulo, String ruta) throws IOException, DocumentException {
        try{
            Document document = new Document(PageSize.A4, 50, 50, 50, 50);
            PdfWriter.getInstance(document, new FileOutputStream(ruta));
            document.open();
            document.addTitle("Documento evidencia casos de prueba");
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File captura = takesScreenshot.getScreenshotAs(OutputType.FILE);
            Image imagen = Image.getInstance(String.valueOf(captura));
            float documentoWidth = document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin();
            float documentoHeight = document.getPageSize().getHeight() - document.topMargin() - document.bottomMargin();
            imagen.scaleToFit(documentoWidth,documentoHeight);
            document.add(new Chapter(titulo,1));
            document.add(imagen);
            document.close();
        }catch (IOException i){
            i.printStackTrace();
            System.out.println("No fue posible capturar la evidencia");
        }
    }

    public String obtenerTexto(By elemento){
        return driver.findElement(elemento).getText();
    }

    public void seleccionarOpcion(By element, String opcion){
        WebElement lista = element.findElement(driver);
        List<WebElement> opciones = lista.findElements(By.tagName("li"));
        opciones.forEach(option->{
            if (option.getAttribute("innerText").equals(opcion)){
                Actions acciones = new Actions(driver);
                acciones.moveToElement(option).click().perform();
            }
        });
    }


}
