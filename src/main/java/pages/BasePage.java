package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import steps.BaseSteps;

abstract class BasePage {
	public BasePage() {
		PageFactory.initElements(BaseSteps.getDriver(), this);
	}

	public void clickElement(WebElement element) {
		BaseSteps.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public void waitVisibilityOf(WebElement element) {
		BaseSteps.wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitEnableFrame(WebElement element) {
		BaseSteps.wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

	public void waitUntilClickable(WebElement element) {
		BaseSteps.wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void goToElement(WebElement element) {
		Actions actions = new Actions(BaseSteps.getDriver());
		actions.moveToElement(element).perform();
	}

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) BaseSteps.getDriver();
		js.executeScript("arguments[0].scrollIntoView(false);", element);
	}

	public void scrollIntoView(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) BaseSteps.getDriver();
		js.executeScript("window.scrollBy(" + x + "," + y + ")", "");
	}

	public void clearField(WebElement element) {
		waitUntilClickable(element);
		element.clear();
		while (element.getText().length() > 0) {
			element.sendKeys(Keys.BACK_SPACE);
		}
	}

	public void goOutOfFrame() {
		BaseSteps.getDriver().switchTo().defaultContent();
	}
}
