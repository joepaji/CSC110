package Demo1NumbersTest;
import static java.lang.System.out;
public class WalkSeries {

    public static void main(String... args) {
        var startValue =0;
        var endValue = 101;
        var incrementValue  = 5;

        // it is always a good idea to inform what is happening
        out.println("Start of process");
       
        for( 
                startValue = 0; 
                startValue< endValue ; // compare
                startValue = startValue + incrementValue // increment
            ){ // you process code here
                out.println(startValue);
            }
    }  
}    
