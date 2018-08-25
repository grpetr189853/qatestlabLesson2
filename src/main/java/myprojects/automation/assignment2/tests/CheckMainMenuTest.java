package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CheckMainMenuTest extends BaseScript{

    public static void main(String[] args) throws InterruptedException {
            WebDriver driver = getInitFirefoxDriver();
            driver.manage().window().maximize();
            driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

            WebElement fieldEmail = driver.findElement(By.id("email"));
            fieldEmail.sendKeys("webinar.test@gmail.com");

            WebElement fieldPasswd = driver.findElement(By.id("passwd"));
            fieldPasswd.sendKeys("Xcg7299bnSmMuRLp9ITw");
            WebElement button = driver.findElement(By.name("submitLogin"));
            button.click();
            try {
                Sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String [] menu = {"Dashboard","Заказы","Каталог","Клиенты","Служба поддержки","Статистика","Modules","Design","Доставка","Способ оплаты","International","Shop Parameters","Конфигурация"};
            for(int i = 0;i < menu.length;i++) {
                WebElement element = driver.findElement(By.partialLinkText(menu[i]));
                element.click();
                String Title =  driver.getTitle();
                String url = driver.getCurrentUrl();
                System.out.println(Title);
                driver.navigate().refresh();
                String TitleNew = driver.getTitle();
                String urlNew = driver.getCurrentUrl();
                if(Title.equals(TitleNew) && url.equals(urlNew)) {
                    System.out.println("OK!");
                }
                try {
                    Sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

    }
        public static WebDriver getInitFirefoxDriver() {
            System.setProperty("webdriver.gecko.driver", CheckMainMenuTest.class.getResource("/geckodriver.exe").getPath());
            return new FirefoxDriver();
        }
        public static void Sleep(int millis) throws java.lang.InterruptedException{
            Thread.sleep(millis);
        }

}
