//Shang Ke
//Processing Big Data HW4 Lesser than ideal lines
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

public class Lesser{
    public static void main(String[] args) throws Exception {
//         write your code here
        if (args.length!=2) {
            out.println("Please check input args");
            System.exit(-1);
        }
        final Configuration conf =new Configuration();
        conf.set("mapred.textoutputformat.separator",": ");
        Job job=Job.getInstance(conf);

        job.setJarByClass(Lesser.class);
        job.setJobName("Counting lines with less ideal fields");

        job.setNumReduceTasks(1);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        job.setMapperClass(LesserMapper.class);
        job.setReducerClass(LesserReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        System.exit(job.waitForCompletion(true) ? 0 : 1);


    }
}
