package steps;

import net.thucydides.core.annotations.Step;
import pages.registroUsuarioPage;

import java.io.IOException;

public class registroUsuarioSteps {

    registroUsuarioPage registroUsuarioPage;

    @Step
    public void openPage() {
        registroUsuarioPage.open();
        registroUsuarioPage.enterURL();
    }

    @Step
    public void openUserRegister() throws IOException {
        registroUsuarioPage.openUserRegister();
    }

    @Step
    public void enterUsername(String username) throws InterruptedException {
    	registroUsuarioPage.enterUsername(username);
	}

    @Step
    public void enterPassword(String password) {
    	registroUsuarioPage.enterPassword(password);
    }

    @Step
    public void confirmRegister() {
    	registroUsuarioPage.confirmRegister();
    }

}
