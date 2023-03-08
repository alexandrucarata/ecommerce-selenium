package pageclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ProductPage extends BasePage {
    Random random;

    @FindBy(css = ".swatch-option.text")
    private List<WebElement> sizeOptions;

    @FindBy(css = ".swatch-option.color")
    private List<WebElement> colorOptions;

    @FindBy(className = "towishlist")
    private WebElement toWishlistBtn;

    @FindBy(id = "product-addtocart-button")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//li[contains(@class, 'item category')][last()]/a")
    private WebElement categoryBtn;

    public ProductPage() {
        super();
        random = new Random();
    }

    public WishlistPage wishlistProduct() {
        toWishlistBtn.click();
        return new WishlistPage();
    }

    public void addProductToCart() {
        chooseRandomSize();
        chooseRandomColor();
        addToCartBtn.click();
    }

    public void chooseRandomSize() {
        WebElement randomSize = sizeOptions.get(random.nextInt(sizeOptions.size() - 1));
        randomSize.click();
    }

    public void chooseRandomColor() {
        WebElement randomColor = colorOptions.get(random.nextInt(colorOptions.size() - 1));
        randomColor.click();
    }

    public StorePage goBackToCategory() {
        categoryBtn.click();
        return new StorePage();
    }
}