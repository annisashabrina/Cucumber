package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class loginSteps {
    public static WebDriver driver;

    @Given("^user go to katalon demo web$")
    public void user_go_to_katalon_demo_web() throws Exception {
        System.setProperty("webdriver.chrome.driver","D:\\SHABRINA\\chromedriver_83.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }

    @When("^user click on login menu on the sidebar$")
    public void user_click_on_login_menu_on_the_sidebar() throws Exception {
        driver.findElement(By.id("menu-toggle")).click();
        driver.findElement(By.partialLinkText("Login")).click();
    }

    @When("^user fill out correct login data$")
    public void user_fill_out_correct_login_data() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^user is in success login page$")
    public void user_is_in_success_login_page() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
