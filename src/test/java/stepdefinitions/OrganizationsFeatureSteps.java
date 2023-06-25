package stepdefinitions;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrganizationsFeatureSteps {
	WebDriver driver;
	String orgName;
	Random r;
	
	@Before
	public void navigateToVtiger() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Given("login to vtiger application")
	public void login_to_vtiger_application() {
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).submit();
	}

	@When("click on organizations tab")
	public void click_on_organizations_tab() {
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	}

	@When("create organization with mandatory details")
	public void create_organization_with_mandatory_details() {
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		r = new Random();
		int randomNum = r.nextInt(100);
		orgName = "Qspiders"+randomNum;
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
		
	}

	@Then("New organization info page is displayed")
	public void new_organization_info_page_is_displayed() {
		String newOrgInfoHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(newOrgInfoHeader.contains(orgName))
			System.out.println("New organization created");
		else
			System.out.println("New organization not created");
		
		driver.findElement(By.xpath("//a[@class='hdrLink']")).click();
	}

	@Then("new organization is added to the organizations list")
	public void new_organization_is_added_to_the_organizations_list() {
		String newOrg = driver.findElement(By.xpath("//table[@class='lvt small']/descendant::tr[last()]/td[3]/a")).getText();
		if(newOrg.equals(orgName))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		
	}

	@When("create organization with industry and type details")
	public void create_organization_with_industry_and_type_details() {
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		int randomNum = r.nextInt(100);
		String orgName = "Microsoft"+randomNum;
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		
		WebElement industryDropdown = driver.findElement(By.name("industry"));
		Select s = new Select(industryDropdown);
		s.selectByValue("Banking");
		
		WebElement typeDropdown = driver.findElement(By.name("accounttype"));
		Select s1 = new Select(typeDropdown);
		s1.selectByValue("Investor");
		
		driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
		
	}
	
	@After
	public void logOutAndQuitBrowser() {
		WebElement administratorIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a = new Actions(driver);
		a.moveToElement(administratorIcon).perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
	}
}
