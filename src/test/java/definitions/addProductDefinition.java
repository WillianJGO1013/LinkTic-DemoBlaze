package definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.addProductSteps;

public class addProductDefinition {
	
	@Steps
	addProductSteps addProductSteps;
	
	@When("^El usuario ingresa a la categoria Laptops$")
	public void elUsuarioIngresaALaCategoriaLaptops() throws Throwable {
		addProductSteps.selectLaptops();
	}


	@When("^Selecciona el producto MacBook Pro$")
	public void seleccionaElProductoMacBookPro() throws Throwable {
		addProductSteps.selectProduct();
	}

	@When("^Agrega el producto MacBook Pro a la sección de compras$")
	public void agregaElProductoMacBookProALaSecciónDeCompras() throws Throwable {
		addProductSteps.addProduct();
	}

	@When("^El usuario ingresa al modulo Cart$")
	public void elUsuarioIngresaAlModuloCart() throws Throwable {
		addProductSteps.openCart();
	}

	@Then("^Confirmar que el producto se añadio correctamente$")
	public void confirmarQueElProductoSeAñadioCorrectamente() throws Throwable {
		addProductSteps.confirmAdd();
	}

}
