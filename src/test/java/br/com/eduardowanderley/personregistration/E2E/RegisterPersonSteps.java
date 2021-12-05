package br.com.eduardowanderley.personregistration.E2E;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPersonSteps {

    private static WebDriver driver;

    @Given("im logged on person registration screen")
    public void goToRegistrationScreen() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login");

        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("user");
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("user");

        driver.findElement(By.id("btn-login")).click();

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("page-message")), "Registration Page"));
    }

    @When("i type my cep on CEP input")
    public void typeCep() {
        WebElement inputCEP = driver.findElement(By.id("cep"));
        inputCEP.sendKeys("40150480");
    }

    @When("i change the input focus")
    public void changeFocus() {
        WebElement inputRua = driver.findElement(By.id("rua"));
        inputRua.click();
    }

    @Then("all the other address inputs would be obtained")
    public void verificarSituacaoAluno() throws InterruptedException {
        Thread.sleep(4000);

        String cep = driver.findElement(By.id("cep")).getAttribute("value");
        String bairro = driver.findElement(By.id("bairro")).getAttribute("value");
        String cidade = driver.findElement(By.id("cidade")).getAttribute("value");
        String uf = driver.findElement(By.id("uf")).getAttribute("value");

        Assert.assertEquals("40150480", cep);
        Assert.assertEquals("Graça", bairro);
        Assert.assertEquals("Salvador", cidade);
        Assert.assertEquals("BA", uf);
    }

    @AfterStory
    public static void teardown() {
        driver.quit();
    }
}
