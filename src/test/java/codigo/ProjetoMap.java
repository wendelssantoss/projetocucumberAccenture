package codigo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjetoMap {

	@FindBy(css= "body > div.sweet-alert.showSweetAlert.visible > h2")
	protected WebElement mensagem ;
	@FindBy(css= "body > div.sweet-alert.showSweetAlert.visible > div.sa-button-container > div > button")
	protected WebElement ok;
	protected WebElement firstname;

}
