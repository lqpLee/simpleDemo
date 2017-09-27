package org.lee.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * 项目场景：海量小文件
 *
 * （但最后没有采用这种方式，而是使用的HBase）
 *
 * Created by liqiangpeng on 2017/7/10.
 * 获取指定目录下的所有文件将其合并放到SequenceFile
 */
public class WriteSequenceFile {

    public static void main(String[] args) throws IOException {
        String uri = "hdfs://127.0.0.1:8020";
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), conf);

        IntWritable key = new IntWritable();
        Text value = new Text();

        SequenceFile.Writer writer = null;
        try {
            writer = SequenceFile.createWriter(fs, conf, new Path("/lee/WordCount5/SequenceFile/WordCount.seq"), key.getClass(), value.getClass());
            FileStatus[] listStatus = fs.listStatus(new Path("/lee/WordCount5"));

            BufferedReader br;
            int i = 0;
            for (FileStatus fsu : listStatus) {
                StringBuilder sb = new StringBuilder();
                if (fsu.isFile()) {
                    key.set(i);
                    Path dataPath = fsu.getPath();
                    InputStream in = fs.open(dataPath);
                    br = new BufferedReader(new InputStreamReader(in));
                    while (br.readLine() != null) {
                        sb.append(br.readLine());
                    }
                    value.set(sb.toString());
                    writer.append(key,value);
                    i++;
                }
            }

        } finally {
            IOUtils.closeStream(writer);
        }
    }
}
