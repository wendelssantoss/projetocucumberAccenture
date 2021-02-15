package codigo;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
// src/test/java/projeto.feature
@RunWith (Cucumber.class) 
@CucumberOptions ( 
features =  "classpath: features", 
glue =  { "codigo" }, monochrome = true, dryRun = false, tags = "@regressao"
)

public class ProjetoTestes {


}
