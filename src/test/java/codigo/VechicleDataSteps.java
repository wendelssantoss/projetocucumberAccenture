package codigo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VechicleDataSteps extends ProjetoMap{

	public Metodos me = new Metodos();
	
	
	@Given("^estou na pagina inicial$")
	public void estou_na_pagina_inicial()  {
			
		System.setProperty("webdriver.chrome.driver", "..\\projetocucumber\\Drivers\\chromedriver.exe");
		me.driver = new ChromeDriver();
		me.driver.manage().window().maximize();
		me.driver.get("http://sampleapp.tricentis.com/101/app.php");
		
	}
	/**
	 * ENTER VEHICLE DATA
	 */
	@And("^seleciono o make")
	public void seleciono_o_make()  {
		me.selecionaCombo(By.id("make"),"Ford");
		
	}
	@And("^seleciono o model")
	public void seleciono_o_model()  {
		me.selecionaCombo(By.id("model"),"Scooter");
		
	}
	@And("^informo o cylindercapacity$")
	public void informo_o_cylindercapacity()  {
		me.inserirTexto(By.id("cylindercapacity"),"100");
	    
	}
	@And("^informo os dados do Engine Performance$")
	public void informo_os_dados_do_Engine_Performance()  {
		me.inserirTexto(By.id("engineperformance"),"100");
	    
	}

	@And("^seleciono a Date of Manufacture$")
	public void seleciono_a_Date_of_Manufacture()  {
		me.inserirTexto(By.id("dateofmanufacture"),"08/02/2020");
		
	}

	@When("^seleciono o Number of Seats$")
	public void seleciono_o_Number_of_Seats() throws InterruptedException  {
		Thread.sleep(5000);
			me.selecionaCombo(By.id("numberofseats"),"2");
	}
	@And("^seleciono o Number of Seats2$")
	public void seleciono_o_Number_of_Seats2()  {
		me.selecionaCombo(By.id("numberofseatsmotorcycle"),"2");
	    
	}
	@And("^seleciono o Fuel Type$")
	public void seleciono_o_Fuel_Type()  {
		me.selecionaCombo(By.id("fuel"),"Diesel");
	    
	}
	@And("^informo o Payload$")
	public void informo_o_Payload()  {
		me.inserirTexto(By.id("payload"),"10");
	    
	}
	@And("^informo o Total Weight$")
	public void informo_o_Total_Weight()  {
		me.inserirTexto(By.id("totalweight"),"100");
	    
	}
	@And("^informo o List Price$")
	public void informo_o_List_Price()  {
		me.inserirTexto(By.id("listprice"),"1500");
	    
	}
	@And("^informo o Annual Mileage$")
	public void informo_o_Annual_Mileage()  {
		me.inserirTexto(By.id("annualmileage"),"1500");
	    
	}

	@Then("^clico no nextInsurant$")
	public void clico_no_nextInsurant() throws InterruptedException  {
		Thread.sleep(1000);
		me.clicarObjeto(By.id("enterinsurantdata"));
	   
	   
	}
}
