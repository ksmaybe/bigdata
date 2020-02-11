import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

//Shang Ke
//Processing Big Data HW2 Word Count w/o MapReduce
public class WordCount {

    public static void main(String[] args) throws Exception {
        // write your code here
        String inputName = ".txt";
        File inputFile = new File(inputName);
        Scanner inputS= new Scanner(inputFile);
        List<String> input= new ArrayList<String>();
        while(inputS.hasNext()){
            input.add(inputS.next());
        }
    }
}