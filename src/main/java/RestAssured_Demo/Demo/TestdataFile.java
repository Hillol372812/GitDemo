package RestAssured_Demo.Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestdataFile {

	public static void main(String[] args) throws IOException {}
	
	public static ArrayList<String> TestData() throws IOException {



	
	FileInputStream fis = new FileInputStream("D://RahulShetty_RestAssured//DataSheet.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	
	ArrayList<String> List = new ArrayList<String>();
	 int Sheets=workbook.getNumberOfSheets();
	 
	 for(int i=0;i<Sheets;i++)
	 {
		 if(workbook.getSheetAt(i).getSheetName().equalsIgnoreCase("Login_Data"))
		 {
			 XSSFSheet Worksheet=workbook.getSheetAt(i);
			 
			 Iterator<Row>  row =Worksheet.iterator();
			 Row firstrow =row.next();
			Iterator<Cell> CE=firstrow.cellIterator();
			
			int k=0;
			int column = 0;
			 while(CE.hasNext())
			 {
				 Cell  value =CE.next();
				 
				 if(value.getStringCellValue().equalsIgnoreCase("Testcase"))
				 {
					 column=k; 
				 }
				 k++;
				 
			 }
			 System.out.println("Value of column : "+column);
			 
			 while(row.hasNext()) {
				 
				Row Firstrow=row.next();
				if (Firstrow.getCell(column).getStringCellValue().equalsIgnoreCase("Testcase_1")) {
					
					 Iterator<Cell> value=Firstrow.cellIterator();
					 while(value.hasNext())
					 {
						Cell data=value.next();
						
						List.add(data.getStringCellValue());
						
					 }
					// System.out.println(List);
				}
				 
			 }
			 
			 
		 }
	 }

 return List;

}
	
			
			
			
			

}
