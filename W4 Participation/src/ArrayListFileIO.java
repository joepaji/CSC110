import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.out;


public class ArrayListFileIO {

	public static void main(String[] args)throws IOException {
		var fileName = "./src/data.txt";
		var filePath = Paths.get(fileName);
				
		//Check if file exists at given path
		if(!Files.exists(filePath)) 
			out.println("The File " + fileName + " could not be found");
		
		var userInfos = new ArrayList<>();
		var readStream = Files.newBufferedReader(filePath);	
		var data = readStream.readLine();		
		
				
		while(data!=null && data.length()>0) {
			//Add data to collection
			userInfos.add(data);
			data = readStream.readLine();
		}
		
		//Sorting ArrayList in reverse order
		Collections.sort(userInfos, Collections.reverseOrder());
		
		//Print sorted array
		for(Object item:userInfos) out.println(item);
		
	}	

}


