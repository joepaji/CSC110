package WalkSeries2;
import static java.lang.System.out;
public class InputOutput {

    public static void main(String... args) {
        var startValue =1;
        var endValue = 100;
        var incrementValue  = 5;

        // it is always a good idea to inform what is happening
        out.println("Start of process");
        // reformatted the code so that it in in the general standard form
        for( startValue = 0; startValue<= endValue ; startValue = startValue + incrementValue){ 
                out.println("Decimal Number = "+ startValue);

                out.println( "Binary Number = " +Integer.toBinaryString(startValue));
              
        }
    }  
}    
