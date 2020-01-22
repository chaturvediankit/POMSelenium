package com.Web;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileManager {

	//To read property file
	public	 String pReader(String property) throws IOException{
			FileReader reader=new FileReader("src/main/resources/login.properties");
			Properties p=new Properties();
			p.load(reader);
			String value=p.getProperty(property);
			System.out.println(value);
			 return value;
			 }
	//To Write property file
	public void setProperties(String key,String value){
		File configFile = new File("src/main/resources/login.properties");
		try {
		    Properties props = new Properties();
		    props.setProperty(key, value);
		    FileWriter writer = new FileWriter(configFile);
		    props.store(writer, "request settings");
		    writer.close();
		} catch (FileNotFoundException ex) {
		} catch (IOException ex) {
		}
	}
	
	//Robot framework to upload file
	public void uploadFile(String fileName) throws AWTException{
			StringSelection ss = new StringSelection(fileName);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
		}
	public String [][] readExcelFile( String filePath) throws IOException {
				String data [][]= new String [4][3];
				//String filePath = System.getProperty("user.dir")+"/UserCredentials.xlsx";
				FileInputStream excelfile=new FileInputStream(filePath);
				XSSFWorkbook workbook =new XSSFWorkbook(excelfile);
				XSSFSheet sheet=workbook.getSheetAt(0);
				for (int i=1;i<5;i++){
					XSSFRow row=sheet.getRow(i);
					for(int j=0;j<3;j++){
					data[i-1][j]=row.getCell(j).getStringCellValue();
					System.out.println(data[i-1][j]);
					}
				}
				//workbook.close();
				return data;
	 	}
	public static String getXLSData(String strExcelFilePath, String strSheetName, int iRowNumber, int iColumn) {
		String strData = "";
		try {
			HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(strExcelFilePath));
			HSSFSheet myExcelSheet = myExcelBook.getSheet(strSheetName);
			strData = String.valueOf(myExcelSheet.getRow(iRowNumber).getCell(iColumn));
			return strData;

		} catch (Exception e) {
			return strData;
		}

	}

	// This will read the row count from from .xls files
	public static int getXLSRowCount(String strExcelFilePath, String strSheetName) {
		int iRowcount = 0;
		try {
			HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(strExcelFilePath));
			HSSFSheet myExcelSheet = myExcelBook.getSheet(strSheetName);

			iRowcount = myExcelSheet.getLastRowNum();

			return iRowcount;

		} catch (Exception e) {
			return iRowcount;
		}

	}

	// This will read the column count from from .xls files
	public static int getXLSColCount(String strExcelFilePath, String strSheetName) {
		int iColcount = 0;
		try {
			HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(strExcelFilePath));
			HSSFSheet myExcelSheet = myExcelBook.getSheet(strSheetName);
			iColcount = myExcelSheet.getRow(0).getLastCellNum();
			return iColcount;

		} catch (Exception e) {
			return iColcount;
		}

	}

	// This will read data from .xlsx,s.xlsm, files
	public static String getXLSXData(String strExcelFilePath, String strSheetName, int iRowNumber, int iColumn) {
		String strData = "";
		try {
			FileInputStream inputStream = new FileInputStream(new File(strExcelFilePath));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet myExcelSheet = workbook.getSheet(strSheetName);
			strData = String.valueOf(myExcelSheet.getRow(iRowNumber).getCell(iColumn));
			return strData;

		} catch (Exception e) {
			return strData;
		}

	}

	// This will read the row count from from .xls files
	public static int getXLSXRowCount(String strExcelFilePath, String strSheetName) {
		int iRowcount = 0;
		try {
			FileInputStream inputStream = new FileInputStream(new File(strExcelFilePath));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet myExcelSheet = workbook.getSheet(strSheetName);
			iRowcount = myExcelSheet.getLastRowNum();

			return iRowcount;

		} catch (Exception e) {
			return iRowcount;
		}

	}

	// This will read the column count from from .xls files
	public static int getXLSXColCount(String strExcelFilePath, String strSheetName) {
		int iColcount = 0;
		try {
			FileInputStream inputStream = new FileInputStream(new File(strExcelFilePath));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet myExcelSheet = workbook.getSheet(strSheetName);
			iColcount = myExcelSheet.getRow(0).getLastCellNum();
			return iColcount;

		} catch (Exception e) {
			return iColcount;
		}

	}

	}
