public class UserInfo implements Comparable<UserInfo>{
	public String SerialNum;
	public String CompanyName;
	public String EmployeeName;
	public String Description;
	public String Leave;
	public String Phone;
	public String Address;
	public String Time;
	
	@Override
	public int compareTo(UserInfo other) {
		return SerialNum.compareToIgnoreCase(other.EmployeeName);
	}
	
	public boolean equals(UserInfo other) {
		return SerialNum.equalsIgnoreCase(other.EmployeeName);
	}
}