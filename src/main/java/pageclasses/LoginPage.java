package pageclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "pass")
    private WebElement passField;

    @FindBy(id = "send2")
    private WebElement signInBtn;

    public LoginPage() {
        super();
    }

    public LandingPage login(String email, String password) {
        fillEmailField(email);
        fillPasswordField(password);
        clickSignInButton();
        return new LandingPage();
    }

    private void fillEmailField(String email) {
        emailField.sendKeys(email);
    }

    private void fillPasswordField(String password) {
        passField.sendKeys(password);
    }

    private void clickSignInButton() {
        signInBtn.click();
    }
}