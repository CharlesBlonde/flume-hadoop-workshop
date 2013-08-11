package fr.xebia.techevent.hadoop.job.error;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import fr.xebia.techevent.hadoop.job.AccessLog;
import fr.xebia.techevent.hadoop.job.LogParser;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.List;

public class CsvMapper extends Mapper<LongWritable, Text, NullWritable, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        AccessLog al = LogParser.parseAccessLog(value.toString());
        Joiner joiner = Joiner.on("\t");
        if (al != null) {
            List<String> texts = Lists.newArrayList(new String(al.timestamp), new String(al.command), new String(al.ip), new String(al.processTime), new String(al.protocol), new String(al.resources), new String(al.returnCode));
            context.write(NullWritable.get(), new Text(joiner.join(texts)));
        }
    }
}
