package elements;

import org.openqa.selenium.By;

public enum contactElement {
	
	btnModuleContact (By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a")),
	imgModuleContact (By.xpath("//*[@id=\"exampleModal\"]/div/div")),
	lblContact (By.xpath("//*[@id=\"exampleModalLabel\"]")),
	txtEmailContact (By.xpath("//*[@id=\"recipient-email\"]")),
	txtNameContact (By.xpath("//*[@id=\"recipient-name\"]")),
	txtMsgContact (By.xpath("//*[@id=\"message-text\"]")),
	btnSend (By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]"));
	
	private By valor_campo;

	contactElement(By valorCampo) {
        this.setValor_campo(valorCampo);
    }

    public void setValor_campo(By valorCampo) {
        this.valor_campo = valorCampo;
    }

    public By getValor_campo() {
        return valor_campo;
    }

}
