package lab9;

import java.util.Scanner;
import java.util.InputMismatchException;

class ConsoleViewer extends RecordViewer
{
	// public RecordList records;   <-- that's already in the base class!

	public ConsoleViewer()
	{
		super();				// <-- base class constructor to create the list, load and sort it. 
	}

	public void displayViewer()
	{
		boolean done = false;
		currentRecord=0;
		char selection;

		displayRecord();

		do
		{	
			displayMenu();
			selection = getSelection("fnpleax");
			switch(selection)
			{
				case 'f':
					currentRecord = 0;
					displayRecord();
					break;
				case 'n':
					currentRecord = (currentRecord==records.size()-1)?currentRecord:currentRecord+1;
					displayRecord();
					break;
			 	case 'p':
					currentRecord = (currentRecord==0)?currentRecord:currentRecord-1;
					displayRecord();
					break;
				case 'l':
					currentRecord = records.size()-1;
					displayRecord();
					break;
				case 'e':
					System.out.println("TODO");
					break;
				case 'a':
					displayRecords();
					break;
				case 'x':
					done = true;
					break;
				default:
					// should not happen if you did the input right!
			}	
		}while(!done);
	}

	public void displayMenu()
	{
		System.out.print("[F]irst | [N]ext | [P]revious | [L]ast | [E]dit | [A]ll | E[x]it >>");
	}

	public void displayRecord()
	{
		System.out.println(records.get(currentRecord));
	}
	
	public char getSelection(String optionString)
	{

		Scanner sc = new Scanner(System.in);
		char c='x';
		String pattern = "["+optionString.toLowerCase() + optionString.toUpperCase()+"]";
		boolean done = false;
		
		do
		{
			try
			{
				c = sc.next(pattern).trim().charAt(0);	
				c =  Character.toLowerCase(c);
				done = true;
			}
			catch(InputMismatchException imme)
			{
				done = false;
			}
		}while(!done);
		sc.close();

		System.out.println("user selection = ["+c+"]");
		return c;

	}

	public void displayRecords()
	{
		System.out.println(records);	// recall that RecordList has a toString! 
								// not the best way to do this especially if you have a huge file.
	}

}