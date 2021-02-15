package codigo;

import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PriceOptionSteps {

	public Metodos me = new Metodos();
	
	/**
	 * SELECT PRICE OPTION
	 */
	
	@Given("^seleciono uma opção$")
	public void seleciono_uma_opção()  {
		me.clicarObjeto(By.id("selectsilver"));
		
	}

	@Then("^clico no nextsendquote$")
	public void clico_no_nextsendquote() throws InterruptedException  {
		me.clicarObjeto(By.id("nextsendquote"));
		Thread.sleep(5000);
	}

}
