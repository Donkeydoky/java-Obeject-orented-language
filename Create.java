package lab9;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Create implements Recordtemplete{
	
	private RecordList crecords;
	private Scanner sc = new Scanner(System.in);
	
	public Create() {
		File file = new File(FILE_PATH);
		String s = "";
		boolean validData = true;
		
		while (validData) {
			System.out.println("Enter the records:Each record is a line containing the first name,"
				+ "\n last name and the date of birth in this format mm/dd/yyyy.");
			System.out.println("Please enter a record, enter -1 when done: \n");
		
			s += sc.nextLine();
			s += "\n";
		
			if(s.compareToIgnoreCase( " ") == 0 || s.compareToIgnoreCase("-1") == 0){
				validData = false;
			}
		}
		try{
			PrintWriter output = new PrintWriter(file);
			output.println(s);
			  // some code goes here...
			}catch(IOException e){
			  System.out.printf("ERROR: %s\n", e);
			}
	}
}
