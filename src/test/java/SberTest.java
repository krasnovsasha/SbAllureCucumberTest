import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.BaseSteps;
import steps.MainPageSteps;
import steps.MortgagePageSteps;
import java.util.LinkedHashMap;

public class SberTest {
	private MainPageSteps mainPageSteps = new MainPageSteps();
	private MortgagePageSteps mortgagePageSteps = new MortgagePageSteps();
	@Before
	public void setUp() {
		BaseSteps.setUp();
	}
	@Test
	@Flaky
	@Owner(value = "Александр Краснов")
	@Link(name = "Ссылка на статью на хабре по аннотациям Allure", url = "https://habr.com/ru/company/sberbank/blog/359302/")
	@DisplayName("Расчет ипотечного кредита")
	@Description(value = "Тестовая проверка в рамках изучения инструментов Allure и Cucumber")
	@Feature(value = "Тестирование функциональности")
	public void mainFunctionalTest () {
		mainPageSteps
					.selectMenuItem()
					.selectMenuInsurance();

		mortgagePageSteps
					.fillFields(new LinkedHashMap<String, String>() {{
						put("Стоимость", "5180000");
						put("Взнос", "3058000");
						put("Срок", "30");
					}}
					)
					.removeCheckBox()
					.waitApprove()
					.updateCheckFamilyBox()
					.checkFillFields(
						new LinkedHashMap<String, String>() {{
							put("Сумма кредита", "2 122 000 ₽");
							put("Ежемесячный платеж", "16 467 ₽");
							put("Необходимый доход", "27 445 ₽");
							put("Процентная ставка", "11%");
						}}
				);
	}
	@After
	public void tearDown(){
		BaseSteps.tearDown();
	}
}
