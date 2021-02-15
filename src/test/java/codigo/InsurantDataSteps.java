package codigo;

import org.openqa.selenium.By;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import metodosauxiliares.LeitorExcel;

public class InsurantDataSteps {

	public Metodos me = new Metodos();
	public LeitorExcel massa = new LeitorExcel();
	
	/**
	 * INSURANT DATA
	 * @throws InterruptedException 
	 */

	@Given("^informo o First Name$")
	public void informo_o_First_Name() throws InterruptedException  {
		me.inserirTexto(By.id("firstname"),"teste");
	    
	}
	@And("^informo o Last Name$")
	public void informo_o_Last_Name()  {
		me.inserirTexto(By.id("lastname"),"teste");
	    
	}
	@And("^informo a Birth Date$")
	public void informo_a_Birth_Date()  {
		me.inserirTexto(By.id("birthdate"),"01/02/1974");
	    
	}
	@When("^seleciono o Gender$")
	public void seleciono_o_Gender()  {
		me.clicarObjeto(By.id("gendermale"));
	    
	}

	@And("^seleciono o Country$")
	public void seleciono_o_Country()  {
		me.selecionaCombo(By.id("country"),"Brazil");
	    
	}

	@And("^informo o Zip Code$")
	public void informo_o_Zip_Code()  {
		me.inserirTexto(By.id("zipcode"),"71070400");
	    
	}

	@And("^informo a Occupation$")
	public void informo_a_Occupation()  {
		me.inserirTexto(By.id("occupation"),"Public Official");
	    
	}

	@And("^seleciono o Hobbies$")
	public void seleciono_o_Hobbies()  {
		me.clicarObjeto(By.id("speeding"));
	    
	}

	@Then("^clico no nextenterproductdata$")
	public void clico_no_nextenterproductdata() throws InterruptedException  {
		me.clicarObjeto(By.id("nextenterproductdata"));
		Thread.sleep(5000);
	    
	}

}
