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

public class DataDriven2 {
	
	
	
	public  ArrayList getData(String testName) throws IOException
	{
		 ArrayList <String> al =new ArrayList();
		  FileInputStream fis =new FileInputStream("C:\\Users\\HP\\Downloads\\testdata.xlsx");
		   XSSFWorkbook wrkbook =new XSSFWorkbook(fis);
		   
		   
		 int sheets= wrkbook.getNumberOfSheets();
		 
		 for (int i=0;i<sheets;i++)
		 {
		       if(wrkbook.getSheetName(i).equalsIgnoreCase("sheet1"))
		    		   {
		    	   
		    	   XSSFSheet sheet=  wrkbook.getSheetAt(i);
		    	   
		    	   Iterator<Row>row =   sheet.iterator();
		    	   
		    	   Row r1=  row.next();
		    	   
		    	   Iterator<Cell> cell= r1.cellIterator();
		    	   int k=0;
		    	   int column=0;
		    	   while(cell.hasNext())
		    	   {
		    		  Cell c1= cell.next();
		    		    
		    		    if(c1.getStringCellValue().equalsIgnoreCase("Name"))
		    		    {
		    		    	column=k;
		    		    }
		    		    k++;
		    	   }
		    	   

		    		System.out.println(column);
		    	     
		    		
		    		 while(row.hasNext())
		    		 {
		    			Row r2= row.next();
		    			 if(r2.getCell(column).getStringCellValue().equalsIgnoreCase(testName))
		    			 {
		    				Iterator <Cell> c2= r2.cellIterator();
		    				while(c2.hasNext())
		    				{
		    				Cell c22=c2.next();	
		    				
		    				if(c22.getCellType()==CellType.STRING)
		    				{ 
		    				al.add( c22.getStringCellValue());
		    				    
		    				 }
		    				else
		    				{
		    				 al.add(   NumberToTextConverter.toText(c22.getNumericCellValue()));
		    				}
		    			 }
		    		 }
		    	 
		    		   }
		       
		          
		 }
		       
	}
		return al;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
  
	}
}

