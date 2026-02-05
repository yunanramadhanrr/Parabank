package stepDefinitions; // Sesuaikan dengan nama folder Anda

import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class MyStepDef {

    // Memanggil driver yang sudah dinyalakan oleh Hooks
    WebDriver driver = Hooks.driver;

    @Given("User berada di halaman pendaftaran ParaBank")
    public void userIsOnRegistrationPage() {
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
    }

    @And("User mengonfirmasi kata sandi {string}")
    public void userConfirmsPassword(String confirmPass) {
        driver.findElement(By.id("repeatedPassword")).sendKeys(confirmPass);
    }

    @Then("User harus melihat pesan kesalahan {string}")
    public void userShouldSeeErrorMessage(String expectedError) {
        String actualError = driver.findElement(By.id("repeatedPassword.errors")).getText();
        Assert.assertEquals(expectedError, actualError);
    }
}