import java.io.File;
import java.util.*;

import static java.lang.System.out;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

public class WordReduce {
//Shang Ke
//Processing Big Data HW2 Word Count w/o MapReduce
    public mapper
    public static void main(String[] args) throws Exception {
        // write your code here
        String[] toSearch={"Chicago","Dec","Java","hackathon"};
        int[] count={0,0,0,0};
        String inputName = "input.txt";
        File inputFile = new File(inputName);
        Scanner inputS= new Scanner(inputFile);
        List<String> input= new ArrayList<String>();
        while(inputS.hasNext()){
            input.add(inputS.nextLine());
        }
        for(int i=0;i<input.size();i++){
            for (int j=0;j<toSearch.length;j++){
                if(input.get(i).toLowerCase().contains(toSearch[j].toLowerCase())) count[j]++;
            }
        }
        for(int i=0;i<toSearch.length;i++){
            out.println(toSearch[i]+" "+count[i]);
        }

    }
}
