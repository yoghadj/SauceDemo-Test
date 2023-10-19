package cucumber.stepDef;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class Checkout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user access login page")
    public void the_user_is_opening_login_page() {
        WebDriverManager.chromedriver().browserVersion("118.0.5993.70").setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver(opt);
        driver.get(baseUrl);
    }
    @When("user input username {string} and password {string}")
    public void the_user_input_username_and_password(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }
    @And("user login with given username password")
    public void user_login_with_given_username_password() {
        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();
    }
    @And("user redirected to all product page")
    public void user_redirected_to_all_product_page() {
        driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt")).isDisplayed();
    }
    @And("user add product to cart")
    public void user_add_product_to_cart() {
        WebElement button = driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt"));
        button.click();
    }
    @And("user click cart")
    public void user_click_cart() {
        WebElement button = driver.findElement(By.className("shopping_cart_link"));
        button.click();
    }
    @And("user redirected to cart page")
    public void user_redirected_to_cart_page() {
        driver.findElement(By.name("remove-sauce-labs-bolt-t-shirt")).isDisplayed();
    }
    @And("user click checkout button")
    public void user_click_checkout_button() {
        WebElement button = driver.findElement(By.name("checkout"));
        button.click();
    }
    @And("user redirected to input form")
    public void user_redirected_to_input_form() {
        driver.findElement(By.name("firstName")).isDisplayed();
    }
    @And("user input first name {string} last name {string} and postal code {string}")
    public void the_user_input_username_and_password(String fName, String lName,String postal) {
        WebElement fNameField = driver.findElement(By.id("first-name"));
        WebElement lNameField = driver.findElement(By.id("last-name"));
        WebElement postalField = driver.findElement(By.id("postal-code"));
        fNameField.sendKeys(fName);
        lNameField.sendKeys(fName);
        postalField.sendKeys(postal);
    }
    @And("user click continue button")
    public void user_click_continue_button() {
        WebElement button = driver.findElement(By.name("continue"));
        button.click();
    }
    @And("user redirected to checkout overview page")
    public void user_redirected_to_checkout_overview_page() {
        driver.findElement(By.name("finish")).isDisplayed();
    }
    @And("user click finish button")
    public void user_click_finish_button() {
        WebElement button = driver.findElement(By.name("finish"));
        button.click();
    }
    @Then("user redirect to thank you page")
    public void user_redirect_to_thank_you_page() {
        driver.findElement(By.name("back-to-products")).isDisplayed();

        driver.quit();
    }
}
