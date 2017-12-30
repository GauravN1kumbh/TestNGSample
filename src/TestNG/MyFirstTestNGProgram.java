package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTestNGProgram {
	// public static String driverPath = "Artifacts";
	@Test(priority = 0)
	public void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"d:\\Techcanvass_Workplace\\SeleniumBasics\\Artifacts\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://crm.techcanvass.co.in/"); // user can use driver.navigate().to()..both are the same
		driver.manage().window().maximize();

		String userName = "techcanvassacademy@techcanvass.co.in";
		String password = "abhishek1234";

		driver.findElement(By.id("btnlogin")).click();
		driver.findElement(By.id("txtuname")).sendKeys(userName);
		driver.findElement(By.id("txtpwd")).sendKeys(password);
		driver.findElement(By.id("loginbtn")).click();

		// String data = "Ritu";
		// driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtleadsrch")).sendKeys(data);
		// driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnsrchadminlead")).click();

		Thread.sleep(2000);

		String expectedResult = "Welcome Techcanvass Academy";
		String actualResultPartOne = driver.findElement(By.id("ctl00_Label23")).getText();
		String actualResultPartTwo = driver.findElement(By.id("ctl00_lblloginuser")).getText();
		String actualResult = actualResultPartOne + " " + actualResultPartTwo;
		System.out.println("Actual Result = " + actualResult);
		Assert.assertEquals(actualResult, expectedResult, "Login Successfull!!!!"); // Assertion is used to cmpaire the
																					// actual result with Expected
																					// result

		// Asert true
		boolean condition = expectedResult.contains(actualResultPartTwo);
		Assert.assertTrue(condition);

		// Assert Fail
		if (actualResultPartTwo.contains(null)) {
			Assert.fail("Script Filed as name was null on Website");
		}

		// driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgecloseleadserch")).click();
		// driver.findElement(By.id("ctl00_linkButton")).click();

		// Thread.sleep(2000);

		// driver.quit();

	}

	@Test(priority = 1)
	public void loginFailed() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"d:\\Techcanvass_Workplace\\SeleniumBasics\\Artifacts\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://crm.techcanvass.co.in/"); // user can use driver.navigate().to()..both are the same
		driver.manage().window().maximize();

		String userName = "techcanvassacademy@techcanvass.co.in";
		String password = "abhishek1234";

		driver.findElement(By.id("btnlogin")).click();
		driver.findElement(By.id("txtuname")).sendKeys(userName);	
		driver.findElement(By.id("txtpwd")).sendKeys(password);
		driver.findElement(By.id("loginbtn")).click();

		// String data = "Ritu";
		// driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtleadsrch")).sendKeys(data);
		// driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnsrchadminlead")).click();

		Thread.sleep(2000);

		String expectedResult = "Welcome Techcanvass Academy";
		String actualResultPartOne = driver.findElement(By.id("ctl00_Label23")).getText();
		String actualResultPartTwo = driver.findElement(By.id("ctl00_lblloginuser")).getText();
		String actualResult = actualResultPartOne + actualResultPartTwo;
		System.out.println("Actual Result = " + actualResult);
		Assert.assertEquals(actualResult, expectedResult, "Login UnSuccessfull!!!!");

		// driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgecloseleadserch")).click();
		// driver.findElement(By.id("ctl00_linkButton")).click();

		// Thread.sleep(2000);

		// driver.quit();

	}

}