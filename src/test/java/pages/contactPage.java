package pages;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements.contactElement;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class contactPage extends PageObject {
	
	Properties loadProperty = new Properties();
	
	static By btnModuleContact = contactElement.btnModuleContact.getValor_campo();
	static By imgModuleContact = contactElement.imgModuleContact.getValor_campo();
	static By lblContact = contactElement.lblContact.getValor_campo();
	static By txtEmailContact = contactElement.txtEmailContact.getValor_campo();
	static By txtNameContact = contactElement.txtNameContact.getValor_campo();
	static By txtMsgContact = contactElement.txtMsgContact.getValor_campo();
	static By btnSend = contactElement.btnSend.getValor_campo();

	public void openContact() throws FileNotFoundException, IOException {
		loadProperty.load(new FileReader("./demoblaze.properties"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        String titulopaginaHome = loadProperty.getProperty("tituloHome");
        System.out.println(titulopaginaHome);
        String titlepageHome = getDriver().getTitle();
        System.out.println(titlepageHome);
        assertEquals(titulopaginaHome,titlepageHome);
        System.out.println("El home de Demoblaze se abrió correctamente");
        find(btnModuleContact).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(imgModuleContact));
        String labelContact = find(lblContact).getText();
        System.out.println(labelContact);
        String textLabelContact = loadProperty.getProperty("textLabelContact");
        System.out.println(textLabelContact);
        assertEquals(labelContact,textLabelContact);
        System.out.println("El módulo de contacto se abrió correctamente");
        Serenity.takeScreenshot();
	}

	public void enterEmail(String email) {
		find(txtEmailContact).type(email);
		System.out.println("Se diligenció el campo Email");
	}

	public void enterName(String name) {
		find(txtNameContact).type(name);
		System.out.println("Se diligenció el campo Name");
	}

	public void enterMsg(String msg) {
		find(txtMsgContact).type(msg);
		System.out.println("Se diligenció el campo Message");
		Serenity.takeScreenshot();
	}

	public void confirmSend() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 5);
		find(btnSend).click();
		System.out.println("Se realizo click en el botón Send Message");
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
