package org.lee.weather;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * Created by liqiangpeng on 2017/7/19.
 * 自定义分区
 */
public class FirstPartition extends Partitioner<KeyPari,Text>{

    @Override
    public int getPartition(KeyPari key, Text value, int numPartitions) {
        return (key.getYear() * 127) % numPartitions;//分区，按照年份进行分区（一年对应一个文件，对应一个reduce任务）
    }

}
