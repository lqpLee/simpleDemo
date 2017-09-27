package org.lee.weather;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MapReduce
 * <p>
 * Created by liqiangpeng on 2017/7/19.
 */
public class RunJob {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static class HotMapper extends Mapper<LongWritable, Text, KeyPari, Text> {
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String line = value.toString();
            String dest = regist(line);
            String[] ss = dest.split("\t");
            System.out.println(ss.length);
            if (ss.length == 2) {
                try {
                    Date date = sdf.parse(ss[0]);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    int year = calendar.get(1);
                    String hot = ss[1].substring(0, ss[1].indexOf("°C"));
                    KeyPari kp = new KeyPari();
                    kp.setYear(year);
                    kp.setHot(Integer.parseInt(hot));
                    context.write(kp, value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public static String regist(String str) {
            Pattern p = Pattern.compile("\\s{2,}");
            Matcher m = p.matcher(str);
            String dest = m.replaceAll("\t");
            return dest;
        }
    }


    static class HotReduce extends Reducer<KeyPari, Text, KeyPari, Text> {
        @Override
        protected void reduce(KeyPari kp, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            for (Text v : values) {
                context.write(kp, v);
            }
        }
    }

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.set("fs.default.name", "hdfs://127.0.0.1:8020");
        try {
            Job job = new Job(conf);
            job.setJobName("hot");
            job.setJarByClass(RunJob.class);
            job.setMapperClass(HotMapper.class);
            job.setReducerClass(HotReduce.class);
            job.setMapOutputKeyClass(KeyPari.class);
            job.setMapOutputValueClass(Text.class);

            job.setNumReduceTasks(3);
            job.setPartitionerClass(FirstPartition.class);
            job.setSortComparatorClass(SortHot.class);
            job.setGroupingComparatorClass(GroupHot.class);

            FileInputFormat.addInputPath(job, new Path("/lee/weather/input"));
            FileOutputFormat.setOutputPath(job, new Path("/lee/weather/output"));
            System.exit(job.waitForCompletion(true) ? 0 : 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
