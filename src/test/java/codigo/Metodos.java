package codigo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Metodos {

	public WebDriver driver;
	
	public void selecionaCombo(By by, String texto) {
		new Select(driver.findElement(by)).selectByVisibleText(texto);
	}
	public void clicarObjeto(By by) {
		driver.findElement(by).click();
	}
	public void inserirTexto(By by, String texto) {
		driver.findElement(by).sendKeys(texto);
	}
	 /**
	    * CLICA EM UM OBJETO PASSANDO COMO PARAMETRO COMANDOS JAVASCRIPT
	    * Ex.:clicarObjetoJS("passa o by do objeto", "passa o comando JS")
	    * @param by
	    * @param JS
	    */
		public void inserirTextoJS(By by, String JS) {
			
			WebElement texto = driver.findElement(by);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript(JS, texto);
		}

}
