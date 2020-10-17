
public class UserInfo implements Comparable<UserInfo>{
	public String Name;
	public String Address;
	public String Phone;
	
	public int compareTo(UserInfo other) {
		return Name.compareToIgnoreCase(other.Name);
	}
	
	public boolean equals(UserInfo other) {
		return Name.equalsIgnoreCase(other.Name);
	}
}
