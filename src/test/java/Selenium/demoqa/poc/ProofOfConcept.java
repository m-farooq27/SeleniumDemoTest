package Selenium.demoqa.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ProofOfConcept {
	static WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) {
		driver.get("https://demoqa.com/books");
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[1]/span/div")).click();
	}
}
