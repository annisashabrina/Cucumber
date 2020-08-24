package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddProductToCartSteps {
    private String productTitle;
    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductTitle() {
        return this.productTitle;
    }

    WebDriver driver;
    @Given("customer has logged in")
    public void customerHasLoggedIn() {
        System.setProperty("webdriver.chrome.driver","D:\\SHABRINA\\chromedriver_84.exe");
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,30);

        driver.get("https://www.bhinneka.com/");
        driver.findElement(By.partialLinkText("Login")).click();

        driver.findElement(By.cssSelector("#email")).sendKeys("sho.brina@gmail.com");
        driver.findElement(By.cssSelector("#next")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
        driver.findElement(By.cssSelector("#password")).sendKeys("Shobrina290993!");
        driver.findElement(By.cssSelector(".ant-btn.ant-btn-primary")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".bt-search-suggestion__input")));
    }

    @When("^customer searched \"([^\"]*)\" product$")
    public void customerSearchedProduct(String keyword) {
        List<WebElement> searchDiv = driver.findElements(By.cssSelector(".bt-search-suggestion__input"));
        searchDiv.get(1).sendKeys(keyword + Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#queryTitle")));
    }

    @And("customer add first item to the cart")
    public void customerAddFirstItemToTheCart() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.row")));
        List<WebElement> rowItem = driver.findElements(By.cssSelector("a.row"));
        List<WebElement> itemTitle = driver.findElements(By.cssSelector("div.bt-product-catalog-item__title > p"));
        String rowTitle = itemTitle.get(1).getText();
        setProductTitle(rowTitle);
        rowItem.get(1).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-primary.btn-xl")));
        driver.findElement(By.cssSelector(".btn.btn-primary.btn-xl")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#goToCart")));
        driver.findElement(By.cssSelector("#goToCart")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bt-typo-displaylarge")));
    }

    @Then("product has been submitted to the cart")
    public void productHasBeenSubmittedToTheCart() {
        driver.findElement(By.xpath("//a[contains(text(),'" + getProductTitle() +"')]"));
    }
}
