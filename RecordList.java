package lab9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class RecordList implements Recordtemplete
{

	// Could use hashmap as well here, however I opted to demonstrate how ArrayList can be used
	public ArrayList<Record> recordList;

	/** default constructor */
	public RecordList()
	{
		recordList = new ArrayList<>();

	}

	/** get a Record given its index from the list of records */
	public Record get(int n)
	{
		return recordList.get(n);
	}

	/** Load records from a file, defined filename in RecordTemplate */
	public int loadRecords()
	{
		try
		{
			String line = null;
			BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
		
			
			while ((line = br.readLine()) != null) 
			{	
				if (line.trim().length()==0) continue;	// skip empty line
			
				// So convenient to use the overloaded construcor of Record that takes a Line!
				recordList.add(new Record(line));				
  			}
			br.close();
		}
		catch(IOException ioe)
		{
			System.err.println(ioe);
		}
		
		return recordList.size();
	}

	public void sort() // sort according to primary key defined in RecordTemplate
	{
   	// todo: make this support different data types such as dates, int etc.
		recordList.sort((Record r1, Record r2)->r1.getValue(PRIMARY_KEY_FIELD_INDEX).compareTo(r2.getValue(PRIMARY_KEY_FIELD_INDEX))); 
      //recordList.forEach((r)->System.out.println(r));   
	}
	
	public int size()
	{
		return recordList.size();
	}	

	public String toString()
	{
		String s="";

		// recordList.forEach(Record -> s+=Record);	// new in Java8 has an issue with not final error

		for (Record r : recordList)	// for each Record r in recordList...
		    s+=r+"\n";				// append r (toString) and a new line to the output string
		
		return s;	// this string will contain all the lines (ie. all the records)
	}
	
}
