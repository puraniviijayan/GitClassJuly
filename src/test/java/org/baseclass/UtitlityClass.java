package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UtitlityClass {

	public static WebDriver driver;

	public static WebDriver browserLaunch(String browserName) {
		switch (browserName) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
		default:
			break;
		}

		return driver;
	}

	public static void loadUrl(String url) {
		driver.get(url);
	}

	public static void windowMaxmize() {
		driver.manage().window().maximize();
	}

	public static void type(WebElement ele, String data) {
		ele.sendKeys(data);
	}

	public static void btnClick(WebElement ele) {
		ele.click();
	}

	public static void quitBrowser() {
		driver.quit();
	}

	public static void clearTextbox(WebElement ele) {
		ele.clear();
	}

	public static Date currentTime() {
		Date date = new Date();
		return date;
	}

	public static String pageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static String currentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public boolean eleDisplayed(WebElement ele) {
		boolean displayed = ele.isDisplayed();
		return displayed;
	}

	public static String getTextEle(WebElement ele) {
		String text = ele.getText();
		return text;
	}

	public static String attribute(WebElement ele, String att) {
		String attribute = ele.getAttribute(att);
		// String domAttribute = ele.getDomProperty(att);

		return attribute;

	}

	public void rightClick(WebElement ele) {
		Actions acc = new Actions(driver);
		acc.contextClick(ele).perform();
	}

	public void moveToEle(WebElement ele) {
		Actions acc = new Actions(driver);
		acc.moveToElement(ele).perform();
	}

	public void acceptAlert() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	public void screenshot(String imagename) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File dest = new File(
				"C:\\Users\\DELL\\eclipse-workspace\\MavenProjectDec21\\target\\Screenshots" + imagename + ".png");
		FileUtils.copyFile(src, dest);
	}

	public void jsEnterText(String val, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + val + "')", ele);
	}

	public void navigateToURL(String url) {
		driver.navigate().to(url);
	}

	public void drpSelectByValue(WebElement ele, String val) {
		Select sel = new Select(ele);
		sel.selectByValue(val);
	}

	public static void drpSelectByVisibleText(WebElement ele, String text) {
		Select sel = new Select(ele);
		sel.selectByVisibleText(text);
	}

	public List<WebElement> drpGetOptions(WebElement ele) {
		Select sel = new Select(ele);
		List<WebElement> options = sel.getOptions();
		return options;
	}

	public static void implicitWait(long sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	public static String excelRead(String sheetName, int rowNo, int cellNo) throws IOException {
		String value = null;
		File excelLoc = new File("C:\\Users\\DELL\\eclipse-workspace\\CucumberProjectJan17\\Excel\\Data.xlsx");
		FileInputStream fin = new FileInputStream(excelLoc);
		Workbook workbook = new XSSFWorkbook(fin);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			value = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				value = sdf.format(date);
			} else {
				value = String.valueOf((long) cell.getNumericCellValue());
			}
			break;
		default:
			break;
		}
		return value;
	}

	public void excelUpdate(String sheetName, int rowNo, int cellNo, String value) throws IOException {
		File excelLoc = new File("C:\\Users\\DELL\\eclipse-workspace\\MavenProjectDec21\\Excel\\Data.xlsx");
		FileInputStream fin = new FileInputStream(excelLoc);
		Workbook workbook = new XSSFWorkbook(fin);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		cell.setCellValue(value);
		FileOutputStream fout = new FileOutputStream(excelLoc);
		workbook.write(fout);
	}

	public static void deleteCookies() {
		driver.manage().deleteAllCookies();
	}
	
	public void apiTesting() {
		System.out.println("Postman");
	}

	public void mobileTesting() {
		System.out.println("Appium");
	}

	public void webTesting() {
		System.out.println("Selenium");
	}
	
	public void java() {
		System.out.println("JAVA");
	}

	public void python() {
		System.out.println("PYTHON");
	}

	public void js() {
		System.out.println("JAVASCRIPT");
	}

}
