package AssmtReadWrite;

import static java.lang.System.out;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileIOTEST {

    public static void main(String... args) {
        //Get a handle on the File
        File f = new File("./W2/WalkSeries2/src/main/java/file.txt");

        try{
            String s = "Homework 2";
            writeToFile(f, s);
        }catch(IOException e){
            out.println("Caught IOException writing to file. Printing Stack Trace:");
            e.printStackTrace();
        }

        try{
            String readString = readFromFile(f);
            out.println(readString);
        }catch(IOException e){
            out.println("Caught IOException reading from file. Printing Stack Trace:");
            e.printStackTrace();
        }

    }

    private static void writeToFile(File f, String s) throws IOException{
        //Write to the file
        FileWriter writer = new FileWriter(f);
        writer.write(s);
        writer.close();
    }

    private static String readFromFile(File f) throws IOException{
        InputStream stream = new FileInputStream(f);
        InputStreamReader inputStreamReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuilder builder = new StringBuilder();


        String line = "";
        line = reader.readLine();
        while(line != null){
            builder.append(line);
            builder.append("\n");
            line = reader.readLine();
        }
        reader.close();
        return builder.toString();
    }

}

