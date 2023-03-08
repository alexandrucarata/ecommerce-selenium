package pageclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {
    @FindBy(className = "success")
    private WebElement registrationMsg;

    @FindBy(css = ".nav li:nth-of-type(6) a")
    private WebElement addressBookBtn;

    public AccountPage() {
        super();
    }

    public AddressPage clickAddressBookBtn() {
        addressBookBtn.click();
        return new AddressPage();
    }

    public boolean isRegistrationMsgDisplayed() {
        return registrationMsg.isDisplayed();
    }
}