import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	
	
	//identify test case column by scanning the entire 1st row
	//once column is identified then scan entire test case column to identify purchase testcase row 
	//after you grab purchase test case row =pull all the data oof that row and feed into test 

	
	public ArrayList<String> getData(String testcaseName) throws IOException {
		
		

		 ArrayList<String> a= new ArrayList();
		 
		FileInputStream fis =new FileInputStream("C:\\Users\\HP\\Downloads\\demodata.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		
		int Sheets=workbook.getNumberOfSheets();
		
		for(int i=0;i<Sheets;i++)
		{
			
			if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1"))
					{
			
			XSSFSheet sheet=workbook.getSheetAt(i);
			
			
			//identify test case column by scanning the entire 1st row
			
			   //here sheet has collection of rows
			
			Iterator<Row>row=sheet.iterator();  //to traverse each row  iterator is used
			
			  Row firstrow=  row.next();  //move to first row of excel sheet
			  
			  Iterator<Cell> cell= firstrow.cellIterator();  // to traverse each cell cell iterator  used
			  int k=0;
			  int column =0;
			  while(cell.hasNext())
			  {
				  if( cell.next().getStringCellValue().equalsIgnoreCase("TestCases"))
				  {
					  column=k;  // here we will get column number 
				  }
				  k++;
			  }
			System.out.println(column);
			
			//once column is identified then scan entire test case column to identify purchase testcase row 
			
			  while(row.hasNext())
			{
				Row r=row.next();
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
					
				{
					
					{
						//after you grab purchase test case row =pull all the data oof that row and feed into test 
						
						Iterator<Cell> cv=r.cellIterator();
						
						while(cv.hasNext())
							
						{
							
						    Cell c=cv.next();
						    
						    if(c.getCellType()==CellType.STRING)
						    {
						    	  a.add(c.getStringCellValue());
						    }
						    else
						    {
						    	 a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
						    	
						    }
						}
					}
				}
				
			}
			
		}
		
		
	}
		return a;

}

		
	
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	}
}
