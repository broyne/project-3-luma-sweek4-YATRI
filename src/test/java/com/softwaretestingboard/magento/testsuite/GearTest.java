package com.softwaretestingboard.magento.testsuite;

import com.google.common.base.Verify;
import com.softwaretestingboard.magento.pages.GearPage;
import com.softwaretestingboard.magento.pages.MenPage;
import com.softwaretestingboard.magento.testbase.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GearTest extends TestBase {
    GearPage gearPage = new GearPage();
    MenPage menPage = new MenPage();

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        Thread.sleep(2000);
        gearPage.mouseoverToGearAndClickOnBags();
        gearPage.clickOnElement(gearPage.productDuffle);
        // Verify the text ‘Overnight Duffle’
        String expectedText = "Overnight Duffle";
        String actualText = menPage.verifyText(gearPage.productText);
        Assert.assertEquals(actualText, expectedText, "Text not match");
        // Change Qty 3
        gearPage.changeQtyTo3();
        // Click on ‘Add to Cart’ Button.
        gearPage.clickOnElement(gearPage.addToCartButton);
        Thread.sleep(1000);
        // Verify the text ‘You added Overnight Duffle to your shopping cart.’
        expectedText = "You added Overnight Duffle to your shopping cart.";
        actualText = menPage.verifyText(gearPage.shoppingCartText);
        Assert.assertEquals(actualText, expectedText, "Product not added");
        // Click on ‘shopping cart’ Link into message
        gearPage.clickOnElement(gearPage.shoppingCartLink);
        // Verify the product name ‘Overnight Duffle’
        expectedText = "Overnight Duffle";
        actualText = menPage.verifyText(gearPage.overnightDuffleText);
        Assert.assertEquals(actualText, expectedText, "text not match");
        //Verify the Qty is ‘3’Thread.sleep(2000);
        Thread.sleep(2000);
        expectedText = "3";
        actualText = getAttributeValue(gearPage.quantityText, "value");
        Assert.assertEquals(actualText, expectedText, "Value not match");
        // Verify the product price ‘$135.00’
        expectedText = "$135.00";
        actualText = menPage.verifyText(gearPage.priceText);
        Assert.assertEquals(actualText, expectedText, "price not match");
        // Change Qty to ‘5’
        Thread.sleep(2000);
        gearPage.changeQtyTo5();
        Thread.sleep(3000);
        // Click on ‘Update Shopping Cart’ button
        clickOnElement(gearPage.updateShoppingCart);
        Thread.sleep(3000);
        // Verify the product price ‘$225.00’
        expectedText = "$225.00";
        actualText = menPage.verifyText(gearPage.productPrice);
        Assert.assertEquals(actualText, expectedText, "price not equal");
    }
}
