package com.softwaretestingboard.magento.pages;

import com.softwaretestingboard.magento.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenPage extends Utility {

    public By sortBy = By.id("sorter");
    By productName=By.xpath("//strong[@class = 'product name product-item-name']");
    By price_list= By.xpath("//span//span[@class = 'price']");
    public By generateMenuLink(String menu){
        mouseHoverToElement(By.xpath("//span[normalize-space()='" +menu+"']"));
        mouseHoverToElement(By.id("ui-id-9"));
        By menuLink = By.id("ui-id-11");
        return menuLink;
    }

    public void clickOnMenu(String menuName){
        By menuLink = generateMenuLink(menuName);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        clickOnElement(menuLink);
    }
    public void selectOption(){
        selectByVisibleTextFromDropDown(sortBy, "Product Name");
    }
    public List<String> verifyProductOrder(){
        List<String> actualProductNames = new ArrayList<>();
        for (WebElement productName : ListOfWebElements(productName)) {
            actualProductNames.add(productName.getText());
        }
        //System.out.println(actualProductNames);
        return actualProductNames;
    }
    public List<String> reverseProductOrder(List<String> actualProductNames){
        List<String> expectedProducts = new ArrayList<>(actualProductNames);
        expectedProducts.sort(Collections.reverseOrder());
        actualProductNames.sort(Collections.reverseOrder());
        return expectedProducts;
    }
    public void selectOptionPrice(){
        selectByVisibleTextFromDropDown(sortBy, "Price");
    }
    public void pricedisplay() {

        for (WebElement element : ListOfWebElements(price_list)) {
            System.out.println(element.getText());
        }
    }

}
