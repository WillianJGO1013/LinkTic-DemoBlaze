package pages;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements.addProductElement;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class addProductPage extends PageObject {
	
	Properties loadProperty = new Properties();
	
	static By btnLaptops = addProductElement.btnLaptops.getValor_campo();
	static By productMBP = addProductElement.productMBP.getValor_campo();
	static By btnAdd = addProductElement.btnAdd.getValor_campo();
	static By btnModuleCart = addProductElement.btnModuleCart.getValor_campo();
	static By lblProducts = addProductElement.lblProducts.getValor_campo();
	static By lblProductAdd = addProductElement.lblProductAdd.getValor_campo();

	public void selectLaptops() {
		find(btnLaptops).click();
		System.out.println("Se seleccionó la categoria Laptops");
		Serenity.takeScreenshot();
	}

	public void selectProduct() {
		find(productMBP).click();
		System.out.println("Se seleccionó el producto MacBook Pro");
		Serenity.takeScreenshot();
	}

	public void addProduct() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnAdd));
        find(btnAdd).click();
		System.out.println("Se hizo clic en el botón Add");
        try {
        	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            System.out.println("Texto de la alerta: " + alertText);
            alert.accept();
            System.out.println("Alerta aceptada.");
            Serenity.takeScreenshot();
        } catch (Exception e) {
            System.out.println("No se detectó la ventana emergente.");
        }
        Serenity.takeScreenshot();
	}

	public void openCart() throws FileNotFoundException, IOException {
		loadProperty.load(new FileReader("./demoblaze.properties"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        find(btnModuleCart).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblProducts));
        String labelProducts = find(lblProducts).getText();
        System.out.println(labelProducts);
        String textLabelProducts = loadProperty.getProperty("textLabelProducts");
        System.out.println(textLabelProducts);
        assertEquals(labelProducts,textLabelProducts);
        System.out.println("El módulo carrito de compras se abrió correctamente");
	}

	public void confirmAdd() {
		String labelProductsAdd = find(lblProductAdd).getText();
        System.out.println(labelProductsAdd);
        String textProductAdd = loadProperty.getProperty("textProductAdd");
        System.out.println(textProductAdd);
        assertEquals(labelProductsAdd,textProductAdd);
        System.out.println("El producto MacBook Pro se agregó correctamente");
        Serenity.takeScreenshot();
	}

}
