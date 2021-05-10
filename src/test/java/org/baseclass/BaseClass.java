package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.FileChooserUI;
import javax.swing.text.Element;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;

	public static void getDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mohamemr\\eclipse-workspace\\Mavenn\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void enterText(WebElement element, String data) {
		element.sendKeys(data);
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void quitWebpage() {
		driver.quit();

	}

	public static void close() {
		driver.close();
	}

	public static WebElement findElementId(String value) {
		WebElement findElement = driver.findElement(By.id(value));
		return findElement;

	}

	public static WebElement findElementname(String value) {
		WebElement findElement = driver.findElement(By.name(value));
		return findElement;

	}

	public static WebElement findElementxpath(String value) {
		WebElement findElement = driver.findElement(By.xpath(value));
		return findElement;

	}

	public static void getText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

	public static void getAttribute(WebElement element, String s) {
		String attribute = element.getAttribute(s);
		System.out.println(attribute);
	}

	public static void maximize() {
		driver.manage().window().maximize();
	}

	public static void waitt() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static void mouseOver(WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
	}

	public static void dragAndDrop(WebElement element, WebElement element1) {
		Actions ac = new Actions(driver);
		ac.dragAndDrop(element, element1).build().perform();

	}

	public static void dragAndDropNew(WebElement element, WebElement element2) {
		Actions ac = new Actions(driver);
		ac.clickAndHold(element).moveToElement(element2).release(element2).perform();
	}

	public static void rightClick(WebElement element) {
		Actions ac = new Actions(driver);
		ac.contextClick(element).perform();
	}

	public static void doubleClick(WebElement element) {
		Actions ac = new Actions(driver);
		ac.doubleClick(element).perform();
	}

	public static void keyUpAndKeyDown(WebElement element, String data) {
		Actions ac = new Actions(driver);
		ac.keyDown(element, Keys.SHIFT).sendKeys(element, data).keyUp(element, Keys.SHIFT).perform();
	}

	public static void alertAccept() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	public static void alertDismiss() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}

	public static void alertSendkeys(String data) {
		Alert al = driver.switchTo().alert();
		al.sendKeys(data);
	}

	public static void alertGetText() {
		Alert al = driver.switchTo().alert();
		String text = al.getText();
		System.out.println(text);

	}

	public static void jsInsert(String s, WebElement element) {
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		jk.executeScript("arguments[0].setAttribute('value','" + s + "')", element);
	}

	public static void jsGet(WebElement element) {
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		jk.executeScript("arguments[0].getAttribute('value')", element);
	}

	public static void jsClick(WebElement element) {
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		jk.executeScript("arguments[0].click()", element);
	}

	public static void scrollDownByJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public static void scrollUpByJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	public static void selectByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public static void selectByText(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByVisibleText(value);
	}

	public static void selectByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);

	}

	public static void selectMultiple(WebElement element) {
		Select s = new Select(element);
		s.isMultiple();
	}

	public static void selectGetOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			String text = webElement.getText();
			s.selectByVisibleText(text);
			System.out.println(text);
		}
	}

	public static void selectGetAllOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (int i = 0; i < allSelectedOptions.size(); i++) {
			WebElement webElement = allSelectedOptions.get(i);
			String text = webElement.getText();
			System.out.println(text);
		}

	}

	public static void selectGetFirstOptions(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		System.out.println(text);
	}

	public static void selectDeSelectAll(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}

	public static void selectDeSelectByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.deselectByValue(value);
	}

	public static void selectDeSelectByText(WebElement element, String value) {
		Select s = new Select(element);
		s.deselectByVisibleText(value);
	}

	public static void selectDeSelectByValue(WebElement element, int id) {
		Select s = new Select(element);
		s.deselectByIndex(id);
	}

	public static void screenShot(String data) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);

		File dest = new File(data);
		FileHandler.copy(src, dest);

	}

	public static void frameId(String id) {
		driver.switchTo().frame(id);
	}

	public static void frameName(String name) {
		driver.switchTo().frame(name);
	}

	public static void frameIndex(int index) {
		driver.switchTo().frame(index);
	}

	public static void frameWebElement(String element) {
		driver.switchTo().frame(element);
	}

	public static void windowHandle(int i) {
		String element = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();

		List<String> l = new ArrayList();
		l.addAll(windowHandles);
		driver.switchTo().window(l.get(i));
	}

	// public static void getString(String s,String s1) {

	// }

	public static String getDataFromExcel(String Filename, String name, int rowNo, int cellNo) throws IOException {
		File file = new File("C:\\Users\\mohamemr\\eclipse-workspace\\Mavenn\\Excel\\"+Filename+".xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(name);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		int cellType = cell.getCellType();
		String value = "";
		if (cellType == 1) {
			value = cell.getStringCellValue();
		}
		if (cellType == 0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yy");
				value = format.format(dateCellValue);
			} else {
				double d = cell.getNumericCellValue();
				long l = (long) d;
				value = String.valueOf(l);
			}

		}
		return value;

	}

	public static void excelDataWriteAtt(String Filename, String name,WebElement element, int rowNo, int cellNo)
			throws IOException {
		File file = new File(Filename);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(name);
		String text=element.getAttribute("value");
		Row row = sheet.getRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(text);
		FileOutputStream f = new FileOutputStream(file);
		workbook.write(f);
	}
	
	public static void excelDataWriteText(String Filename, String name,WebElement element, int rowNo, int cellNo)
			throws IOException {
		File file = new File(Filename);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(name);
		String text=element.getText();
		Row row = sheet.createRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(text);
		FileOutputStream f = new FileOutputStream(file);
		workbook.write(f);
	}
}
