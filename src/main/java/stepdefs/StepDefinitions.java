package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.MainPageSteps;
import steps.MortgagePageSteps;

public class StepDefinitions {

    private MainPageSteps mainPageSteps = new MainPageSteps();
    private MortgagePageSteps mortgagePageSteps = new MortgagePageSteps();

    @When("В верхнем меню выбрана Ипотека")
    public void selectMenuItem(){
        mainPageSteps.selectMenuItem();
    }

    @When("выбрана 'Ипотека на готовое жилье'")
    public void selectMenuInsurance(){
        mainPageSteps.selectMenuInsurance();
    }

    @When("заполняются поля:")
    public void fillApplicationForm(DataTable fields){
		mortgagePageSteps.fillFields(
                fields.asMap(String.class, String.class)
        );
    }

	@When("Снять галочку - есть зарплатная карта сбербанка")
	public void removeCheckBox (){
		mortgagePageSteps.removeCheckBox();
	}

	@When("дождаться появления 'есть возможность подтвердить доход справкой'")
	public void waitApprove (){
		mortgagePageSteps.waitApprove();
	}


	@When("поставить галочку 'молодая семья'")
	public void updateCheckFamilyBox(){
		mortgagePageSteps.updateCheckFamilyBox();
	}

	@Then("значения полей равны:")
    public void checkApplicationFormFilled(DataTable fields){
		mortgagePageSteps.checkFillFields(
                fields.asMap(String.class, String.class)
        );
    }
}
