package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateContactsPage extends WebDriverUtility{
	
	//declaration
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement selectOrgLookUpImg;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(name = "search_text")
	private WebElement searchTextEdt;
	
	@FindBy( name = "search")
	private WebElement searchBtn;
	
	//initialization
	public CreateContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	//utilization
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSelectOrgLookUpImg() {
		return selectOrgLookUpImg;
	}
	
	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	//business library
	
	public void createNewContact(String lastName)
	{
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
	public void createNewContact(String lastName,String leadSource)
	{
		lastNameEdt.sendKeys(lastName);
		select(leadSource, leadSourceDropDown);
		saveBtn.click();
		
	}
	
	public void createNewContact(WebDriver driver, String lastName, String orgName)
	{
		lastNameEdt.sendKeys(lastName);
		selectOrgLookUpImg.click();
		switchToWindow(driver, "Accounts");
		searchTextEdt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
	}
	
	public void createNewContact(WebDriver driver, String lastName, String orgName, String leadSource)
	{
		lastNameEdt.sendKeys(lastName);
		selectOrgLookUpImg.click();
		switchToWindow(driver, "Accounts");
		searchBtn.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts");
		select(leadSource, leadSourceDropDown);
		saveBtn.click();
		
		
	}

	
	
	
	
	

}
