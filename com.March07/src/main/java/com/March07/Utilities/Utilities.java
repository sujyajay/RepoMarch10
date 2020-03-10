package com.March07.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.March07.Master.Master;

public class Utilities extends Master{ 
	
	
	public static String getScreenShot() {
		
//		String pattern = "YYYYMMDD";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		String name = simpleDateFormat.format(new Date());		
		
		
		TakesScreenshot screen = (TakesScreenshot)driver;
		
		File src = screen.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Batman\\Desktop\\POC-DockerContainer\\com.March07\\Reports\\screenshot.png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return "C:\\Users\\Batman\\Desktop\\POC-DockerContainer\\com.March07\\Reports\\screenshot.png";		
		
	}	
	
	public static String[][] readExcelData() throws IOException{
		
		
		String excelFilePath = "C:\\Users\\Batman\\Desktop\\POC-DockerContainer\\com.March07\\src\\test\\resources\\order.xlsx";
		
		XSSFWorkbook workbook  = new XSSFWorkbook(excelFilePath) ;
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
		int columnCount = row.getLastCellNum();
		int rowCount = sheet.getLastRowNum();
		
		String[][] data = new String[rowCount][columnCount];
		
		for(int i=1;i<=rowCount;i++)
		{
			row = sheet.getRow(i);
			for(int j=0;j<columnCount;j++) {
				
				data[i-1][j] = row.getCell(j).toString();				
				System.out.println(data[i-1][j]);
			}
		
		}
		
		return data;
		
	}
	
	

}
