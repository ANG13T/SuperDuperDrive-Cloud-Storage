package com.udacity.jwdnd.course1.cloudstorage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.concurrent.TimeUnit;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CloudStorageApplicationTests {

	@LocalServerPort
	private int port;

	private static WebDriver driver;
	private LoginPage loginPage;
	private SignUpPage signUpPage;
	private HomePage homePage;



	@BeforeAll
	static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@BeforeEach
	public void beforeEach() {
		loginPage = new LoginPage(driver);
		signUpPage = new SignUpPage(driver);
		homePage = new HomePage(driver);
	}

	@AfterEach
	public void afterEach() {

	}

	@AfterAll
	public void afterAll(){
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
	public void signUp(){
		driver.get("http://localhost:" + this.port + "/signup");
		signUpPage.enterForm();
		Assertions.assertEquals(driver.getCurrentUrl(), "http://localhost:" + this.port + "/login");
	}




}
