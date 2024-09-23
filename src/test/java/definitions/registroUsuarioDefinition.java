package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.registroUsuarioSteps;

import utils.ExcelReader;

public class registroUsuarioDefinition {

    @Steps
    registroUsuarioSteps registroUsuarioSteps;
    
    ExcelReader excelReader = new ExcelReader();
    
    @Given("^El usuario ingresa a la página de DemoBlaze$")
    public void el_usuario_ingresa_a_la_página_de_DemoBlaze() throws Throwable {
    	registroUsuarioSteps.openPage();
    }

    @When("^El usuario ingresa al módulo de registro de usuario$")
    public void el_usuario_ingresa_al_módulo_de_registro_de_usuario() throws Throwable {
    	registroUsuarioSteps.openUserRegister();
    }

    @When("^Ingresa el nombre de usuario desde el archivo usuarios\\.xlsx fila \"([^\"]*)\"$")
    public void ingresaElNombreDeUsuarioDesdeElArchivoUsuariosXlsxFila(int fila) throws Throwable {
    	String[] credenciales = excelReader.getCredentials(fila);
    	String username = credenciales[0];
    	System.out.println(username);
    	registroUsuarioSteps.enterUsername(username);
    }

    @When("^Ingresa la contraseña desde el archivo usuarios\\.xlsx fila \"([^\"]*)\"$")
    public void ingresaLaContraseñaDesdeElArchivoUsuariosXlsxFila(int fila) throws Throwable {
    	String[] credenciales = excelReader.getCredentials(fila);
    	String password = credenciales[1];
    	System.out.println(password);
    	registroUsuarioSteps.enterPassword(password);
    }

    @Then("^Confirmar creación de usuario$")
    public void confirmar_creación_de_usuario() throws Throwable {
    	registroUsuarioSteps.confirmRegister();
    }

}
