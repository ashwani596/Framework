package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities
{

	String filepath;
	public ExcelUtilities(String filepath)
	{
		this.filepath=filepath;
	}
	
	public String readData(String sheetName, int row, int cell)
	{
		String value=null;
		
		try
		{
			FileInputStream fis=new FileInputStream(new File(filepath));
			Workbook wb = WorkbookFactory.create(fis);
			Cell c1 = wb.getSheet(sheetName).getRow(row).getCell(cell);
			
			switch(c1.getCellType())
			{
			case STRING:
			value=c1.getStringCellValue();
				break;
			case NUMERIC:
				if(DateUtil.isCellDateFormatted(c1))
				{
					SimpleDateFormat sdf=new SimpleDateFormat("MMM dd, yyyy");
					value=sdf.format(c1.getDateCellValue());
				}
					else
					{
						long longvalue = (long)c1.getNumericCellValue();
						value=Long.toString(longvalue);
					}
					break;
					
			case BOOLEAN:
				
				value=Boolean.toString(c1.getBooleanCellValue());
				break;
				
				default:
					System.out.println("Cell format is not matching");
					break;
			}
			
		} 
		
		catch (EncryptedDocumentException e)
		{
			
		 e.printStackTrace();
			
		}
		
		catch (IOException e)
		{
			
		 e.printStackTrace();
			
		}
		
		return value;
		
	}
	
	
	
}
