package com.HybridFramework.excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	public String[][] getExcelData(String excellocation, String sheetName)
	{
		try 
		{
			String datasets[][]= null;
			FileInputStream file = new FileInputStream(new File(excellocation));
			
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			
			int totalrow = sheet.getLastRowNum() + 1;
			int totalcolumn = sheet.getRow(0).getLastCellNum();
			
			datasets = new String[totalrow -1][totalcolumn];
			
			 Iterator<Row> rowIterator = sheet.iterator();
			 
			 int i = 0;
			 int t = 0;
			 
			 while(rowIterator.hasNext())
			 {
				 Row row = rowIterator.next();
				 if(i++ != 0)
				 {
					 int k = t;
					 t++;
					 Iterator<Cell> cellIterator = row.cellIterator();
					 int j = 0;
					 while(cellIterator.hasNext())
					 {
						 Cell cell = cellIterator.next();
						 switch(cell.getCellType())
						 {
						 case Cell.CELL_TYPE_NUMERIC:
							 System.out.print(k + ",");
							 System.out.print(j);
							 datasets[k][j++] = cell.getStringCellValue();
							 System.out.println(cell.getNumericCellValue());
							 break;
						 case Cell.CELL_TYPE_STRING:
							 System.out.print(k + ",");
							 System.out.print(j);
							 datasets[k][j++] = cell.getStringCellValue();
							 System.out.println(cell.getStringCellValue());
							 break;
						 case Cell.CELL_TYPE_BOOLEAN:
							 System.out.print(k + ",");
							 System.out.print(j);
							 datasets[k][j++] = cell.getStringCellValue();
							 System.out.println(cell.getStringCellValue());
							 break;
						 case Cell.CELL_TYPE_FORMULA:
							 System.out.print(k + ",");
							 System.out.print(j);
							 datasets[k][j++] = cell.getStringCellValue();
							 System.out.println(cell.getStringCellValue());
							 break;
						 }
					 }
					 System.out.println("");
				 }
			}
			 
			 file.close();
			 return datasets;
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		return null;
		}

	
	public static void main(String[] args) 
	{
		String excellocation = System.getProperty("user.dir")+"\\src\\main\\java\\com\\HybridFramework\\data\\TestData.xlsx";
		String sheetName = "LoginTestData";
		ExcelReader excel = new ExcelReader();
		excel.getExcelData(excellocation, sheetName);		
	}
	}
