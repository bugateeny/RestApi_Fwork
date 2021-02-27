package step_Definitions;

import base_Web.BaseUtil;
import io.cucumber.java.en.Given;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class web_StepDefinitions extends BaseUtil {


    public web_StepDefinitions() {
    }


    @Given("your are connected to server")
    public void your_are_connected_to_server()  {
//         Write code here that turns the phrase above into concrete actions
//        base.driver.navigate().to("http://192.168.132.176:54040/api.vixen/swagger-ui.html");

//        PropertiesReader propertiesReader = new PropertiesReader();
//        base.driver.get(PropertiesReader.getSwaggerPage());

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://192.168.132.176:54040/api.vixen/swagger-ui.html");
        driver.manage().window().maximize();
        Assert.assertEquals("Swagger UI", driver.getTitle());

    }

}
