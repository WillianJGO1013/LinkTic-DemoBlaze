package definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.loginUsuarioSteps;
import utils.ExcelReader;

public class loginUsuarioDefinition {
	
	@Steps	
	loginUsuarioSteps loginUsuarioSteps;
	
	ExcelReader excelReader = new ExcelReader();
    
	@When("^El usuario ingresa al módulo de login de usuario$")
    public void elUsuarioIngresaAlMóduloDeLoginDeUsuario() throws Throwable {
    	loginUsuarioSteps.openUserLogin();
    }
    
    @When("^Ingresa el nombre de usuario existente desde el archivo usuarios\\.xlsx fila \"([^\"]*)\"$")
    public void ingresaElNombreDeUsuarioExistenteDesdeElArchivoUsuariosXlsxFila(int fila) throws Throwable {
    	String[] credenciales = excelReader.getCredentials(fila);
    	String username = credenciales[0];
    	System.out.println(username);
    	loginUsuarioSteps.enterUsername(username);
    }


    @When("^Ingresa la contraseña de usuario existente desde el archivo usuarios\\.xlsx fila \"([^\"]*)\"$")
    public void ingresaLaContraseñaDeUsuarioExistenteDesdeElArchivoUsuariosXlsxFila(int fila) throws Throwable {
    	String[] credenciales = excelReader.getCredentials(fila);
    	String password = credenciales[1];
    	System.out.println(password);
    	loginUsuarioSteps.enterPassword(password);
    }
    
    @Then("^Confirmar login de usuario \"([^\"]*)\"$")
    public void confirmarLoginDeUsuario(int fila) throws Throwable {
    	String[] credenciales = excelReader.getCredentials(fila);
    	String username = credenciales[0];
    	System.out.println(username);
    	loginUsuarioSteps.confirmLogin(username);
    }

}
