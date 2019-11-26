package lab9;

public interface Recordtemplete {
	
	public static final String[] FIELD_LABELS = {"First Name", "Last Name", "Date of Birth"};
	public static final String[] FIELD_TYPES = {"String", "String", "Date"};
	public static final String FILE_PATH = "/Users/xuliangliang/eclipse-workspace/SecondYear/java212/record.txt";
	public static final String DELIMITER = ",";
	public static final int PRIMARY_KEY_FIELD_INDEX = 1; // last name
}
