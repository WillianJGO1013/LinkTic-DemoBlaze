package pages;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements.loginUsuarioElement;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class loginUsuarioPage extends PageObject {
	
	Properties loadProperty = new Properties();
	
	static By btnModuleLogIn = loginUsuarioElement.btnModuleLogIn.getValor_campo();
    static By imgModuleLogIn = loginUsuarioElement.imgModuleLogIn.getValor_campo();
    static By lblLogIn = loginUsuarioElement.lblLogIn.getValor_campo();
    static By txtUserNameLogIn = loginUsuarioElement.txtUserNameLogIn.getValor_campo();
    static By txtPasswordLogIn = loginUsuarioElement.txtPasswordLogIn.getValor_campo();
    static By btnLogIn = loginUsuarioElement.btnLogIn.getValor_campo();
    static By lblUserLogged = loginUsuarioElement.lblUserLogged.getValor_campo();

	public void openUserLogin() throws FileNotFoundException, IOException {
		loadProperty.load(new FileReader("./demoblaze.properties"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        String titulopaginaHome = loadProperty.getProperty("tituloHome");
        System.out.println(titulopaginaHome);
        String titlepageHome = getDriver().getTitle();
        System.out.println(titlepageHome);
        assertEquals(titulopaginaHome,titlepageHome);
        System.out.println("El home de Demoblaze se abrió correctamente");
        find(btnModuleLogIn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(imgModuleLogIn));
        String labelLogIn = find(lblLogIn).getText();
        System.out.println(labelLogIn);
        String textLabelLogIn = loadProperty.getProperty("textLabelLogIn");
        System.out.println(textLabelLogIn);
        assertEquals(labelLogIn,textLabelLogIn);
        System.out.println("El módulo de login de usuario se abrió correctamente");
        Serenity.takeScreenshot();
	}

	public void enterUsername(String username) {
		find(txtUserNameLogIn).type(username);
		System.out.println("Se diligenció el campo Username");
	}

	public void enterPassword(String password) {
		find(txtPasswordLogIn).type(password);
		System.out.println("Se diligenció el campo Password");
		Serenity.takeScreenshot();
	}

	public void confirmLogin(String username) throws FileNotFoundException, IOException {
		loadProperty.load(new FileReader("./demoblaze.properties"));
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		find(btnLogIn).click();
		System.out.println("Se realizo click en el botón LogIn");
		wait.until(ExpectedConditions.visibilityOfElementLocated(lblUserLogged));
        String messageLogin = loadProperty.getProperty("msgLogin");
        String userLogged = messageLogin + " " + username;
        System.out.println(userLogged);
		String labelUserLogged = find(lblUserLogged).getText();
		System.out.println(labelUserLogged);
		assertEquals(labelUserLogged,userLogged);
		System.out.println("Usuario logueado correctamente.");
		Serenity.takeScreenshot();
	}

}
