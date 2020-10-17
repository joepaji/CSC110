import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeSet;
import static java.lang.System.out;

public class DataStructuresP2{

	public static void main(String[] args) throws IOException {
		
		var StartTime = System.currentTimeMillis();
		var fileName = "./src/Sample500.csv";
		var filePath = Paths.get(fileName);
		
		if(!Files.exists(filePath)) 
			out.println("The File " + fileName + " could not be found");
		
		var userInfo = new TreeSet<UserInfo>();
		var readStream = Files.newBufferedReader(filePath);	
		var data = readStream.readLine();		
		
		while(data!=null && data.length()>0) {
			//Add data to collection
			data = readStream.readLine();
			
			if(data!=null) {
			var elements = data.split(",");
			var user = new UserInfo();
			user.SerialNum = elements[0];
			user.CompanyName = elements[1];
			user.EmployeeName = elements[2];
			user.Description = elements[3];
			user.Leave = elements[4];
			
			userInfo.add(user);
			}
		}
		
		out.println
		("Serial Number | Company Name | Employee Name | Description | Leave\n");
		
		for(var users : userInfo) {			
			out.println(users.SerialNum+" | "+users.CompanyName+" | "+
			users.EmployeeName+" | "+users.Description+" | "+users.Leave);						
		}
		
		var EndTime = System.currentTimeMillis();
		
		out.println("Time to run: "+(EndTime-StartTime)+" ms");
	}
}
