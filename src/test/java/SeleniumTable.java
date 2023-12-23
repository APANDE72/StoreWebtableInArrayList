import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTable {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.seleniumeasy.com/table-search-filter-demo.html");
		Thread.sleep(5000);
		StoreTable(driver);
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

	


