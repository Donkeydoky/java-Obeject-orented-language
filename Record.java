/** Record is a class that abstracts a single record in a file.
    A Record is a list (hashmap) of ordered Fields.
    Hence an inner class "Field" is defined as an abstraction where one Record
    may contain any number of Fields, and a Field contains a field label, type and value.
*/

package lab9;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Iterator;

public class Record implements Recordtemplete
{	

	public HashMap<Integer, Field> recordMap;

	/** A valuable public utility method that allows me to create a record from a line!
         The actual line is a comma delimited list of field values that we read from a file
         This method simply parses a given line and generates a record with all the fields
         according to the RecordTemplate definitions. 
     */
	public Record(String line)	// create a record from a line
	{
		int i;
		recordMap = new HashMap<>(); 
		StringTokenizer st = new StringTokenizer(line, DELIMITER);

		for (i=0; i < NUMBER_OF_FIELDS; i++)
		{
			recordMap.put(i, new Field(FIELD_TYPES[i], FIELD_LABELS[i], st.nextToken()));
		}		
	}	

	/** A Record has a list of fields - use this set method to change the value of
         any field by its index.

	*/
	public boolean setFieldValue(int fieldIndex, String newValue)
	{
		if (fieldIndex < 0 || fieldIndex > NUMBER_OF_FIELDS) return false;

		Field newField = new Field(recordMap.get(fieldIndex).type, recordMap.get(fieldIndex).label, newValue);

		recordMap.replace(fieldIndex, newField);

		return true;
	}

	/** toString for a given Record - demonstrate the use of Iterator over a list */
	public String toString()
	{
		String line="";
		Iterator<Integer> keySetIterator = recordMap.keySet().iterator(); 
		Integer key;
		while(keySetIterator.hasNext())
		{ 
			key = keySetIterator.next(); 
			if (key == 0) line+=recordMap.get(key);
			else line+=DELIMITER+recordMap.get(key); 
		}
		return line;
	}

	/** useful bunch of gets.... */
	public String getType(int fieldIndex)	// fieldIndex same as column number in file
	{
		return recordMap.get(fieldIndex).type;
	}
	public String getLabel(int fieldIndex)
	{
		return recordMap.get(fieldIndex).label;
	}
	public String getValue(int fieldIndex)
	{
		return recordMap.get(fieldIndex).value;
	}


	// inner class Field; a Record has many Fields...A Field has type, label and value
	// e.g. Field: String first_name Jim
	class Field
	{
		public String type;
		public String label;
		public String value;

		public Field(String type, String label, String value)
		{
			this.type = type;
			this.label = label;
			this.value = value;
		}

		public String toString()
		{
			return type + " " + label + " " + value;
		}
	}

}

