package codigo;

import org.openqa.selenium.By;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductDataSteps {

	
	public Metodos me = new Metodos();
	
	/**
	 * PRODUCT
	 */
	
	@Given("^informo a Start Date$")
	public void informo_a_Start_Date()  {
		me.inserirTexto(By.id("startdate"),"05/01/2022");

	}

	@And("^seleciono a Insurance Sum$")
	public void seleciono_a_Insurance_Sum()  {
		me.selecionaCombo(By.id("insurancesum"), "3.000.000,00");
	}

	@When("^seleciono a Merit Rating$")
	public void seleciono_a_Merit_Rating()  {
		me.selecionaCombo(By.id("meritrating"), "Bonus 1");
	    
	}

	@And("^seleciono a Damage Insurance$")
	public void seleciono_a_Damage_Insurance()  {
		me.selecionaCombo(By.id("damageinsurance"), "Full Coverage");
	    
	}

	@And("^seleciono o Optional Products$")
	public void seleciono_o_Optional_Products()  {
		me.clicarObjeto(By.id("EuroProtection"));

	}

	@And("^seleciono o Courtesy Car$")
	public void seleciono_o_Courtesy_Car()  {
		me.selecionaCombo(By.id("courtesycar"), "Yes");
	    
	}

	@Then("^clico no nextselectpriceoption$")
	public void clico_no_nextselectpriceoption() throws InterruptedException  {
		me.clicarObjeto(By.id("nextselectpriceoption"));
		Thread.sleep(5000);
	}

}
