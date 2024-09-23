package steps;

import java.io.FileNotFoundException;
import java.io.IOException;

import net.thucydides.core.annotations.Step;
import pages.addProductPage;

public class addProductSteps {
	
	addProductPage addProductPage;
	
	@Step
	public void selectLaptops() {
		addProductPage.selectLaptops();
	}
	
	@Step
	public void selectProduct() {
		addProductPage.selectProduct();
	}
	
	@Step
	public void addProduct() {
		addProductPage.addProduct();
	}
	
	@Step
	public void openCart() throws FileNotFoundException, IOException {
		addProductPage.openCart();
	}
	
	@Step
	public void confirmAdd() {
		addProductPage.confirmAdd();
	}


}
