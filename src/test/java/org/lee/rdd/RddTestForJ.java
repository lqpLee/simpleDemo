package org.lee.rdd;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.rdd.RDD;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liqiangpeng on 2018/2/6.
 */
public class RddTestForJ {
    private SparkContext sc;

    @Before
    public void before() {
        SparkConf conf = new SparkConf();
        conf.setMaster("local");
        conf.setAppName("WordCount");
        sc = new SparkContext(conf);
    }

    @Test
    public void testPrint() {
        
    }


}
