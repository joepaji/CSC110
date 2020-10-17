package WalkSeries2;
import static java.lang.System.out;

public class InputOutput1 {

    public static void main(String...args){
        var startValue = 1;
        var endValue = 100;
        var incrementValue = 5;

        //Code begins here
        out.println("Start of process");

        for(startValue=0; startValue<=endValue; startValue+=incrementValue){
            PrintData("The Current Value", startValue);
        }

    }

    public static void PrintData(String message, Integer value) {
        var header = "-";
        var output = message + " = " + value.toString();

        out.println(header.repeat(output.length()));
        out.println(output);
    }
    
}
