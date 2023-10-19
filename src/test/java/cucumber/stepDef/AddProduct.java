package cucumber.stepDef;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddProduct {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("the user is opening login page")
    public void the_user_is_opening_login_page() {
        WebDriverManager.chromedriver().browserVersion("118.0.5993.70").setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver(opt);
        driver.get(baseUrl);
    }
    @When("the user enter username {string} and password {string}")
    public void the_user_enters_username_and_password(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }
    @And("the user clicks the login button")
    public void clicks_the_login_button() {
        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();
    }
    @And("user redirected to homepage")
    public void user_redirect_to_homepage() {
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).isDisplayed();
    }
    @And("user click add button for product")
    public void user_click_add_button_for_product() {
        WebElement button = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        button.click();
    }
    @Then("number in cart should change")
    public void number_in_cart_should_change() {
//        WebElement cart_number = driver.findElement(By.className("shopping_cart_badge"));

        driver.quit();
    }
}
