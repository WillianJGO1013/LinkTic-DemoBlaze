package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"definitions"},
		monochrome = true,
        snippets = SnippetType.CAMELCASE,
		tags = "@registro_Usuario, @login_Usuario, @formulario_Contacto, @seleccion_Producto"
		)

public class RunnerFeatures {

}
