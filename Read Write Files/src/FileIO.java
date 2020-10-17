import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.lang.System.out;

public class FileIO {

	public static void main(String[] args) throws IOException{
		var fileName = "./src/data.txt";
		var filePath = Paths.get(fileName);
		
		if(!Files.exists(filePath)) 
			out.println("The File " + fileName + " could not be found");
		
		var readStream = Files.newBufferedReader(filePath);	
		var data = readStream.readLine();
		
		var lineNumber = 1;
		
		while(data!=null) {
			out.println(lineNumber + " The data: " + data.toUpperCase());
			data = readStream.readLine();
			lineNumber++;
		}
	}

}
