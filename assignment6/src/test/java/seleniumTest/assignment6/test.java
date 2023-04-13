package seleniumTest.assignment6;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class test {
	static WebDriver driver;
	@Test
	@Given("^Users Launch Google Chrome Browser$")
	public void UsersLaunchGoogleChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C://Users//User//Downloads//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexplore.com/selenium-automation-practice-page/");
	}
	

	@Test
	@When("^Users enter user name$")
	public void UsersEnterUserName() {
		driver.findElement(By.id("firstname")).sendKeys("Aleksei");
		driver.findElement(By.id("lastname")).sendKeys("Pant");
  }

	@Test
	@Then("^Users enter email$")
	public void UsersEnterEmail() {
	    driver.findElement(By.id("email")).sendKeys("aleksei@gmail.com");
  }
	
	@Test
	@And("^Users choose Gender and Profession$")
	public void UsersChooseGenderAndProfession() {
	    driver.findElement(By.xpath("//input[@value='male']")).click();
	    driver.findElement(By.xpath("//input[@value='Student']")).click();
  }

	@Test
	@And("^Users Enter country and skill$")
	public void UsersEnterCountryAndSkill() {
	    Select country = new Select(driver.findElement(By.name("country")));
	    country.selectByVisibleText("USA");
	    Select skill = new Select(driver.findElement(By.id("skillsmultiple")));
	    skill.selectByVisibleText("Automation Testing");
  }
  
	@Test
    @And("^Users click the button$")
    public void UsersClickTheButton() {
	    driver.findElement(By.id("alertbutton")).click();
	    Alert alertObj = driver.switchTo().alert();
	    alertObj.accept();
  }
}
