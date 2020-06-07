package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MortgagePage extends BasePage {
	@FindBy(xpath = "//iframe[@id='iFrameResizer0']")
	private WebElement iframe;
	@FindBy(id = "estateCost")
	private WebElement inputEstateCost;
	@FindBy(id = "initialFee")
	private WebElement initialFee;
	@FindBy(id = "creditTerm")
	private WebElement creditTerm;
	@FindBy(xpath = "//div[div[text()='Есть зарплатная карта Сбербанка']]//label")
	private WebElement salaryCheckBox;
	@FindBy(xpath = "//div[@class=\"dcCalc_switch-tablet__title\" and contains(text(),'Есть возможность подтвердить доход справкой')]/parent::div")
	private WebElement approveIncome;
	@FindBy(xpath = "//div[@class='dcCalc_disclaimer']")
	private WebElement divBottomFrame;
	@FindBy(xpath = "//h2[contains(text(),'подать заявку')]")
	private WebElement divUnderFrame;
	@FindBy(xpath = "//div[div[text()='Молодая семья']]//label")
	private WebElement familyDiscount;
	@FindBy(xpath = "//span[@data-test-id='amountOfCredit']")
	private WebElement amountOfCredit;
	@FindBy(xpath = "//span[@data-test-id='monthlyPayment']")
	private WebElement monthlyPayment;
	@FindBy(xpath = "//span[@data-test-id='requiredIncome']")
	private WebElement requiredIncome;
	@FindBy(xpath = "//span[@data-test-id='rate']")
	private WebElement rate;

	public WebElement getFamilyDiscount() {
		return familyDiscount;
	}

	public WebElement getDivBottomFrame() {
		return divBottomFrame;
	}

	public WebElement getDivUnderFrame() {
		return divUnderFrame;
	}

	public WebElement getSalaryCheckBox() {
		return salaryCheckBox;
	}

	public MortgagePage() {
		PageFactory.initElements(BaseSteps.getDriver(), this);
	}

	public WebElement getIframe() {
		return iframe;
	}

	private void fillField(WebElement element, String value) {
		waitUntilClickable(element);
		clearField(element);
		clickElement(element);
		element.sendKeys(value);
	}

	public void fillField(String fieldName, String value) {
		switch (fieldName) {
			case "Стоимость":
				fillField(inputEstateCost, value);
				break;
			case "Взнос":
				fillField(initialFee, value);
				break;
			case "Срок":
				fillField(creditTerm, value);
				break;
		}
	}

	public String getFillField(String fieldName){
		switch (fieldName){
			case  "Сумма кредита":
				waitVisibilityOf(amountOfCredit);
				return amountOfCredit.getText();
			case  "Ежемесячный платеж":
				waitVisibilityOf(monthlyPayment);
				return monthlyPayment.getText();
			case  "Необходимый доход":
				waitVisibilityOf(requiredIncome);
				return requiredIncome.getText();
			case  "Процентная ставка":
				waitVisibilityOf(rate);
				return rate.getText();
		}
		throw new AssertionError("Поле не найдено на странице");
	}

	public boolean confirmIncome() {
		return approveIncome.isEnabled();
	}
}
