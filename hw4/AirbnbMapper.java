import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AirbnbMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private static final int MISSING = 9999;

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String row[]= line.split(",");
        String borough[] = {"Manhattan","Brooklyn","Queens","Bronx","Staten Island"};
        try{
            boolean bo=false;
            String neighbor=row[4];
            for(int i=0;i<borough.length;i++) {
                if (neighbor.equals(borough[i])) {
                    context.write(new Text(borough[i] + "," + row[5]), new IntWritable(1));
                    bo = true;
                }
            }
            if(!bo) context.write(new Text("Bad Record"), new IntWritable(1));

        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
    }}


