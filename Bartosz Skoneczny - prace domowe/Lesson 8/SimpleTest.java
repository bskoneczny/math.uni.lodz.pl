/**
 * Created by Jacek on 2015-08-01.
 */

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class SimpleTest {

    private static WebDriver driver;

    private static final String URL = "http://localhost:8080/registrationform/";

    @Before
    public  void openBrowser(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public  void shouldShowRightAnswerPopupWhenAsnwerCorrect(){

        driver.get(URL);
        String title = driver.getTitle();
        assertEquals("Rule Financial Registration Form", title);

        
         driver.findElement(By.name("firstName")).clear();
         driver.findElement(By.name("firstName")).sendKeys("Jan");
		 driver.findElement(By.name("lastName")).clear();
         driver.findElement(By.name("lastName")).sendKeys("Kowalski");
		 driver.findElement(By.name("email")).clear();
		 
         driver.findElement(By.name("email")).sendKeys("jkowalski@gmail.com");
		 driver.findElement(By.name("repeatEmail")).clear();
		 driver.findElement(By.name("repeatEmail")).sendKeys("jkowalski@gmail.com");
		 driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div/div[6]/div/table/tbody/tr[1]/td/table/tbody/tr/td[1]/button")).click();
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 driver.findElement(By.id("gwt-uid-24")).click();
		 driver.findElement(By.id("gwt-uid-26")).click();
		 driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div/table/tbody/tr/td[1]/button")).click();
		 assertTrue(driver.findElement(By.xpath("html/body/div[5]")).isDisplayed());

    }
	
	@Test
    public  void shouldShowWrongAnswerPopupWhenAsnwerIsIncorrect(){

        driver.get(URL);
        String title = driver.getTitle();
        assertEquals("Rule Financial Registration Form", title);

        
         driver.findElement(By.name("firstName")).clear();
         driver.findElement(By.name("firstName")).sendKeys("Jerzy");
		 driver.findElement(By.name("lastName")).clear();
         driver.findElement(By.name("lastName")).sendKeys("Nowak");
		 driver.findElement(By.name("email")).clear();
		 
         driver.findElement(By.name("email")).sendKeys("jnowak@gmail.com");
		 driver.findElement(By.name("repeatEmail")).clear();
		 driver.findElement(By.name("repeatEmail")).sendKeys("jnowak@gmail.com");
		 driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div/div[6]/div/table/tbody/tr[1]/td/table/tbody/tr/td[1]/button")).click();
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 driver.findElement(By.id("gwt-uid-22")).click();
		 driver.findElement(By.id("gwt-uid-26")).click();
		 driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div/table/tbody/tr/td[1]/button")).click();
		 assertTrue(driver.findElement(By.xpath("html/body/div[5]/div/div")).isDisplayed());

    }
@Test
    public  void shouldShowDifferentEmailNotification(){

        driver.get(URL);
        String title = driver.getTitle();
        assertEquals("Rule Financial Registration Form", title);

        
         driver.findElement(By.name("firstName")).clear();
         driver.findElement(By.name("firstName")).sendKeys("Zdzislaw");
		 driver.findElement(By.name("lastName")).clear();
         driver.findElement(By.name("lastName")).sendKeys("Iksinski");
		 driver.findElement(By.name("email")).clear();
         driver.findElement(By.name("email")).sendKeys("zdzislawx@gmail.com");
		 driver.findElement(By.name("repeatEmail")).clear();
		 driver.findElement(By.name("repeatEmail")).sendKeys("zdzislaw12@gmail.com");
		 assertTrue(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/div/div[5]/div/div")).isDisplayed());
		 

    }


    @After
    public void closeBrowser(){
        driver.quit();
    }
}