package com.selenium;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class launch {
	public static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.navigate().to("https://www.w3schools.com/");
		
		WebElement tutorial = driver.findElement(By.cssSelector("#navbtn_tutorials"));
		Actions action = new Actions(driver);
		action.moveToElement(tutorial);
		action.click();
		action.perform();
		
		
		WebElement courseSelector = driver.findElement(By.cssSelector("#nav_tutorials > div > div"));
		String catogories = courseSelector.getText();
		System.out.println(catogories);
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Technology you want to Learn :");
		
		
		String s = sc.nextLine(); 
		String find = "Learn " + s.substring(0, 1).toUpperCase() + s.substring(1);
		
		
		WebElement course = driver.findElement(By.linkText(find));
		action.moveToElement(course);
		action.click();
		action.perform();
		
		String subtopics  = driver.findElement(By.cssSelector("#leftmenuinnerinner")).getText();
		System.out.print(subtopics);
		System.out.println("What You Want to Learn :");
		String sub = sc.nextLine();
		Thread.sleep(2000);
		
		WebElement subtopic = driver.findElement(By.linkText(sub));
		action.moveToElement(subtopic);
		action.click();
		action.perform();
		
		String intro = driver.findElement(By.className("w3-example")).getText();
		System.out.println(intro);
		Thread.sleep(2000);
	}

}
