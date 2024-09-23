package steps;

import java.io.FileNotFoundException;
import java.io.IOException;

import net.thucydides.core.annotations.Step;
import pages.loginUsuarioPage;

public class loginUsuarioSteps {
	
	loginUsuarioPage loginUsuarioPage;
	
	@Step
	public void openUserLogin() throws FileNotFoundException, IOException {
		loginUsuarioPage.openUserLogin();
	}
	
	@Step
	public void enterUsername(String username) {
		loginUsuarioPage.enterUsername(username);
	}
	
	@Step
	public void enterPassword(String password) {
		loginUsuarioPage.enterPassword(password);
	}
	
	@Step
	public void confirmLogin(String username) throws FileNotFoundException, IOException {
		loginUsuarioPage.confirmLogin(username);
	}

	
	
}
