
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileIO3 {

	public static void main(String[] args) throws IOException{
		var fileName = "./src/data.txt";
        // it is a good habit to check if the file can be found using java code
        var filePath = Paths.get(fileName);
        if(!Files.exists(filePath)){
            System.out.println("The File "+ fileName + " Could not be found");
        }
        
        // *** Arrays/collections are data structure in memory storage 
        var userInfos = new ArrayList<String>(); 
        var readStream = Files.newBufferedReader(filePath);
        var data = readStream.readLine(); // skip the line as this line is usually the header
      
        // ** new key word looping with Java key word while

        while(data !=null){ // ** null in java signifies that the value is unknown                 
            data = readStream.readLine(); // read the data line
            if(data !=null ){
                userInfos.add(data);
            }                
        }

        for (var userData : userInfos) {
            var elements  = userData.split(",|\\+");   // split the data with comma as the separator
            if(!elements[0].startsWith("X"))
            System.out.println(elements[0]+"-"+elements[1]+"-"+elements[2]); 
        }  
        System.out.println("-------------------------");   
    }      

}


