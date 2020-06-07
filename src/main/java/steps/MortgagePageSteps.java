package steps;

import io.qameta.allure.Step;;
import pages.MortgagePage;
import utils.AllureUtils;
import java.util.Map;
import static org.junit.Assert.assertTrue;

public class MortgagePageSteps {
	@Step("Заполнить поля:")
	public MortgagePageSteps fillFields(Map<String, String> fields) {
		MortgagePage mp = new MortgagePage();
		mp.scrollIntoView(0, 1500);
		mp.waitEnableFrame(mp.getIframe());
		fields.forEach(this::fillField);
		return this;
	}

	@Step("поле {field} заполняется значением {value}")
	private void fillField(String field, String value) {
		new MortgagePage().fillField(field, value);
	}

	@Step("Снять галочку - есть зарплатная карта сбербанка")
	public MortgagePageSteps removeCheckBox() {
		MortgagePage mp = new MortgagePage();
		mp.scrollToElement(mp.getDivBottomFrame());
		mp.clickElement(mp.getSalaryCheckBox());
		return this;
	}

	@Step("дождаться появления 'есть возможность подтвердить доход справкой'")
	public MortgagePageSteps waitApprove() {
		new MortgagePage().confirmIncome();
		return this;
	}

	@Step("поставить галочку 'молодая семья'")
	public MortgagePageSteps updateCheckFamilyBox() {
		MortgagePage mp = new MortgagePage();
		mp.goOutOfFrame();
		mp.scrollToElement(mp.getDivUnderFrame());
		mp.waitEnableFrame(mp.getIframe());
		mp.clickElement(mp.getFamilyDiscount());
		return this;
	}

	@Step("Проверить значение полей:")
	public MortgagePageSteps checkFillFields(Map<String, String> fields) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		fields.forEach(this::checkFillField);
		return this;
	}
	@Step("поле {field} заполнено значением {value}")
	private void checkFillField(String field, String value){
		String actual = new MortgagePage().getFillField(field);
		try {
			assertTrue(
					String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
					actual.equals(value)
			);
		}catch (AssertionError e) {
			AllureUtils.addScreenshot();
			e.printStackTrace();
			throw  new AssertionError(String.format("Значение [%s] поля не соответствует ожидаемому [%s] ",actual,value ));
		}

	}
}
