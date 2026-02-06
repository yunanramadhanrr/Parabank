package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Lokasi folder .feature
        glue = "MyStepDef",                // Nama folder StepDef & Hooks
        plugin = {
                "pretty",
                "html:target/cucumber-report.html", // Untuk laporan dalam bentuk website
                "json:target/cucumber.json"         // Untuk data laporan mentah
        },
        monochrome = true // Membuat tampilan console lebih bersih (tidak ada karakter aneh)
)
public class TestRunner {
}