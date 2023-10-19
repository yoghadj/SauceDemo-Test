package cucumber.stepDef;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class Login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        WebDriverManager.chromedriver().browserVersion("118.0.5993.70").setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver(opt);
        driver.get(baseUrl);
    }
    @When("the user enters valid {string} as username")
    public void the_user_enters_valid_as_username(String username) {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys(username);
    }
    @And("the user enters valid {string} as password")
    public void the_user_enters_valid_as_password(String password) {
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
    }
    @And("clicks the login button")
    public void clicks_the_login_button() {
        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();
    }
    @Then("the user should got the result {string}")
    public void the_user_should_got_the_result(String status) {
        // Add assertions here to verify successful login
        System.out.println(status);
        driver.quit();
    }
}
