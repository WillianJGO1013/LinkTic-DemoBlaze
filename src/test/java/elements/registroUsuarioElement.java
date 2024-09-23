package elements;

import org.openqa.selenium.By;

public enum registroUsuarioElement {

    btnModuleSignIn (By.xpath("//*[@id=\"signin2\"]")),
    imgModuleSignIn (By.xpath("//*[@id=\"signInModal\"]/div/div")),
    lblSignIn (By.xpath("//*[@id=\"signInModalLabel\"]")),
    txtUserNameSignIn (By.xpath("//*[@id=\"sign-username\"]")),
	txtPasswordSignIn (By.xpath("//*[@id=\"sign-password\"]")),
	btnSignUp (By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]"));

    private By valor_campo;

    registroUsuarioElement(By valorCampo) {
        this.setValor_campo(valorCampo);
    }

    public void setValor_campo(By valorCampo) {
        this.valor_campo = valorCampo;
    }

    public By getValor_campo() {
        return valor_campo;
    }

}
