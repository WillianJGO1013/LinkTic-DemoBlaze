package elements;

import org.openqa.selenium.By;

public enum loginUsuarioElement {
	
	btnModuleLogIn (By.xpath("//*[@id=\"login2\"]")),
	imgModuleLogIn (By.xpath("//*[@id=\"logInModal\"]/div/div")),
	lblLogIn (By.xpath("//*[@id=\"logInModalLabel\"]")),
	txtUserNameLogIn (By.xpath("//*[@id=\"loginusername\"]")),
	txtPasswordLogIn (By.xpath("//*[@id=\"loginpassword\"]")),
	btnLogIn (By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")),
	lblUserLogged (By.xpath("//*[@id=\"nameofuser\"]"));
	
	private By valor_campo;

	loginUsuarioElement(By valorCampo) {
        this.setValor_campo(valorCampo);
    }

    public void setValor_campo(By valorCampo) {
        this.valor_campo = valorCampo;
    }

    public By getValor_campo() {
        return valor_campo;
    }
	
	

}
