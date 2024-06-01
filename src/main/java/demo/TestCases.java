package demo;

import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.io.*;
import java.lang.Thread;



public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        //driver= new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
       // driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");

        driver.get("https://leetcode.com/");

        // retrieve the current url
        String currentUrl = driver.getCurrentUrl();

        //validating current url
        if(currentUrl.contains("leetcode")){
            System.out.println("url of the page contains leetcode");
        }
        else{
            System.out.println("url of the page does not contain leetcode");  
            
            endTest();
        }
    }

    public  void testCase02()throws InterruptedException{
        System.out.println("Start Test case: testCase02");

        driver.get("https://leetcode.com/");

        // retrieve the Url of question
        //WebElement Question = driver.findElement(By.xpath("//*[@href='/problemset/all/']"));
        WebElement Question = driver.findElement(By.xpath("//*[@id='landing-page-app']/div/div[1]/div[3]/div[1]/div/div/div[2]/div/a[3]/span"));

        Question.click();

    

        //Verify that you are on the problem set page, by checking the URL contains "problemset"
        WebElement Question1 = driver.findElement(By.xpath("//*[@id=\"product\"]/div/div/div[1]/div/a"));

        Question1.click();

         // retrieve the current url
         String currentUrl = driver.getCurrentUrl();

         //validating current url
         if(currentUrl.contains("problemset")){
             System.out.println("url of the page contains problemset");
         }
         else{
             System.out.println("url of the page does not contain problemset");  
             
         }

         //Retrieve the details of the first 5 questions and print them.


         Thread.sleep(2000);
         for(int i=2; i<7; i++){
            WebElement cell = driver.findElement(By.xpath("((//div[@role='table'])[2]//div/div[@role='rowgroup']//div[@role='row'])["+i+"]//div[@class='truncate']//a"));
            Thread.sleep(1000);
            System.out.println(cell.getText());
         }
        // driver.quit();
       // driver.close();
    }

    public  void testCase03()throws InterruptedException{


        System.out.println("Start Test case: testCase03");


        driver.get("https://leetcode.com/problems/two-sum/");


        // retrieve the current url
        String currentUrl = driver.getCurrentUrl();

        //validating current url
        if(currentUrl.contains("two-sum")){
            System.out.println("The URL of the problem contains two-sum");
        }
        else{
            System.out.println("The URL of the problem does not contains two-sum");  
            
            
        }
    }
    public  void testCase04()throws InterruptedException{


        System.out.println("Start Test case: testCase04");


        driver.get("https://leetcode.com/problems/two-sum/");

        WebElement submissionbtn = driver.findElement(By.xpath("//*[@id='qd-content']/div[1]/div/div/div/div[1]/div/div/a[4]/div"));
        submissionbtn.click();
       
        WebElement button = driver.findElement(By.xpath("//*[@id='qd-content']/div[1]/div/div/div/div[2]/div/div/a"));

        String content = button.getText();
        Thread.sleep(1000);
        if(content.contains("Register or Sign In")){
            System.out.println("The URL of the problem contains Register or Sign In");
        }
        else{
            System.out.println("The URL of the problem does not contains Register or Sign In");  
            
            endTest();
        }
    }


}
