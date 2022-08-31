package cl.oneapp.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

}
