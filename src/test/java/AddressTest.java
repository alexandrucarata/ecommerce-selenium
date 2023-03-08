import helpers.Address;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pageclasses.AccountPage;
import pageclasses.AddressPage;
import util.BaseTest;

import static helpers.Constants.EMAIL;
import static helpers.Constants.PASSWORD;

@Epic("Luma Store - Account")
@Story("Address Configuration")
public class AddressTest extends BaseTest {

    @BeforeAll
    public static void accessAccount() {
        landingPage = landingPage.clickSignIn().login(EMAIL, PASSWORD);
    }

    @Test
    @Feature("Ability to Add New Address")
    @AllureId("AP-3")
    @Description("Check if new address is successfully added")
    public void addNewAddressTest() {
        AccountPage accountPage = landingPage.clickMyAccountBtn();
        AddressPage addressPage = accountPage.clickAddressBookBtn();
        addressPage.addNewAddress(new Address().createFakeAddress());
        Assertions.assertTrue(addressPage.isAddressSavedMsgDisplayed());
    }
}