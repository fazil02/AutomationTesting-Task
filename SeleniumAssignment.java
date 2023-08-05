package com.laptop;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumAssignment {
	
	
	
	    public static void main(String[] args) {
	        // Set the path to your ChromeDriver executable
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

	        WebDriver driver = new ChromeDriver();

	        // Navigate to Gmail
	        driver.get("https://mail.google.com");

	        // Perform login
	        WebElement emailInput = driver.findElement(By.cssSelector("input[type='email']"));
	        emailInput.sendKeys("abcdefg@gmail.com");
	        driver.findElement(By.cssSelector("button[jsname='LgbsSe']")).click();

	        // Wait for password input to appear
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));

	        passwordInput.sendKeys("your_password");
	        driver.findElement(By.cssSelector("button[jsname='LgbsSe']")).click();

	        // Compose email
	        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[role='button'][gh='cm']"))).click();
	        
	        wait.until(ExpectedConditions.elementToBeClickable(By.name("to"))).sendKeys("your_email@gmail.com");
	        driver.findElement(By.name("subjectbox")).sendKeys("Test Mail");
	        driver.findElement(By.cssSelector("div[role='textbox']")).sendKeys("Test Email Body");
	        driver.findElement(By.cssSelector("div[aria-label='More options']")).click();
	        driver.findElement(By.xpath("//div[text()='Label']")).click();
	        driver.findElement(By.xpath("//div[text()='Social']")).click();
	        driver.findElement(By.xpath("//div[text()='Compose']")).click();

	        // Wait for email to arrive in Inbox
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Inbox']"))).click();

	        // Mark email as starred
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[data-tooltip='Star']"))).click();

	        // Open received email
	        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[role='tabpanel'][title='Social']"))).click();
	        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[role='listitem']"))).click();

	        // Verify email label, subject, and body
	        WebElement emailLabel = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Social']")));
	        WebElement emailSubject = driver.findElement(By.cssSelector("h2[class='hP']"));
	        WebElement emailBody = driver.findElement(By.cssSelector("div[class='adn ads']"));

	        if (emailLabel.isDisplayed() && emailSubject.getText().equals("Test Mail") && emailBody.getText().equals("Test Email Body")) {
	            System.out.println("Email verification successful!");
	        } else {
	            System.out.println("Email verification failed!");
	        }

	        // Close the browser
	        driver.quit();
	    }
	}


