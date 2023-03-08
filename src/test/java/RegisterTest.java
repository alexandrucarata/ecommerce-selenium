import helpers.User;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageclasses.AccountPage;
import pageclasses.RegisterPage;
import util.BaseTest;

@Epic("Luma Store - Account")
@Story("Account Registration")
public class RegisterTest extends BaseTest {

    @Test
    @Feature("Ability to Register New User")
    @AllureId("AP-1")
    @Description("Check if new user is successfully registered")
    public void registerUserTest() {
        RegisterPage registerPage = landingPage.clickCreateAnAccountButton();
        AccountPage accountPage = registerPage.registerAccount(new User().createFakeUser());
        Assertions.assertTrue(accountPage.isRegistrationMsgDisplayed());
    }
}