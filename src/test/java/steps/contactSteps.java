package steps;

import java.io.FileNotFoundException;
import java.io.IOException;

import net.thucydides.core.annotations.Step;
import pages.contactPage;

public class contactSteps {
	
	contactPage contactPage;
	
	@Step
	public void openContact() throws FileNotFoundException, IOException {
		contactPage.openContact();
	}
	
	@Step
	public void enterEmail(String email) {
		contactPage.enterEmail(email);
	}
	
	@Step
	public void enterName(String name) {
		contactPage.enterName(name);
	}
	
	@Step
	public void enterMsg(String msg) {
		contactPage.enterMsg(msg);
	}
	
	@Step
	public void confirmSend() {
		contactPage.confirmSend();
	}

}
