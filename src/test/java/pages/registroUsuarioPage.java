package pages;

import static org.junit.Assert.assertEquals;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

import java.io.IOException;
import java.util.Properties;
import java.io.FileReader;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
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
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		find(btnSignUp).click();
		System.out.println("Se realizo click en el botón SignUp");        
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            System.out.println("Texto de la alerta: " + alertText);
            alert.accept();
            System.out.println("Alerta aceptada.");
            Serenity.takeScreenshot();
        } catch (Exception e) {
            System.out.println("No se detectó la ventana emergente.");
        }
        Serenity.takeScreenshot();
	}

}
