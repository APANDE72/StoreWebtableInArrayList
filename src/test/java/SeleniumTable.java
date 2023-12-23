import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SeleniumTable {
	
	public static Logger log;

	public static void main(String[] args) throws InterruptedException {
		
		ExtentReports extent= new ExtentReports();
		ExtentSparkReporter spark =new ExtentSparkReporter("ExtentReport.html");
		
		
		ExtentTest test = extent.createTest("Launch Browser");
		test.log(Status.PASS, "user launch browser");
		test.pass("user lauch website verified");
		log= LogManager.getLogger(SeleniumTable.class);
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		test.pass("User Maximized Window");
		log.info("Browser window size maximized");
		driver.get("https://demo.seleniumeasy.com/table-search-filter-demo.html");
		test.pass("URL Opened");
		log.info("Demo Selenium website launched");
		Thread.sleep(5000);
		StoreTable(driver);
		log.info("Browser window closed");
		test.pass("Closed");
		test.warning("window will be closed");
		driver.close();
		driver.quit();
		extent.attachReporter(spark);
		extent.flush();
	}
		
	public static void StoreTable(WebDriver driver) {
		
		
		WebElement table = driver.findElement(By.xpath("//*[@id='task-table']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));
	    List<WebElement> column = table.findElements(By.tagName("td"));
	    List<String> value = new ArrayList<String>();

	    System.out.println(rows.size());

	        for (int j=0; j<column.size(); j++){
	            System.out.println(column.get(j).getText());
	            value.add(column.get(j).getText());
	        }
	        
	        System.out.println(value);
	      
	}
	
		
	}

	


