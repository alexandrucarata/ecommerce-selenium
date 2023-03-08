package pageclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends BasePage {

    @FindBy(className = "message-success")
    private WebElement productWishlistMsg;

    public WishlistPage() {
        super();
    }

    public boolean isProductWishlistMsgDisplayed() {
        return productWishlistMsg.isDisplayed();
    }
}