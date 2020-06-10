package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage extends BasePage {
	@FindBy(xpath = "//button[@aria-label='Меню Ипотека']")
	private WebElement mortgageLink;
	@FindBy(xpath = "//a[contains(text(),'Ипотека на готовое жильё')]")
	private WebElement mortgageRealEstateLink;

	public WebElement getMortgageLink() {
		return mortgageLink;
	}

	public WebElement getMortgageRealEstateLink() {
		return mortgageRealEstateLink;
	}
}
