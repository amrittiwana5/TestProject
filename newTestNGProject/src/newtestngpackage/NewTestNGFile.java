package newtestngpackage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class NewTestNGFile {
	
	 public String baseUrl = "http://automationpractice.com/index.php";
	   // String driverPath = "C:\\Users\\atiwana\\Desktop\\chromedriver.exe";
	    public WebDriver driver ; 
	    
	    
	  
	    
	    @BeforeTest
	    @Parameters("browser")
	    public void launchbrowser(String browser) throws Exception{
	    	
	    	System.out.println("Browser name is : "+browser);
	    	//Check if parameter passed from TestNG is 'chrome'
			if(browser.equalsIgnoreCase("chrome")){
			//create chrome instance
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\atiwana\\Desktop\\chromedriver.exe");
				driver = new ChromeDriver();
			}
	    	
			else if(browser.equalsIgnoreCase("IE")){
				System.setProperty("webdriver.ie.driver","C:\\Selenium\\IEDriverServer_Win32_3.150.1\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			
			
	        
	        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	        driver.get(baseUrl);
	        
	        driver.manage().window().maximize() ;  
	    	
	    }
	
	    
	
  @Test
  public void verifyLandingPageTitle() {
	  
	  
	    
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		
		
		driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("amrittiwana20@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
		
		//Details on Personal Information
		
		
		driver.findElement(By.xpath("//*[@id=\"id_gender1\"] ")).click();
		
		String firstname = "Amrit";
		String lastname = "Tiwana";
		
		String expectedname = firstname + " " + lastname;
		
		driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys(firstname);
		
		driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys(lastname);
		
		driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("Sunny@123");
		
		Select day = new Select(driver.findElement(By.xpath("//*[@id=\"days\"]")));
		
		day.selectByValue("14");
		
		
		Select month = new Select(driver.findElement(By.id("months")));
		month.selectByValue("9");
		
		Select year = new Select(driver.findElement(By.id("years")));
		year.selectByValue("1990");
		
		driver.findElement(By.xpath("//*[@id=\"newsletter\"]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"company\"]")).sendKeys("Capgemini");
		
		driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("1 Adelaide Street");
		driver.findElement(By.xpath("//*[@id=\"address2\"]")).sendKeys("Albion");
		
		driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("New York");
		
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByVisibleText("New York");
		
		
		
		
		
		driver.findElement(By.xpath("//*[@id=\"postcode\"]")).sendKeys("30201");
		
		driver.findElement(By.xpath("//*[@id=\"other\"]")).sendKeys("This is an Automation Test");
		
		driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("0415110019");
		driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]")).sendKeys("0415110029");
		
		driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span")).click();
		
		//Check for First Name and last name
		String actualname = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).getText();
		
		try {
		Assert.assertEquals(expectedname,actualname);
		System.out.println("firstname and lastname is correct");
		} catch(Error e) {
			System.out.println("firstname and lastname is incorrect");
			Assert.fail();
			
		}
  }
		
		
		@AfterTest
		public void terminateBrowser() {
			
			driver.close();
		
		
		
		
	  
  }
}
