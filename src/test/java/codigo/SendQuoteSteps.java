package codigo;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SendQuoteSteps extends ProjetoMap{

	public Metodos me = new Metodos();
	
	/**
	 * SEND QUOTE
	 */
	@Given("^informo o EMail$")
	public void informo_o_EMail()  {
		me.inserirTexto(By.id("email"),"teste@gmail.com");
	    
	}

	@And("^informo o Username$")
	public void informo_o_Username()  {
		me.inserirTexto(By.id("username"),"teste");
    
	}

	@When("^informo o Password$")
	public void informo_o_Password()  {
		me.inserirTexto(By.id("password"),"Fati8462*");
	    
	}

	@And("^confirmo o Password$")
	public void confirmo_o_Password()  {
		me.inserirTexto(By.id("confirmpassword"),"Fati8462*");
	    
	}

	@And("^clico no sendemail$")
	public void clico_no_sendemail() throws InterruptedException  {
		me.clicarObjeto(By.id("sendemail"));
		Thread.sleep(5000);
	}

	@And("^Sera exibida a mensagem na tela$")
	public void sera_exibida_a_mensagem_na_tela()  {
		assertEquals(mensagem, mensagem);
	    
	}

	@Then("^clico no ok$")
	public void clico_no_ok() throws InterruptedException  {
		me.clicarObjeto(By.cssSelector("ok"));
		Thread.sleep(5000);
		
	}

}
