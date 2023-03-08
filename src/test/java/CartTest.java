import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pageclasses.CartPage;
import pageclasses.StorePage;
import util.BaseTest;

import static helpers.Constants.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Luma Store - Cart")
@Story("Shopping Cart")
public class CartTest extends BaseTest {

    @BeforeAll
    public static void accessAccount() {
        landingPage = landingPage.clickSignIn().login(EMAIL, PASSWORD);
    }

    @Test
    @Feature("Cart Pricing Auto-calculation")
    @AllureId("AP-5.1")
    @Description("Check if cart pricing is accurately calculated")
    public void cartPricingTest() {
        int productQuantity = 3;
        StorePage storePage = landingPage.getNavBar()
                .selectCategory(WOMEN_CATEGORY, BOTTOMS_SUB_CATEGORY, PANTS_SUB_CATEGORY);
        storePage.addProductsToCart(productQuantity);
        CartPage cartPage = storePage.getNavBar().goToCart();
        assertAll(
                () -> assertTrue(cartPage.isProductSubtotalValid()),
                () -> assertTrue(cartPage.isCartSubtotalValid()),
                () -> assertTrue(cartPage.isTotalValid())
        );
    }

    @Test
    @Feature("Ability to Add Products to Cart")
    @AllureId("AP-5.2")
    @Description("Check if given number of products are successfully added to cart")
    public void cartQuantityTest() {
        int addedQuantity = 3;
        CartPage cartPage = landingPage.getNavBar().goToCart();
        int initialQuantity = cartPage.getProductQuantity();
        StorePage storePage = cartPage.getNavBar().selectCategory(NEW_CATEGORY);
        storePage.addProductsToCart(addedQuantity);
        cartPage = storePage.getNavBar().goToCart();
        assertTrue(cartPage.isProductQuantityValid(initialQuantity, addedQuantity));
    }

    @AfterEach
    public void goBackToLanding() {
        landingPage.openLandingPage();
    }
}