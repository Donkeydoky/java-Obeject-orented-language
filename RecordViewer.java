package lab9;

abstract class RecordViewer implements Recordtemplete
{
	public RecordList records;		// the master RecordList loaded from a file
	public int currentRecord;		// you view a currentRecord by its index

	public abstract void displayViewer();

	// The idea behind the constructor is that when you instantiate a RecordViewer you
	// shall have the RecordList created and loaded from the file, all sorted and ready to be viewed. 
	public RecordViewer()
	{
		records = new RecordList();
		records.loadRecords();
		records.sort();
	}

}