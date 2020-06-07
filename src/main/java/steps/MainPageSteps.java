package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainPageSteps {
	@Step("В верхнем меню 'навестись' на Ипотека")
	public MainPageSteps selectMenuItem(){
		MainPage mainPage = new MainPage();
		mainPage.goToElement(mainPage.getMortgageLink());
		return this;
	}
	@Step("выбрать 'Ипотека на готовое жилье'")
	public void selectMenuInsurance(){
		MainPage mainPage = new MainPage();
		mainPage.waitVisibilityOf(mainPage.getMortgageRealEstateLink());
		mainPage.goToElement(mainPage.getMortgageRealEstateLink());
		mainPage.clickElement(mainPage.getMortgageRealEstateLink());
	}
}
