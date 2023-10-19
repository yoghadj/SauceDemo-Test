package cucumber.stepDef;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class RemoveAddedProduct {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("the user access login page")
    public void the_user_access_login_page() {
        WebDriverManager.chromedriver().browserVersion("118.0.5993.70").setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver(opt);
        driver.get(baseUrl);
    }
    @When("the user enter {string} and {string} for username password")
    public void the_user_enters_for_username_password(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }
    @And("the user logins")
    public void user_logins() {
        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();
    }
    @And("user redirected to product list")
    public void user_redirected_to_product_list() {
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).isDisplayed();
    }
    @And("user add product")
    public void user_add_product() {
        WebElement button = driver.findElement(By.name("add-to-cart-sauce-labs-bike-light"));
        button.click();
    }
    @And("user view the product added to cart")
    public void user_view_the_product_added_to_cart() {

        driver.findElement(By.name("remove-sauce-labs-bike-light")).isDisplayed();
    }
    @And("user click remove button for added product")
    public void user_click_remove_button_for_added_product() {
        WebElement button = driver.findElement(By.name("remove-sauce-labs-bike-light"));
        button.click();
    }
    @Then("product back to first state")
    public void product_back_to_first_state() {
//        WebElement cart_number = driver.findElement(By.className("shopping_cart_badge"));

        driver.quit();
    }
}
