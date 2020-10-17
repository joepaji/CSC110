package FileIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileIO {

    public static void main(String... args) throws IOException{
        var fileName = "./FileIO/src/main/java/FileIO/data.txt";
        var filePath = Paths.get(fileName);

        
        

      //  if(!Files.exists(filePath))
      //      System.out.println("The file " + fileName + "vould not be found");
        try{
            var readStream = Files.newBufferedReader(filePath);
            var data = readStream.readLine();
            System.out.println("The data: ");

            while(data!=null)
                {
                    System.out.println(data);
                    data = readStream.readLine();
                }
        } catch(IOException e){
            System.out.println("Ooops, something's gone wrong!");
            e.printStackTrace();
        }
        
    }
}
