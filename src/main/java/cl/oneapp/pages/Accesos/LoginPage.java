package cl.oneapp.pages.Accesos;

import cl.oneapp.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends TestBase {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By inputUsuario = By.id("AdministradorUsuario");
    By inputPass = By.id("AdministradorClave");
    By btnIngresar = By.xpath("//button[contains(text(),'Ingresar')]");

    public void accesoLogin(String usuario,  String clave){
        ingresarTexto(inputUsuario, usuario);
        ingresarTexto(inputPass, clave);
        darClic(btnIngresar);
    }


}
