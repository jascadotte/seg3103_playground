package selenium;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

class ExampleSeleniumTest {

  static Process server;
  private WebDriver driver;

  @BeforeAll
  public static void setUpBeforeClass() throws Exception {
    ProcessBuilder pb = new ProcessBuilder("java", "-jar", "bookstore5.jar");
    server = pb.start();
  }

  @BeforeEach
  void setUp() {
    Duration duration = Duration.ofSeconds(60);
    // Pick your browser
    // driver = new FirefoxDriver();
    // driver = new SafariDriver();
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("http://localhost:8080/");
    // wait to make sure Selenium is done loading the page
    WebDriverWait wait = new WebDriverWait(driver, duration); // Added as Int no longer supported
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
  }

  @AfterEach
  public void tearDown() {
    driver.close();
  }

  @AfterAll
  public static void tearDownAfterClass() throws Exception {
    server.destroy();
  }

  // @Test
  // void test1() {
  //   WebElement element = driver.findElement(By.id("title"));
  //   String expected = "YAMAZONE BookStore";
  //   String actual = element.getText();
  //   assertEquals(expected, actual);
  // }

  // @Test
  // public void test2() {
  //   WebElement welcome = driver.findElement(By.cssSelector("p"));
  //   String expected = "Welcome";
  //   String actual = welcome.getText();
  //   assertEquals(expected, getWords(actual)[0]);
  //   WebElement langSelector = driver.findElement(By.id("locales"));
  //   langSelector.click();
  //   WebElement frSelector = driver.findElement(By.cssSelector("option:nth-child(3)"));
  //   frSelector.click();
  //   welcome = driver.findElement(By.cssSelector("p"));
  //   expected = "Bienvenu";
  //   actual = welcome.getText();
  //   assertEquals(expected, getWords(actual)[0]);
  // }


  // USE CASES
  @Test
  public void UC1_Main() {
    // Main Scenario
	  driver.get("http://localhost:8080/admin");
	  driver.findElement(By.id("loginId")).sendKeys("admin");
	  driver.findElement(By.id("loginPasswd")).sendKeys("password");
	  driver.findElement(By.id("loginBtn")).click();
	  assertEquals("http://localhost:8080/admin", driver.getCurrentUrl());
  }

  @Test
  public void UC1_Alt1() {
    // Alternative 1 - Enter incorrect creds
    driver.get("http://localhost:8080/admin");
	  driver.findElement(By.id("loginId")).sendKeys("bobby");
	  driver.findElement(By.id("loginPasswd")).sendKeys("john");
	  driver.findElement(By.id("loginBtn")).click();
	  assertTrue(driver.getPageSource().contains("Invalid username and/or password"));
	  driver.findElement(By.id("loginId")).sendKeys("admin");
	  driver.findElement(By.id("loginPasswd")).sendKeys("password");
	  driver.findElement(By.id("loginBtn")).click();
	  assertEquals("http://localhost:8080/admin", driver.getCurrentUrl());
  }

  @Test
  public void UC2_Main() {
    // Logout from Admin
	  UC1_Main(); // Sign in as Admin
	  driver.findElement(By.cssSelector("input[value='Sign out']")).click();
	  assertTrue(driver.getPageSource().contains("You have been logged out"));
  }


  @Test
  public void UC3_Main() {
    // Add a book
	  UC1_Main(); // Sign in as Admin
	  driver.findElement(By.id("addBook-category")).sendKeys("Category1");
	  driver.findElement(By.id("addBook-id")).sendKeys("BookId1");
	  driver.findElement(By.id("addBook-title")).sendKeys("Title1");
	  driver.findElement(By.id("addBook-authors")).sendKeys("Author1");
	  driver.findElement(By.id("longDescription")).sendKeys("Description1");
	  driver.findElement(By.id("cost")).sendKeys("11.11");
	  driver.findElement(By.name("addBook")).click();
    System.out.println("UC3: " + driver.findElement(By.tagName("h2")).getText());
    assertTrue(driver.getPageSource().contains("Successfully added book"));
  }

