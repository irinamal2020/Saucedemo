import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {


    @Test
    public void loginTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("123456789");
        driver.findElement(By.id("login-button")).click();

        String message = driver.findElement(By.cssSelector("[data-test=error]")).getText();

        Assert.assertEquals(message, "Epic sadface: Username and password do not match any user in this service");
        driver.quit();
    }

    @Test
    public void loginTest1() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();

        String message = driver.findElement(By.cssSelector("[data-test=error]")).getText();

        Assert.assertEquals(message, "Epic sadface: Password is required");
        driver.quit();
    }

}
