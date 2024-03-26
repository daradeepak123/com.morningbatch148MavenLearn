package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	
	public String[] callCellData(String path,String sheetname) throws IOException
	{
		String data[]=new String[2];
		
		File file=new File(path);  //c:\\demo\\employee.xlsx
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet(sheetname);
		data=new String[2];
		data[0]=sheet.getRow(0).getCell(0).toString();
		data[1]=sheet.getRow(0).getCell(1).toString();
		
		
		
		return data;
		
	}
	
	

}