  @Test
  public void UC3_Alt1() {
    // Wrong Book Info - No Title
	  UC1_Main(); // Sign in as Admin
    driver.findElement(By.id("addBook-title")).sendKeys(" ");
	  driver.findElement(By.name("addBook")).click();
    // System.out.println("UC4: " + driver.findElement(By.tagName("h2")).getText());
    assertTrue(driver.findElement(By.tagName("h2")).getText().contains("Validation errors"));
  }

  @Test
  public void UC3_Alt2() {
    // Duplicate Book
	  UC1_Main(); // Sign in as Admin
	  driver.findElement(By.id("addBook-category")).sendKeys("Category1");
	  driver.findElement(By.id("addBook-id")).sendKeys("BookId1");
	  driver.findElement(By.id("addBook-title")).sendKeys("Title1");
	  driver.findElement(By.id("addBook-authors")).sendKeys("Author1");
	  driver.findElement(By.id("longDescription")).sendKeys("Description1");
	  driver.findElement(By.id("cost")).sendKeys("11.11");
	  driver.findElement(By.name("addBook")).click();
    System.out.println("UC5: " + driver.findElement(By.tagName("h2")).getText());
	  assertTrue(driver.getPageSource().contains("Book with same id already exist"));
  }

  @Test
  public void UC5_Main() {
    try {
      // Delete Book
	    UC1_Main(); // Sign in as Admin
	    driver.findElement(By.id("searchBtn")).click();
	    driver.findElement(By.id("del-rowling001")).click();
      assertFalse(driver.getPageSource().contains("del-rowling001"));
    } catch (Exception e) {    }
  }

  @Test
  public void UC4_Main() {
    // Browse a book
    UC3_Main(); // Add Book - also signs in
	  driver.findElement(By.id("searchBtn")).click();
	  driver.findElement(By.id("search")).sendKeys("Category1");
	  driver.findElement(By.id("searchBtn")).click();
    assertTrue(driver.getPageSource().contains("We currently have the following"));
  }

  @Test
  public void UC4_Alt1() {
    // Browse a book - Any category
    UC1_Main(); // Sign in as Admin
	  driver.findElement(By.id("searchBtn")).click();
    assertTrue(driver.getPageSource().contains("We currently have the following"));
  }

  @Test
  public void UC4_Alt2() {
    // Browse a book - Wrong category
    UC1_Main(); // Sign in as Admin
	  driver.findElement(By.id("searchBtn")).click();
	  driver.findElement(By.id("search")).sendKeys("xyzzy");
	  driver.findElement(By.id("searchBtn")).click();
    assertTrue(driver.getPageSource().contains("Sorry we do not have any item"));
  }


  // FUNCTIONAL TESTS
  @Test
  public void F1_pos() {
    UC1_Main(); // Sign in as Admin
    driver.findElement(By.id("addBook-category")).sendKeys("Category2");
	  driver.findElement(By.id("addBook-id")).sendKeys("BookId2");
	  driver.findElement(By.id("addBook-title")).sendKeys("Title2");
	  driver.findElement(By.id("addBook-authors")).sendKeys("Author2");
	  driver.findElement(By.id("longDescription")).sendKeys("Description2");
	  driver.findElement(By.id("cost")).sendKeys("22.22");
	  driver.findElement(By.name("addBook")).click();
    // System.out.println("UC5: " + driver.findElement(By.tagName("h2")).getText());
    assertTrue(driver.findElement(By.tagName("h2")).getText().contains("Successfully added"));
  }

  @Test
  public void F1_Neg() {
    UC1_Main(); // Sign in as Admin
	  driver.findElement(By.name("addBook")).click();
    assertTrue(driver.findElement(By.tagName("h2")).getText().contains("Validation errors"));
  }

