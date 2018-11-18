package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Tester {

    

    public static void main(String[] args) {
        // login("pekka", "akkep");
        // login("pekka", "wrong");
        // login("wrong", "akkep");
        register();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
    
    private static void login(String username, String password) {
        System.setProperty("webdriver.chrome.driver", "chromedriver"); 
        
        WebDriver driver = new ChromeDriver();
        
        driver.get("http://localhost:4567");
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        driver.quit();
    }

    private static void register() {
        System.setProperty("webdriver.chrome.driver", "chromedriver"); 
        
        WebDriver driver = new ChromeDriver();
        
        driver.get("http://localhost:4567");
        
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        Random r = new Random();
        String password = "asdasd";
    
        element = driver.findElement(By.name("username"));
        element.sendKeys("arto"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password);
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();

        sleep(2);

        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();

        sleep(2);

        element = driver.findElement(By.linkText("logout"));
        element.click();

        sleep(2);
        
        driver.quit();
    }
}
