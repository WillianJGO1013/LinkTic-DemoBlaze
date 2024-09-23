package elements;

import org.openqa.selenium.By;

public enum addProductElement {
	
	btnLaptops (By.xpath("/html/body/div[5]/div/div[1]/div/a[3]")),
	productMBP (By.xpath("//*[@id=\"tbodyid\"]/div[6]/div/div/h4/a")),
	btnAdd (By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")),
	btnModuleCart (By.xpath("//*[@id=\"cartur\"]")),
	lblProducts (By.xpath("//*[@id=\"page-wrapper\"]/div/div[1]/h2")),
	lblProductAdd (By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]"));
	
	private By valor_campo;

	addProductElement(By valorCampo) {
        this.setValor_campo(valorCampo);
    }

    public void setValor_campo(By valorCampo) {
        this.valor_campo = valorCampo;
    }

    public By getValor_campo() {
        return valor_campo;
    }

}
