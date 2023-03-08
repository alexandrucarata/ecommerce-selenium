import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pageclasses.StorePage;
import pageclasses.WishlistPage;
import util.BaseTest;

import static helpers.Constants.*;

@Epic("Luma Store - Wishlist")
@Story("Wishlist Creation")
public class WishlistTest extends BaseTest {

    @BeforeAll
    public static void accessAccount() {
        landingPage = landingPage.clickSignIn().login(EMAIL, PASSWORD);
    }

    @Test
    @Feature("Ability to Add Random Product to Wishlist")
    @AllureId("AP-4.1")
    @Description("Check if random product is successfully added to wishlist")
    public void addRandomProductToWishlistTest() {
        StorePage storePage = landingPage.getNavBar().selectCategory(NEW_CATEGORY);
        WishlistPage wishlistPage = storePage.goToProductPage(RANDOM).wishlistProduct();
        Assertions.assertTrue(wishlistPage.isProductWishlistMsgDisplayed());
    }

    @Test
    @Feature("Ability to Add Product to Wishlist")
    @AllureId("AP-4.2")
    @Description("Check if product is successfully added to wishlist")
    public void addProductToWishlistTest() {
        StorePage storePage = landingPage.getNavBar().selectCategory(MEN_CATEGORY, TOPS_SUB_CATEGORY, TEES_SUB_CATEGORY);
        WishlistPage wishlistPage = storePage.goToProductPage(MEN_TEE).wishlistProduct();
        Assertions.assertTrue(wishlistPage.isProductWishlistMsgDisplayed());
    }

    @AfterEach
    public void goBackToLanding() {
        landingPage.openLandingPage();
    }
}