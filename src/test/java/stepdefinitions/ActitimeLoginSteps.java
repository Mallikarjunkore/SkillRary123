package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ActitimeLoginSteps {
	private WebDriver driver;
	ChromeOptions option=new ChromeOptions();
	
	@Given("Launch browser and enter actitime url")
	public void launch_browser_and_enter_actitime_url() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver(option);
	    driver.manage().window().maximize();
	    driver.get("https://demo.actitime.com/login.do");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("login credentials are entered")
	public void login_credentials_are_entered() {
	
	   driver.findElement(By.id("username")).sendKeys("admin");
	   driver.findElement(By.name("pwd")).sendKeys("manager");
	}

	@And("login button is clicked")
	public void login_button_is_clicked() {
	    driver.findElement(By.id("loginButton")).click();
	}

	@Then("Actitime home page should display")
	public void actitime_home_page_should_display(String status) {
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    try {
	    wait.until(ExpectedConditions.titleContains("Time-Track"));
	    System.out.println(status);
	    } catch (Exception e) {
	    	System.out.println(status);
	    }
	    driver.close();
	}
}
