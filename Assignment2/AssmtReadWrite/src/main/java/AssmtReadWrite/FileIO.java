package AssmtReadWrite;

import java.io.*;

public class FileIO {

    public static void main(String... args) {
        File f = new File("./AssmtReadWrite/src/main/java/AssmtReadWrite/Sample Text.txt");
        
        try{
            String s = "Homework 2";
            writeToFile(f, s);
        }
        catch(IOException e){
            System.out.println("Warning! Error!");
            e.printStackTrace();
        }

        try{
            String readString = readFile(f);
            System.out.println(readString);
        }
        catch(IOException e){
            System.out.println("Warning! Error!");
            e.printStackTrace();
        }
    
    }

    private static String readFile(File f) throws IOException{
        InputStream stream = new FileInputStream(f);
        InputStreamReader inputStreamReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuilder output = new StringBuilder();

        String line = reader.readLine();
    
        while(line != null){
            output.append(line);
            output.append("\n");
            line = reader.readLine();
        }
        reader.close();
        return output.toString();
    }

    private static void writeToFile(File f, String message) throws IOException{
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
        writer.write("\n" + message);
        writer.close();
    }


}
