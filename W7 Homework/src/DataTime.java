import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Map;
import static java.lang.System.out;

public class DataTime{

	public static void main(String[] args) throws IOException {
		var fileName = "./src/Sample2000.csv";
		var filePath = Paths.get(fileName);
		
		if(!Files.exists(filePath)) 
			out.println("The File " + fileName + " could not be found");
		
		var startTime = System.currentTimeMillis();
		
		//Create HashMap of UserInfos
		var userInfo = new HashMap<Integer,UserInfo>();
		var readStream = Files.newBufferedReader(filePath);	
		var data = readStream.readLine();		
		var key = 1;
		var elementCount = 0;
		
		//Add UserInfos to HashMap
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
			
			userInfo.put(key, user);
			
			key++;
			elementCount++;
			}
		}		
		
		var outFileName = "./src/HashData.txt";
		var outFilePath = Paths.get(outFileName);
		var writeStream = Files.newBufferedWriter(outFilePath);
		
		//Write HashMap to file
		writeStream.write("Serial Number | Company Name | Employee Name | Description | Leave");
		writeStream.newLine();
		
		for(Map.Entry<Integer,UserInfo> m: userInfo.entrySet()) {	
			writeStream.write(m.getValue().SerialNum+" | "+m.getValue().CompanyName+" | "+
			m.getValue().EmployeeName+" | "+m.getValue().Description+" | "+m.getValue().Leave);		
			writeStream.newLine();
		}
		writeStream.close();
		
		var endTime = System.currentTimeMillis();
		var hashTime = endTime-startTime;
		
		//Print total and average times to console
		out.println("Total time elapsed using HashMap: " + hashTime + " ms");
		out.println("Average time per line using HashMap: " 
		+ (Float.valueOf(hashTime)/elementCount) + " ms\n");
		
		//Create TreeSet of Employee Infos
		var treeUserInfo = new TreeSet<UserInfo>();
		readStream = Files.newBufferedReader(filePath);	
		data = readStream.readLine();		
		
		elementCount=0;
		startTime = System.currentTimeMillis();
		
		//Read data and add to TreeSet
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
			
			treeUserInfo.add(user);
			}			
			elementCount++;
		}
		
		//Write TreeSet to file
		outFileName = "./src/TreeData.txt";
		outFilePath = Paths.get(outFileName);
		writeStream = Files.newBufferedWriter(outFilePath);
		
		writeStream.write("Serial Number | Company Name | Employee Name | Description | Leave");
		writeStream.newLine();
		
		for(UserInfo user: treeUserInfo) {
			writeStream.write(user.SerialNum+" | "+user.CompanyName+" | "+user.EmployeeName+" | "+user.Description+" | "+user.Leave);
			writeStream.newLine();
		}
		writeStream.close();
		
		endTime = System.currentTimeMillis();
		
		//Calculate and print total time and average time to process per item
		var treeTime = endTime-startTime;
		
		out.println("Total time to read and process data using TreeSet: " + treeTime + " ms");
		out.println("Average time to read and process data per line using TreeSet: "+
		(Float.valueOf(treeTime)/elementCount) + " ms");
	}
}
