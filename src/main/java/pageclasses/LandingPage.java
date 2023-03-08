package pageclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.Constants.WEBPAGE;

public class LandingPage extends BasePage {
    @FindBy(css = "li.authorization-link a")
    private WebElement signInBtn;

    @FindBy(css = ".authorization-link + li a")
    private WebElement createAnAccountBtn;

    @FindBy(className = "logged-in")
    private WebElement loggedInMsg;

    @FindBy(className = "switch")
    private WebElement accountMenuBtn;

    @FindBy(css = ".customer-menu li:nth-of-type(1)")
    private WebElement myAccountBtn;

    public LandingPage() {
        super();
    }

    public NavBar getNavBar() {
        return new NavBar();
    }

    public void openLandingPage() {
        driver.get(WEBPAGE);
    }

    public LoginPage clickSignIn() {
        signInBtn.click();
        return new LoginPage();
    }

    public RegisterPage clickCreateAnAccountButton() {
        createAnAccountBtn.click();
        return new RegisterPage();
    }

    public AccountPage clickMyAccountBtn() {
        clickAccountMenuBtn();
        myAccountBtn.click();
        return new AccountPage();
    }

    public boolean isLoggedInMsgDisplayed() {
        return loggedInMsg.isDisplayed();
    }

    public void clickAccountMenuBtn() {
        accountMenuBtn.click();
    }
}