package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageWebElements {

   WebDriverWait wait;

    public BasePageWebElements(WebDriver driver) {  //  define a constructor class to identify element to be used
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 10); // this.wait  means object can be call any methed class with Base page
    }

    public void waitForVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickabilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void sendKeys(WebElement element, String keyword) {
        waitForVisibilityOfElement(element);
        element.sendKeys(keyword);
    }

    public void click(WebElement element) {
        waitForClickabilityOfElement(element);
        element.click();
    }

    public void selectByVisibleText(WebElement element, String text) {
        waitForVisibilityOfElement(element);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }


}