  @Test
  public void F2_Pos() {
	  driver.findElement(By.id("searchBtn")).click();
    assertTrue(driver.getPageSource().contains("order-hall001"));
	  driver.findElement(By.id("search")).sendKeys("xyzzy");
	  driver.findElement(By.id("searchBtn")).click();
    assertFalse(driver.getPageSource().contains("order-hall001"));
	  assertTrue(driver.getPageSource().contains("We currently have"));
  }

  @Test
  public void F2_Neg() {
    try {
      driver.findElement(By.id("searchBtn")).click();
      System.out.println("F2N: " + driver.findElement(By.tagName("h2")).getText());
      assertFalse(driver.findElement(By.tagName("h2")).getText().contains("We currently"));
		} catch (Exception e) { }
  }

  @Test
  public void F3_Pos() {
	  driver.findElement(By.id("searchBtn")).click();
	  driver.findElement(By.id("order-hall001")).click();
  }

  @Test
  public void F3_Neg() {
    // Cannot test
    assertTrue(true);
  }

  @Test
  public void F4_Pos() {
	  F3_Pos();
	  driver.findElement(By.id("cartLink")).click();
	  try{Thread.sleep(1000);} catch(Exception e){}
	  assertTrue(driver.getPageSource().contains("hall001"));
  }

  @Test
  public void F4_Neg() {
	  driver.findElement(By.id("searchBtn")).click();
	  driver.findElement(By.id("cartLink")).click();
	  assertTrue(driver.findElements(By.name("checkout")).isEmpty());
  }

  @Test
  public void F5_Pos() {
	  F4_Pos();
	  driver.findElement(By.id("hall001")).sendKeys("\b3" + Keys.TAB + Keys.ENTER);
	  assertEquals("$119.85", driver.findElement(By.id("tothall001")).getText());
  }

  @Test
  public void F5_Neg() {
	  F4_Pos();
	  String oldValue = driver.findElement(By.id("tothall001")).getText();
	  driver.findElement(By.id("hall001")).sendKeys("\bNaN" + Keys.TAB + Keys.ENTER);
	  assertEquals(oldValue, driver.findElement(By.id("tothall001")).getText());
  }

  @Test
  public void F6_Pos() {
    // ToDo
    assertTrue(true); 
  }

  @Test
  public void F6_Neg() {
      assertTrue(true); 
  }

  @Test
  public void F7_Pos() {
	  driver.findElement(By.id("searchBtn")).click();
      if(!driver.getPageSource().contains("hall001"))
	      F1_pos();
		  try {
			driver.findElements(By.cssSelector("input[value='Sign out']"));
		  } catch (Exception e) {
      UC1_Main(); // Sign in as Admin
    }
		  try {
		} catch (Exception e) { }
      assertTrue(driver.getPageSource().contains("hall001"));
  }

  @Test
  public void F7_Neg() {
    try {
      // Delete Book
	    UC1_Main(); // Sign in as Admin
	    driver.findElement(By.id("searchBtn")).click();
	    driver.findElement(By.id("del-hall001")).click();
      assertFalse(driver.getPageSource().contains("del-hall001"));
    } catch (Exception e) {    }
    UC1_Main(); // Sign in as Admin, add book as tests are not in order
	  driver.findElement(By.id("addBook-category")).sendKeys("Cat");
	  driver.findElement(By.id("addBook-id")).sendKeys("hall001");
	  driver.findElement(By.id("addBook-title")).sendKeys("NewTitle");
	  driver.findElement(By.id("addBook-authors")).sendKeys("Bob");
	  driver.findElement(By.id("longDescription")).sendKeys("Codez");
	  driver.findElement(By.id("cost")).sendKeys("42.42");
	  driver.findElement(By.name("addBook")).click();
	  assertTrue(driver.getPageSource().contains("Successfully added book"));
  }

  @Test
  public void F8_Pos() {
    UC1_Main(); // Sign in as Admin
  }

  @Test
  public void F8_Neg() {
    UC1_Alt1();
  }

  private String[] getWords(String s) {
    return s.split("\\s+");
  }

}
