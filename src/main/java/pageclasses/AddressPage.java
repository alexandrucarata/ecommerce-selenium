package pageclasses;

import helpers.Address;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddressPage extends BasePage {

    @FindBy(id = "telephone")
    private WebElement phoneNumberField;

    @FindBy(id = "street_1")
    private WebElement streetAddressField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "region_id")
    private WebElement stateList;

    @FindBy(id = "zip")
    private WebElement zipCodeField;

    @FindBy(id = "country")
    private WebElement countryList;

    @FindBy(className = "save")
    private WebElement saveAddressBtn;

    @FindBy(className = "add")
    private WebElement addNewAddressBtn;

    @FindBy(className = "message-success")
    private WebElement addressSavedMsg;

    public AddressPage() {
        super();
    }

    public void addNewAddress(Address address) {
        if (isAddNewAddressBtnDisplayed()) {
            addNewAddressBtn.click();
        }
        fillAddressFields(address);
        saveAddressBtn.click();
    }

    public void fillAddressFields(Address address) {
        phoneNumberField.sendKeys(address.getPhoneNumber());
        streetAddressField.sendKeys(address.getStreetAddress());
        cityField.sendKeys(address.getCity());
        Select countrySelect = new Select(countryList);
        countrySelect.selectByValue(address.getCountry());
        Select stateSelect = new Select(stateList);
        stateSelect.selectByVisibleText(address.getState());
        zipCodeField.sendKeys(address.getZipCode());
    }

    public boolean isAddNewAddressBtnDisplayed() {
        return addNewAddressBtn.isDisplayed();
    }

    public boolean isAddressSavedMsgDisplayed() {
        return addressSavedMsg.isDisplayed();
    }
}