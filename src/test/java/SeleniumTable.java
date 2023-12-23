import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTable {
	
	public static Logger log;

	public static void main(String[] args) throws InterruptedException {
		
		log= LogManager.getLogger(SeleniumTable.class);
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		log.info("Browser window size maximized");
		driver.get("https://demo.seleniumeasy.com/table-search-filter-demo.html");
		log.info("Demo Selenium website launched");
		Thread.sleep(5000);
		StoreTable(driver);
		log.info("Browser window closed");
		driver.close();
		driver.quit();
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

	


