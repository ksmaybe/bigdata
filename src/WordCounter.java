import java.io.File;
import java.util.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.conf.Configuration;

import static java.lang.System.out;

public class WordCounter{
//Shang Ke
//Processing Big Data HW2 Word Count with MapReduce
    public static void main(String[] args) throws Exception {
        // write your code here
//        if (args.length!=2) {
//            out.println("Please check input args");
//            System.exit(-1);
//        }
        final Configuration conf =new Configuration();
        conf.set("mapred.textoutputformat.separator","|");
        Job job=Job.getInstance(conf);

        job.setJarByClass(WordCounter.class);
        job.setJobName("Counting words");

        job.setNumReduceTasks(1);

        FileInputFormat.addInputPath(job, new Path("input.txt"));
        FileOutputFormat.setOutputPath(job,new Path("output.txt"));

        job.setMapperClass(WordCounterMapper.class);
        job.setReducerClass(WordCounterReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);


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
