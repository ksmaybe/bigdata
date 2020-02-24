import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCounterMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private static final int MISSING = 9999;

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] toSearch = {"Chicago", "Dec", "Java", "hackathon"};
        String line = value.toString().toLowerCase();
        for (int j=0;j<toSearch.length;j++){
            if(line.contains(toSearch[j].toLowerCase())) context.write(new Text(toSearch[j]),new IntWritable(1));
            else context.write(new Text(toSearch[j]),new IntWritable(0));
        }
    }
}
