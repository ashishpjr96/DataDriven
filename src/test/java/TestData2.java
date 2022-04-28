import java.io.IOException;
import java.util.ArrayList;

public class TestData2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		   DataDriven2 data= new DataDriven2();
		      
		   ArrayList data1= data.getData("ravi");
		   
		  System.out.println(  data1.get(0));
		  System.out.println(  data1.get(1));
		  System.out.println(  data1.get(2));
		  System.out.println(  data1.get(3));
		    
	}

}
