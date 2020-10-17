import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Stack;

public class FileIO5 {

	public static void main(String[] args) throws IOException{
		var fileName = "./src/data.txt";
		var filePath = Paths.get(fileName);
		
		if(!Files.exists(filePath))
			System.out.println("The File " + fileName + "could not be found");
		
		var userInfos = new TreeSet<UserInfo>();
		
		var dataElementCount = 0;
		var readStream = Files.newBufferedReader(filePath);
		var data = readStream.readLine();
		
		while(data!=null) {
			data = readStream.readLine();
			if(data!=null) {
				var elements = data.split(",");
				var userInfo = new UserInfo();
				userInfo.Name = elements[0];
				userInfo.Address = elements[1];
				userInfo.Phone = elements[2];
				userInfos.add(userInfo);
			}
				
		}
		
		readStream.close();
		
		var outFileName = "./src/data_sorted.txt";
		var outFilePath = Paths.get(outFileName);
		var writeStream = Files.newBufferedWriter(outFilePath);
		for(var userData : userInfos) {
			writeStream.write(userData.Name.toUpperCase()+"|"+userData.Address+"|"+userData.Phone);
			writeStream.newLine();
		}		
		writeStream.close();
	}
	
}
