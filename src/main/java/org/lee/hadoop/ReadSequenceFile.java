package org.lee.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.util.ReflectionUtils;

import java.io.IOException;
import java.net.URI;

/**
 * Created by liqiangpeng on 2017/7/17.
 * 从SequenceFile种获取文件
 */
public class ReadSequenceFile {
    public static void main(String[] args) throws IOException {
        String uri = "hdfs://127.0.0.1:8020";
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), conf);
        SequenceFile.Reader reader = null;
        try {
            reader = new SequenceFile.Reader(fs, new Path("/lee/WordCount5/SequenceFile/WordCount.seq"), conf);
            Writable key = (Writable) ReflectionUtils.newInstance(reader.getKeyClass(), conf);
            Writable value = (Writable) ReflectionUtils.newInstance(reader.getValueClass(), conf);
            long position = reader.getPosition();
            while (reader.next(key, value)) {
                System.out.println(key+"========================="+value);

            }
        } finally {
            IOUtils.closeStream(reader);
        }
    }
}
