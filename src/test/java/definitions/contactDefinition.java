package definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.contactSteps;
import utils.ExcelReaderContact;

public class contactDefinition {
	
	@Steps
	contactSteps contactSteps;
	
	ExcelReaderContact excelReaderContact = new ExcelReaderContact();
	
	@When("^El usuario ingresa al módulo de contacto$")
	public void elUsuarioIngresaAlMóduloDeContacto() throws Throwable {
		contactSteps.openContact();
	}


	@When("^Ingresa el correo de contacto desde el archivo contacto\\.xlsx fila \"([^\"]*)\"$")
	public void ingresaElCorreoDeContactoDesdeElArchivoContactoXlsxFila(int fila) throws Throwable {
		String[] contactDetails = excelReaderContact.getCredentials(fila);
    	String email = contactDetails[0];
    	System.out.println(email);
    	contactSteps.enterEmail(email);
	}

	@When("^Ingresa el nombre de la persona a contactar desde el archivo contacto\\.xlsx fila \"([^\"]*)\"$")
	public void ingresaElNombreDeLaPersonaAContactarDesdeElArchivoContactoXlsxFila(int fila) throws Throwable {
		String[] contactDetails = excelReaderContact.getCredentials(fila);
    	String name = contactDetails[1];
    	System.out.println(name);
    	contactSteps.enterName(name);
	}

	@When("^Ingresa el mensaje para la persona a contactar desde el archivo contacto\\.xlsx fila \"([^\"]*)\"$")
	public void ingresaElMensajeParaLaPersonaAContactarDesdeElArchivoContactoXlsxFila(int fila) throws Throwable {
		String[] contactDetails = excelReaderContact.getCredentials(fila);
    	String msg = contactDetails[2];
    	System.out.println(msg);
    	contactSteps.enterMsg(msg);
	}

	@Then("^Confirmar envío del mensaje$")
	public void confirmarEnvíoDelMensaje() throws Throwable {
		contactSteps.confirmSend();
	}

}
