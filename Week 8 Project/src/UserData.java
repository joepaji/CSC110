import static java.lang.System.out;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeSet;

public class UserData {
	public static void main(String[] args) throws IOException {
		
		var fileName = "./src/Sample2000.csv";
		var filePath = Paths.get(fileName);
		
		if(!Files.exists(filePath)) 
			out.println("The File " + fileName + " could not be found");
		
		var startTime = System.currentTimeMillis();
		
		//Create TreeSet of Employee Infos
		var treeUserInfo = new TreeSet<UserInfo>();
		var readStream = Files.newBufferedReader(filePath);	
		var data = readStream.readLine();	
		
		var LineCount = 0;
		
		var outFileName = "./src/BadData.txt";
		var outFilePath = Paths.get(outFileName);
		var writeStream = Files.newBufferedWriter(outFilePath);
		
		var isBadData = false;
		
		//Read data and add to TreeSet
		while(data!=null && data.length()>0) {
			//Add data to collection
			data = readStream.readLine();
			LineCount++;
			
			if(data!=null) {
				var elements = data.split(",");
				var user = new UserInfo();
					
				if(elements.length < 8) isBadData = true;
				else {
					if(!elements[0].isBlank()) 
						user.SerialNum = elements[0];
					else isBadData = true;
					
					if(!elements[1].isBlank())
						user.CompanyName = elements[1];
					else isBadData = true;
					
					if(!elements[2].isBlank())
						user.EmployeeName = elements[2];
					else isBadData = true;
					
					if(!elements[3].isBlank())
						user.Description = elements[3];
					else isBadData = true;
					
					if(!elements[4].isBlank())
						user.Leave = elements[4];
					else isBadData = true;
					
					if(!elements[5].isBlank())
						user.Phone = elements[5];
					else isBadData = true;
					
					if(!elements[6].isBlank())
						user.Address = elements[6];
					else isBadData = true;
					
					user.Time = elements[7];
				}			
				
				if(!isBadData)
					treeUserInfo.add(user);
				else {
					writeStream.write("Row number: " + LineCount);
					writeStream.newLine();
					isBadData = false;
				}
			}		
		}
		
		readStream.close();
		writeStream.close();
		
		outFileName = "./src/GoodData.txt";
		outFilePath = Paths.get(outFileName);
		writeStream = Files.newBufferedWriter(outFilePath);
		
		writeStream.write("Serial Number | Company Name | Employee Name "
				+ "| Description | Leave | Phone Number | Address | Time in role");
		writeStream.newLine();
		
		for(UserInfo user: treeUserInfo) {
			writeStream.write(user.SerialNum+" | "+user.CompanyName+" | "+user.EmployeeName+" | "+user.Description+" | "+user.Leave
					+user.Phone+" | "+user.Address+" | "+user.Time);			
			writeStream.newLine();
		}
		writeStream.close();
		
		var endTime = System.currentTimeMillis();
		
		out.println("Data Structure: TreeSet");
		out.println("Time taken: " + (endTime-startTime) + " ms");
	}
}
