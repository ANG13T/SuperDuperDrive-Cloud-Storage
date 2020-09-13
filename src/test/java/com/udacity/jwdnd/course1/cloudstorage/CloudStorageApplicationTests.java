package com.udacity.jwdnd.course1.cloudstorage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CloudStorageApplicationTests {

	@LocalServerPort
	private int port;

	private WebDriver driver;
	private LoginPage loginPage;
	private SignUpPage signUpPage;
	private HomePage homePage;

	@BeforeAll
	static void beforeAll() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	public void beforeEach() {
		this.driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		signUpPage = new SignUpPage(driver);
		homePage = new HomePage(driver);
	}

	@AfterEach
	public void afterEach() {
		if (this.driver != null) {
			driver.quit();
		}
	}

	@Test
	public void getLoginPage() {
		driver.get("http://localhost:" + this.port + "/login");
		Assertions.assertEquals("Login", driver.getTitle());
	}

	@Test
	public void testIfHomePageAccessibleIfLoggedIn(){
		driver.get("http://localhost:" + this.port + "/signup");
		signUpPage.enterForm();
		loginPage.login();
		Assertions.assertEquals(driver.getCurrentUrl(), "http://localhost:" + this.port + "/home");
	}

	@Test
	public void testIfHomePageUnAccessibleIfLoggedOut(){
		driver.get("http://localhost:" + this.port + "/signup");
		signUpPage.enterForm();
		loginPage.login();
		homePage.logOut();
		Assertions.assertEquals(driver.getCurrentUrl(), "http://localhost:" + this.port + "/login");
	}

}
