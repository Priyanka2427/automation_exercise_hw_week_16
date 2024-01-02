package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li")
    List<WebElement> headerTabs;

    @CacheLookup
    @FindBy (xpath = "//a[@href='/products']")
    WebElement productsTab;

    @CacheLookup
    @FindBy(xpath = "//li[10]//a[1]")
    WebElement loggedInAsTab;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-image-wrapper']/div/div/p")
    List<WebElement> productList;

    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-default add-to-cart']")
    WebElement addToProductButton;

    @CacheLookup
    @FindBy(xpath = "//u[normalize-space()='View Cart']")
    WebElement viewCartLink;

    @CacheLookup
    @FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
    WebElement accountDeletedMessage;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueButtonAfterAccountDeletedMessage;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Subscription']")
    WebElement subscriptionText;

    @CacheLookup
    @FindBy(xpath = "//input[@id='susbscribe_email']")
    WebElement subscriptionEmail;

    @CacheLookup
    @FindBy(xpath = "//i[@class='fa fa-arrow-circle-o-right']")
    WebElement subscriptionArrowButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert-success alert']")
    WebElement subscriptionSuccessMessage;

    @CacheLookup
    @FindBy (xpath = "//i[@class='fa fa-angle-up']")
    WebElement bottomRightArrowButton;

    @CacheLookup
    @FindBy (xpath = "//div[@class='item active']//h2[contains(text(),'Full-Fledged practice website for Automation Engin')]")
    WebElement fullFledgedText;

    @CacheLookup
    @FindBy (xpath = "//h2[normalize-space()='recommended items']")
    WebElement recommendedItemsText;

    //div[@id = 'recommended-item-carousel']/div/div[2]/div/div/div/div

    @CacheLookup
    @FindBy (xpath = "//div[@id = 'recommended-item-carousel']//div[@class = 'productinfo text-center']/p")
    List<WebElement> recommendedItemsProductsList;

    //div[@id = 'recommended-item-carousel']//div[@class = 'productinfo text-center']/p

    public void clickOnHeaderTab(String option) {
        for (WebElement op : headerTabs) {
            //System.out.println(op.getText());
            if (op.getText().equalsIgnoreCase(option)) {
                op.click();
                log.info("CLicking on " + option + " header tab : " + headerTabs.toString());
                break;
            }
        }
    }

    public String getLoggedInAsUserNameText() {
        log.info("Getting text from login page : " + loggedInAsTab.toString());
        return getTextFromElement(loggedInAsTab);
    }


    public String getAccountDeletedMessage() {
        log.info("Getting account deleted text : " + accountDeletedMessage.toString());
        return getTextFromElement(accountDeletedMessage);
    }

    public void clickOnContinueButtonAfterAccountDeletedMessage() {
        clickOnElement(continueButtonAfterAccountDeletedMessage);
        log.info("Clicking on continue button after deleting account : " + continueButtonAfterAccountDeletedMessage.toString());
    }

    public String getCurrentURL() {
        waitUntilVisibilityOfElementLocated(By.xpath("//h2[normalize-space()='Brands']"), 5);
        log.info("Getting Home page URL : ");
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

//    public void clickOnProductsTabMenu() {
////       clickOnElement(productsTab);
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].click();", productsTab);
//        log.info("Clicking on products tab : " + productsTab.toString());

    public void clickOnProductsTab(){
        clickOnElement(productsTab);
        log.info("Clicking on products tab : " + productsTab.toString());
    }




    public void scrollDownToSubscriptionLink() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView", subscriptionText);
        log.info("Scrolling down to subscription");
    }


    public void sendDataToSubscriptionEmail(String email) {
        sendTextToElement(subscriptionEmail, email);
        log.info("Sending email to subscription email field : " + subscriptionEmail.toString());
    }

    public void clickOnArrowToSubscribe() {
        clickOnElement(subscriptionArrowButton);
        log.info("Clicking on subscription arrow button : " + subscriptionArrowButton.toString());
    }

    public String getSubscriptionSuccessMessage() {
        log.info("Getting subscription success message : " + subscriptionSuccessMessage.toString());
        return getTextFromElement(subscriptionSuccessMessage);
    }

    public void mouseHoverAndClickAddToCartOnProduct(String pName) {
        for (WebElement pr : productList) {
            if (pr.getText().equalsIgnoreCase(pName)) {
                mouseHoverToElement(pr);
                log.info("Hovering mouse over " + pName + " : " + productList.toString());
                try {
                    addToProductButton.click();
                } catch (Exception e) {
                    JavascriptExecutor executor = (JavascriptExecutor) driver;
                    executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@class='btn btn-default add-to-cart']")));
                }
                log.info("Click on " + pName + " Add to Cart button : " + productList.toString());
                break;
            }
        }
    }

    public void clickOnViewCartLink() {
        clickOnElement(viewCartLink);
        log.info("Clicking on view cart link after adding product to the cart : " + viewCartLink.toString());
    }

    public void scrollDownToRecommendedItems() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", recommendedItemsText);
        log.info("Scroll Down to recommended items");
    }

    public void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,0)", "");
        log.info("Scroll up to (0,0)");
    }

    public String getSubscriptionText() {
        log.info("Getting Subscription text : " + subscriptionText.toString());
        return getTextFromElement(subscriptionText);
    }

   public String getFullFledgedText() {
       log.info("Getting full fledged text from top of the page : " + fullFledgedText.toString());
       return getTextFromElement(fullFledgedText);
    }

    public void clickOnBottomRightArrowButton() {
        log.info("Clicking on bottom right corner arrow button : " + bottomRightArrowButton.toString());
        clickOnElement(bottomRightArrowButton);
    }

   public String getRecommendedItemText() {
       log.info("Getting recommended items text : " + recommendedItemsText.toString());
        return getTextFromElement(recommendedItemsText);
    }

    public void clickAddToCartOnRecommendedItems(String pName){
        for (WebElement pr :recommendedItemsProductsList) {
            if(pr.getText().equalsIgnoreCase(pName)) {
                driver.findElement(with(By.xpath("//a[@class='btn btn-default add-to-cart']")).below(pr)).click();
                log.info("Click on " + pName + " Add to Cart button : " + productList.toString());
                break;
            }
        }
    }
}

