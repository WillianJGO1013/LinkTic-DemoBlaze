package pages;

import static org.junit.Assert.assertEquals;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

import java.io.IOException;
import java.util.Properties;
import java.io.FileReader;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import elements.registroUsuarioElement;

public class registroUsuarioPage extends PageObject {

    Properties loadProperty = new Properties();

    static By btnModuleSignIn = registroUsuarioElement.btnModuleSignIn.getValor_campo();
    static By imgModuleSignIn = registroUsuarioElement.imgModuleSignIn.getValor_campo();
    static By lblSignIn = registroUsuarioElement.lblSignIn.getValor_campo();
    static By txtUserNameSignIn = registroUsuarioElement.txtUserNameSignIn.getValor_campo();
    static By txtPasswordSignIn = registroUsuarioElement.txtPasswordSignIn.getValor_campo();
    static By btnSignUp = registroUsuarioElement.btnSignUp.getValor_campo();    

    public void enterURL() {
        try {
            open();
        } catch (Exception e) {
            System.out.println("No fue posible abrir la url");
        }
    }

    public void openUserRegister() throws IOException {
        loadProperty.load(new FileReader("./demoblaze.properties"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        String titulopaginaHome = loadProperty.getProperty("tituloHome");
        System.out.println(titulopaginaHome);
        String titlepageHome = getDriver().getTitle();
        System.out.println(titlepageHome);
        assertEquals(titulopaginaHome,titlepageHome);
        System.out.println("El home de Demoblaze se abrió correctamente");
        find(btnModuleSignIn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(imgModuleSignIn));
        String labelSignIn = find(lblSignIn).getText();
        System.out.println(labelSignIn);
        String textLabelSignIn = loadProperty.getProperty("textLabelSignIn");
        System.out.println(textLabelSignIn);
        assertEquals(labelSignIn,textLabelSignIn);
        System.out.println("El módulo de registro de usuario se abrió correctamente");
        Serenity.takeScreenshot();
    }

	public void enterUsername(String username) throws InterruptedException {
		find(txtUserNameSignIn).type(username);
		System.out.println("Se diligenció el campo Username");
	}

	public void enterPassword(String password) {
		find(txtPasswordSignIn).type(password);
		System.out.println("Se diligenció el campo Password");
		Serenity.takeScreenshot();
	}

	public void confirmRegister() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 5);
		find(btnSignUp).click();
		System.out.println("Se realizo click en el botón SignUp");        
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Serenity.takeScreenshot();
            getDriver().switchTo().alert().accept();
            System.out.println("Se aceptó el registro del usuario.");
        } catch (Exception e) {
            System.out.println("No se encontró la ventana emergente de registro.");
        }
        Serenity.takeScreenshot();
	}

}
