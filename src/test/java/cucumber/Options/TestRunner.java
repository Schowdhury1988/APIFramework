package cucumber.Options;


        import io.cucumber.junit.Cucumber;
        import io.cucumber.junit.CucumberOptions;
        import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(strict = true,features = "src/test/java/features",plugin = "json:target/jsonReports/cucumber-report.json",glue = {"stepDefinations"})
public class TestRunner {
   // test -Dcucumber.options="--tags@deletePlace"
// tags = "@deletePlace"
}
