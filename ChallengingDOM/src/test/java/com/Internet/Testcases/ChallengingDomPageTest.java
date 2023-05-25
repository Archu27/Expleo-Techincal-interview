package com.Internet.Testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Internet.Base.TestBase;
import com.Internet.Pages.ChallengingDOMPage;

public class ChallengingDomPageTest extends TestBase {

	ChallengingDOMPage cdp;

	// Setup
	@BeforeTest
	public void setup() {
		initialization();
		cdp = PageFactory.initElements(driver, ChallengingDOMPage.class);
	}

	// TestCases
	// Test that checks the title to match with the expected page title "The Internet"
	@Test(priority = 1)
	public void validateTitleTest() {
		String title = cdp.validatePageTitle();
		Assert.assertEquals(title, "The Internet");
		System.out.println("The title of the page is:   " + title);
	}

	// Test that checks the page header to match with the expected header name "Challenging DOM"
	@Test(priority = 2)
	public void validateHeaderTest() {
		String header = cdp.validateHeader();
		Assert.assertEquals(header, "Challenging DOM");
		System.out.println("The header in the page is: " + header);
	}

	// Tests that check the operations of the buttons
	
	// Test that checks the operation of blue button
	@Test(priority = 3)
	public void validateBlueButtonTest() {
		String id1 = cdp.getBluebutton().getAttribute("id");
		System.out.println("The id of blue button before clicking is: " + id1);
		cdp.getBluebutton().click();
		String id2 = cdp.getBluebutton().getAttribute("id");
		System.out.println("The id of blue button after clicking is: " + id2);
		Assert.assertNotEquals(id1, id2, "The id of Blue button is not changing after click");
		String Text1 = cdp.getBluebutton().getText();
		System.out.println("The text of blue button before clicking is: " + Text1);
		cdp.getBluebutton().click();
		String Text2 = cdp.getBluebutton().getText();
		System.out.println("The text of blue button after clicking is: " + Text2);
		Assert.assertNotEquals(Text1, Text2, "The text of Blue button is not changing after click");
	}

	// Test that checks the operation of red button
	@Test(priority = 4)
	public void validateRedButtonTest() {
		String id1 = cdp.getRedbutton().getAttribute("id");
		System.out.println("The id of red button before clicking is: " + id1);
		cdp.getRedbutton().click();
		String id2 = cdp.getRedbutton().getAttribute("id");
		System.out.println("The id of red button after clicking is: " + id2);
		Assert.assertNotEquals(id1, id2, "The id of Red button is not changing after click");
		String Text1 = cdp.getRedbutton().getText();
		System.out.println("The text of red button before clicking is: " + Text1);
		cdp.getRedbutton().click();
		String Text2 = cdp.getRedbutton().getText();
		System.out.println("The text of red button after clicking is: " + Text2);
		Assert.assertNotEquals(Text1, Text2, "The text of Red button is not changing after click");
	}

	// Test that checks the operation of green button
	@Test(priority = 5)
	public void validateGreenButtonTest() {
		String id1 = cdp.getGreenbutton().getAttribute("id");
		System.out.println("The id of green button before clicking is: " + id1);
		cdp.getGreenbutton().click();
		String id2 = cdp.getGreenbutton().getAttribute("id");
		System.out.println("The id of green button after clicking is: " + id2);
		Assert.assertNotEquals(id1, id2, "The id of green button is not changing after click");
		String Text1 = cdp.getGreenbutton().getText();
		System.out.println("The text of red button before clicking is: " + Text1);
		cdp.getGreenbutton().click();
		String Text2 = cdp.getGreenbutton().getText();
		System.out.println("The text of green button after clicking is: " + Text2);
		Assert.assertNotEquals(Text1, Text2, "The text of green button is not changing after click");
	}

	// Test that checks the headers of the static table
	@Test(priority = 6)
	public void validateTableHeadersTest() {
		List<WebElement> headers = cdp.validateTableHeaders();
		Assert.assertEquals(headers.get(0).getText(), "Lorem");
		Assert.assertEquals(headers.get(1).getText(), "Ipsum");
		Assert.assertEquals(headers.get(2).getText(), "Dolor");
		Assert.assertEquals(headers.get(3).getText(), "Sit");
		Assert.assertEquals(headers.get(4).getText(), "Amet");
		Assert.assertEquals(headers.get(5).getText(), "Diceret");
		Assert.assertEquals(headers.get(6).getText(), "Action");
	}

	// Test that checks the column contents of the static table
	@Test(priority = 7)
	public void validateTableColumn() {
		List<WebElement> column = cdp.validateTableColumn();
		Assert.assertEquals(column.get(0).getText(), "Iuvaret0");
		Assert.assertEquals(column.get(1).getText(), "Iuvaret1");
		Assert.assertEquals(column.get(2).getText(), "Iuvaret2");
		Assert.assertEquals(column.get(3).getText(), "Iuvaret3");
		Assert.assertEquals(column.get(4).getText(), "Iuvaret4");
		Assert.assertEquals(column.get(5).getText(), "Iuvaret5");
		Assert.assertEquals(column.get(6).getText(), "Iuvaret6");
		Assert.assertEquals(column.get(7).getText(), "Iuvaret7");
		Assert.assertEquals(column.get(8).getText(), "Iuvaret8");
		Assert.assertEquals(column.get(9).getText(), "Iuvaret9");
	}

	// Test that checks the row contents of the static table
	@Test(priority = 8)
	public void validateTableRow() {
		List<WebElement> column = cdp.validateTableRow();
		Assert.assertEquals(column.get(0).getText(), "Iuvaret0");
		Assert.assertEquals(column.get(1).getText(), "Apeirian0");
		Assert.assertEquals(column.get(2).getText(), "Adipisci0");
		Assert.assertEquals(column.get(3).getText(), "Definiebas0");
		Assert.assertEquals(column.get(4).getText(), "Consequuntur0");
		Assert.assertEquals(column.get(5).getText(), "Phaedrum0");
	}

	// Test that checks the change of url after clicking edit button
	@Test(priority = 9)
	public void validateEditTest() {
		String url = cdp.validateEdit();
		Assert.assertEquals(url, "https://the-internet.herokuapp.com/challenging_dom#edit");
	}

	// Test that checks the change of url after clicking delete button
	@Test(priority = 10)
	public void validateDeleteTest() {
		String url = cdp.validateDelete();
		Assert.assertEquals(url, "https://the-internet.herokuapp.com/challenging_dom#delete");
	}

	// Tests that checks the "answer" in the canvas

	// Test that checks "answer' is changing with page refresh
	@Test(priority = 11)
	public void validateCanvasTest1() {
		String answer1 = cdp.validateCanvas();
		System.out.println("Answer before page refresh is :" + answer1);
		driver.navigate().refresh();
		String answer2 = cdp.validateCanvas();
		System.out.println("Answer after page refresh is :" + answer2);
		Assert.assertNotEquals(answer1, answer2);
	}

	// Test that checks "answer' is changing with button click
	@Test(priority = 12)
	public void validateCanvasTest2() {
		String answer1 = cdp.validateCanvas();
		System.out.println("Answer before button click is :" + answer1);
		cdp.getBluebutton().click();
		String answer2 = cdp.validateCanvas();
		System.out.println("Answer after button click is :" + answer2);
		Assert.assertNotEquals(answer1, answer2);
	}

	// TearDown
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}