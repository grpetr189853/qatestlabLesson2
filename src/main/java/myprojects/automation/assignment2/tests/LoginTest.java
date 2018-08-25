package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest extends BaseScript {

    public static void main(String[] args) throws InterruptedException {
        // TODO Script to execute login and logout steps

        WebDriver driver = getInitFirefoxDriver();

        driver.manage().window().maximize();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        WebElement fieldEmail = driver.findElement(By.id("email"));
        fieldEmail.sendKeys("webinar.test@gmail.com");

        WebElement fieldPasswd = driver.findElement(By.id("passwd"));
        fieldPasswd.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement button = driver.findElement(By.name("submitLogin"));
        button.click();

    }
    public static WebDriver getInitFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", LoginTest.class.getResource("/geckodriver.exe").getPath());
        return new FirefoxDriver();
    }
}
