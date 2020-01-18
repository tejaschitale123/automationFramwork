package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.BaseTest;

public class Registration extends BaseTest {
	
	@FindBy(xpath="//select[@id='days']")
	WebElement day;
	
	@FindBy(xpath="//select[@id='months']")
	WebElement month;
	
	@FindBy(xpath="//select[@id='years']")
	WebElement year;
	
	@FindBy(xpath="//input[@id='id_gender1']")
	WebElement gender;
	
	@FindBy(xpath="//select[@id='id_state']")
	WebElement state;
	
	
	
	public  Registration() {
		PageFactory.initElements(driver,this);
	}

	public void completeRegistrationForm() {
		gender.click();
		
		Select dayCombo=new Select(day);
		day.click();
		dayCombo.selectByValue("13");
		
		Select monthCombo=new Select(month);
		month.click();
		monthCombo.selectByValue("6");
		
		Select yearCombo=new Select(year);
		year.click();
		yearCombo.selectByValue("2016");
		
		
		Select stateCombo=new Select(state);
		List<WebElement> elements =driver.findElements(By.xpath("//select[@id='id_state']")); 
		System.out.println(elements.get(0).getText());
		state.click();
		stateCombo.selectByVisibleText("Alaska");
		state.click();
	}
	
	public void selectTShirt() {
		List<WebElement>listOfProducts=driver.findElements(By.xpath("//a[@class='product-name']"));
		for(int i=0;i<=listOfProducts.size();i++)
		{
			if(listOfProducts.get(i).getText().equalsIgnoreCase("Faded Short Sleeve T-shirts"))
			{
				listOfProducts.get(i).click();
				break;
			}
			Assert.fail("Could not find the desired T-Shirt");
		}
		Assert.assertTrue(driver.findElement(By.xpath("//h1[@itemprop='name']")).getText().equalsIgnoreCase("Faded Short Sleeve T-shirts"),"Clicked shirt didnot matched");
	}
	
	
	
	

}
