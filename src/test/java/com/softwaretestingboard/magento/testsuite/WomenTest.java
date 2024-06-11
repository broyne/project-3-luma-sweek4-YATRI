package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.pages.WomenPage;
import com.softwaretestingboard.magento.testbase.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * verifyTheSortByProductNameFilter
 * * Mouse Hover on Women Menu
 * * Mouse Hover on Tops
 * * Click on Jackets
 * * Select Sort By filter “Product Name”
 * * Verify the products name display in
 * alphabetical order
 */
public class WomenTest extends TestBase {
    WomenPage womenPage = new WomenPage();
    public void selectMenu(String menuName) {
        // Click on element
        womenPage.clickOnMenu(menuName);
    }
    @Test
    public void verifyTheSortByProductNameFilter() {
        //Mouse Hover on Women Menu and Mouse Hover on Tops
        String menuName = "Women";
        selectMenu(menuName);
        //Select Sort By filter “Product Name”
        womenPage.selectOption();
        //Verify the products name display in alphabetical order

        List<String> actualProductNames = womenPage.verifyProductOrder();
        List<String> expectedProductNames = womenPage.reverseProductOrder(actualProductNames);
        Assert.assertEquals(actualProductNames,expectedProductNames);
    }
    @Test
    public void verifyTheSortByPriceFilter(){
        /*
        * Mouse Hover on Women Menu
        * Mouse Hover on Tops
        * Click on Jackets
        * Select Sort By filter “Price”
        * Verify the products price display in
        Low to High
         */
        String menuName = "Women"; // Example menu item
        selectMenu(menuName);
        //Select Sort By filter “Product Name”
        womenPage.selectOptionPrice();
        womenPage.pricedisplay();
    }
}
