
public class EmployeeInfo implements Comparable<EmployeeInfo>{
	public String SerialNum;
	public String CompanyName;
	public String EmployeeName;
	public String Description;
	public String Leave;
	
	@Override
	public int compareTo(EmployeeInfo other) {
		return SerialNum.compareToIgnoreCase(other.SerialNum);
	}
	
	public boolean equals(EmployeeInfo other) {
		return SerialNum.equalsIgnoreCase(other.SerialNum);
	}
}
