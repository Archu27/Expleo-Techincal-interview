package com.Internet.Pages;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Internet.Base.TestBase;

public class ChallengingDOMPage extends TestBase {

	static WebDriverWait wait = new WebDriverWait(driver, 10);

	// Constructor to avoid overloading of driver
	public ChallengingDOMPage() {
		PageFactory.initElements(driver, this);
	}

	// WebElements

	@FindBy(css = "div>h3")
	WebElement header;
	@FindBy(css = "div>a[class='button']")
	WebElement blueButton;
	@FindBy(css = "div>a[class='button alert']")
	WebElement redButton;
	@FindBy(css = "div>a[class='button success']")
	WebElement greenButton;
	@FindBy(xpath = "(//table/tbody/tr[1]/td[7]/a)[1]")
	WebElement edit;
	@FindBy(xpath = "(//table/tbody/tr[1]/td[7]/a)[2]")
	WebElement delete;
	@FindBy(xpath = "//div[@id='content']/script")
	WebElement answer;
	@FindBy(css="table>thead>tr>th")
	List<WebElement> tableheaders;
	@FindBy(css="tbody>tr>td:nth-child(1)")
	List<WebElement> columncontents;
	@FindBy(css="tbody>tr:nth-child(1)>td")
	List<WebElement> rowcontents;

	// Action Methods
	// validate Page title
	public String validatePageTitle() {
		wait.until(ExpectedConditions.visibilityOf(header));
		return driver.getTitle();
	}

	// validate Page header
	public String validateHeader() {
		wait.until(ExpectedConditions.visibilityOf(header));
		return header.getText();
	}
	
	// Validate Blue Button
	public WebElement getBluebutton(){
		wait.until(ExpectedConditions.visibilityOf(blueButton));
		return blueButton;
	}
	
	// Validate red Button
		public WebElement getRedbutton(){
			wait.until(ExpectedConditions.visibilityOf(redButton));
			return redButton;
		}
		
		// Validate Blue Button
		public WebElement getGreenbutton(){
			wait.until(ExpectedConditions.visibilityOf(greenButton));
			return greenButton;
		}

	// Validate Static table headers
	public List<WebElement> validateTableHeaders() {
		wait.until(ExpectedConditions.visibilityOf(header));
		return tableheaders;
	}

	// Validate Static table column
	public List<WebElement> validateTableColumn() {
		wait.until(ExpectedConditions.visibilityOf(header));
		return columncontents;
	}

	// Validate Static table row
	public List<WebElement> validateTableRow() {
		wait.until(ExpectedConditions.visibilityOf(header));
		return rowcontents;
	}

	// Validate edit
	public String validateEdit() {
		wait.until(ExpectedConditions.visibilityOf(edit));
		edit.click();
		return driver.getCurrentUrl();
	}

	// validate delete
	public String validateDelete() {
		wait.until(ExpectedConditions.visibilityOf(delete));
		delete.click();
		return driver.getCurrentUrl();
	}
	
	//Validate Canvas answer value
	public String validateCanvas() {
		wait.until(ExpectedConditions.visibilityOf(header));
		// grab the canvas generation script block, which contains the Answer buried in java script
		String value = answer.getAttribute("innerHTML");
		String pattern = "Answer:\\s(\\d+)";
		Pattern r = Pattern.compile(pattern);
		// Now create matcher object.
		Matcher m = r.matcher(value);
		if (m.find())
			return m.group(1);
		else
			return null;

	}
}
