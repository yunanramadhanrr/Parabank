package MyStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import java.util.Map;
import java.util.List;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyStepDef {

    WebDriver driver = Hooks.driver;

    @Given("User berada di halaman pendaftaran ParaBank")
    public void user_berada_di_halaman_pendaftaran_parabank() {
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
    }

    @Given("User berada di halaman utama ParaBank")
    public void user_berada_di_halaman_utama_parabank() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @When("User memasukkan data diri berikut:")
    public void user_memasukkan_data_diri_berikut(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        driver.findElement(By.id("customer.firstName")).sendKeys(data.get(0).get("namaDepan"));
        driver.findElement(By.id("customer.lastName")).sendKeys(data.get(0).get("namaBelakang"));
        driver.findElement(By.id("customer.address.street")).sendKeys(data.get(0).get("alamat"));
        driver.findElement(By.id("customer.address.city")).sendKeys(data.get(0).get("kota"));
        driver.findElement(By.id("customer.address.state")).sendKeys(data.get(0).get("provinsi"));
        driver.findElement(By.id("customer.address.zipCode")).sendKeys(data.get(0).get("kodePos"));
        driver.findElement(By.id("customer.ssn")).sendKeys(data.get(0).get("ssn"));
    }

    @And("User memasukkan username {string} dan kata sandi {string}")
    public void user_memasukkan_username_dan_kata_sandi_universal(String username, String password) {
        if (driver.findElements(By.id("customer.username")).size() > 0) {
            driver.findElement(By.id("customer.username")).sendKeys(username);
            driver.findElement(By.id("customer.password")).sendKeys(password);
        } else {
            driver.findElement(By.name("username")).sendKeys(username);
            driver.findElement(By.name("password")).sendKeys(password);
        }
    }

    @And("User mengonfirmasi kata sandi {string}")
    public void user_mengonfirmasi_kata_sandi(String confirmPass) {
        driver.findElement(By.id("repeatedPassword")).sendKeys(confirmPass);
    }

    @And("User klik tombol Daftar")
    public void user_klik_tombol_daftar() {
        driver.findElement(By.cssSelector("input[value='Register']")).click();
    }

    @And("User klik tombol Log In")
    public void user_klik_tombol_login() {
        driver.findElement(By.cssSelector("input[value='Log In']")).click();
    }

    @Then("User harus melihat pesan sukses {string}")
    public void user_harus_melihat_pesan_sukses(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + expectedMessage + "')]")));
        Assert.assertTrue(msg.isDisplayed());
    }

    @Then("User harus diarahkan ke halaman {string}")
    public void user_harus_diarahkan_ke_halaman(String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
        Assert.assertEquals(expectedTitle, titleElement.getText().trim());
    }

    @Then("User harus melihat pesan kesalahan {string}")
    public void user_harus_melihat_pesan_kesalahan(String expectedError) {
        String actualError = "";
        // Cek pesan error registrasi (id) atau login (class/tag)
        if (driver.findElements(By.id("repeatedPassword.errors")).size() > 0) {
            actualError = driver.findElement(By.id("repeatedPassword.errors")).getText();
        } else if (driver.findElements(By.className("error")).size() > 0) {
            actualError = driver.findElement(By.className("error")).getText();
        } else {
            actualError = driver.findElement(By.cssSelector("#rightPanel p")).getText();
        }
        Assert.assertTrue("Error tidak sesuai. Ditemukan: " + actualError, actualError.contains(expectedError));
    }
}