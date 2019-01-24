package maven.cucumber.testing.TeaTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkout {

	@FindBy(xpath = "//*[@id=\"email\"]")
	private WebElement email;
	
	@FindBy(xpath = "//*[@id=\"name\"]")
	private WebElement name;
	
	@FindBy(xpath = "//*[@id=\"address\"]")
	private WebElement address;
	
//	@FindBy(xpath = "//*[@id=\"card_type\"]")
//	private WebElement cardType;
//	Select dropdown = new Select(cardType);
	
	@FindBy(xpath = "//*[@id=\"card_number\"]")
	private WebElement cardNum;
	
	@FindBy(xpath = "//*[@id=\"cardholder_name\"]")
	private WebElement cardholderName;
	
	@FindBy(xpath = "//*[@id=\"verification_code\"]")
	private WebElement verCode;
	
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]/div/div/form/div/button")
	private WebElement placeOrderButton;
	
	
	
	public void fillForm(){
		email.sendKeys("charlottehoy1995@hotmail.co.uk");
		name.sendKeys("Minal");
		address.sendKeys("20 Tunfield Road");
		//dropdown.selectByVisibleText("Visa");
		cardNum.sendKeys("12345678");
		cardholderName.sendKeys("MINAL");
		verCode.sendKeys("769");
		placeOrderButton.click();
		
	}
	
	
}
