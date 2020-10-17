import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Collections;

import static java.lang.System.out;

public class DataTime{

	public static void main(String[] args) throws IOException {
		
		var fileName = "./src/Sample2000.csv";
		var filePath = Paths.get(fileName);
		
		if(!Files.exists(filePath)) 
			out.println("The File " + fileName + " could not be found");
		
		//Create ArrayList of Employee Infos
		var listUserInfo = new ArrayList<EmployeeInfo>();
		var readStream = Files.newBufferedReader(filePath);	
		var data = readStream.readLine();	
		
		var count=0;
		var startTime = System.currentTimeMillis();
		
		//Read data and add to ArrayList
		while(data!=null && data.length()>0) {

			//Add data to collection
			data = readStream.readLine();
			
			if(data!=null) {
			var elements = data.split(",");
			var user = new EmployeeInfo();
			user.SerialNum = elements[0];
			user.CompanyName = elements[1];
			user.EmployeeName = elements[2];
			user.Description = elements[3];
			user.Leave = elements[4];
			
			listUserInfo.add(user);		
			}
			count++;
		}
		readStream.close();
		
		//Sort in ascending order
		Collections.sort(listUserInfo);
		
		//Write sorted ArrayList to file
		var outFileName = "./src/ListSorted.txt";
		var outFilePath = Paths.get(outFileName);
		var writeStream = Files.newBufferedWriter(outFilePath);
		
		writeStream.write("Serial Number | Company Name | Employee Name | Description | Leave");
		writeStream.newLine();
		
		for(EmployeeInfo user: listUserInfo) {
			writeStream.write(user.SerialNum+" | "+user.CompanyName+" | "+user.EmployeeName+" | "+user.Description+" | "+user.Leave);
			writeStream.newLine();
		}
		writeStream.close();
		var endTime = System.currentTimeMillis();
		
		//Calculate and print total time and average time to process per item
		var listTime = endTime-startTime;
		
		out.println("Total time to read and process data using ArrayList: " + listTime);
		out.println("Average time to read and process data per line using ArrayList: "+
		Float.valueOf(listTime)/count);
		
		//Create TreeSet of Employee Infos
		var treeUserInfo = new TreeSet<EmployeeInfo>();
		readStream = Files.newBufferedReader(filePath);	
		data = readStream.readLine();		
		
		count=0;
		startTime = System.currentTimeMillis();
		
		//Read data and add to TreeSet
		while(data!=null && data.length()>0) {
			//Add data to collection
			data = readStream.readLine();
			
			if(data!=null) {
			var elements = data.split(",");
			var user = new EmployeeInfo();
			user.SerialNum = elements[0];
			user.CompanyName = elements[1];
			user.EmployeeName = elements[2];
			user.Description = elements[3];
			user.Leave = elements[4];
			
			treeUserInfo.add(user);
			}			
			count++;
		}
		
		
		outFileName = "./src/TreeReverseSorted.txt";
		outFilePath = Paths.get(outFileName);
		writeStream = Files.newBufferedWriter(outFilePath);
		
		writeStream.write("Serial Number | Company Name | Employee Name | Description | Leave");
		writeStream.newLine();
		
		for(EmployeeInfo user: treeUserInfo.descendingSet()) {
			writeStream.write(user.SerialNum+" | "+user.CompanyName+" | "+user.EmployeeName+" | "+user.Description+" | "+user.Leave);
			writeStream.newLine();
		}
		writeStream.close();
		
		endTime = System.currentTimeMillis();
		
		//Calculate and print total time and average time to process per item
		var treeTime = endTime-startTime;
		
		out.println("\nTotal time to read and process data using TreeSet: " + treeTime);
		out.println("Average time to read and process data per line using TreeSet: "+
		Float.valueOf(treeTime)/count);
		
	}
}