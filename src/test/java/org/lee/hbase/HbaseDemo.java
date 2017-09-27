package org.lee.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * hbase相关操作
 * Created by liqiangpeng on 2017/6/15.
 */
public class HbaseDemo {
    private static Configuration configuration;

    private String tableName = "test_lee";

    private String column1 = "column1";
    private String column2 = "column2";
    private String column3 = "column3";

    private String rowKey = "112233bbbcccc";

    static {
        configuration = HBaseConfiguration.create();
        //configuration.get("localhost");
        configuration.set("hbase.zookeeper.quorum", "127.0.0.1");
    }

    /**
     * 创建表及列
     *
     * @throws Exception
     */
    @Test
    public void createTable() throws Exception {
        HBaseAdmin admin = new HBaseAdmin(configuration);
        if (admin.tableExists(tableName)) {
            System.out.println(tableName + " =========== 已经存在！");
        } else {
            HTableDescriptor tableDesc = new HTableDescriptor(tableName);
            tableDesc.addFamily(new HColumnDescriptor(column1));
            tableDesc.addFamily(new HColumnDescriptor(column2));
            tableDesc.addFamily(new HColumnDescriptor(column3));
            admin.createTable(tableDesc);
            System.out.println(tableName + " =========== 创建成功！");
        }
    }

    /**
     * 插入数据
     */
    @Test
    public void insertData() {
        HTablePool pool = new HTablePool(configuration, 1000);
        HTable table = (HTable) pool.getTable(tableName);
        Put put = new Put(rowKey.getBytes());//一个PUT代表一行数据，再NEW一个PUT表示第二行数据,每行一个唯一的ROWKEY，此处rowkey为put构造方法中传入的值
        put.add(column1.getBytes(), null, "aaa".getBytes());
        put.add(column2.getBytes(), null, "bbb".getBytes());
        put.add(column3.getBytes(), null, "ccc".getBytes());
        try {
            table.put(put);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除表
     */
    @Test
    public void dropTable() {
        try {
            HBaseAdmin admin = new HBaseAdmin(configuration);
            admin.disableTable("test_2");
            admin.deleteTable("test_2");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 查询出所有数据
     */
    @Test
    public void queryAll() {
        HTablePool pool = new HTablePool(configuration, 1000);
        HTableInterface table = pool.getTable(tableName);
        try {
            ResultScanner rs = table.getScanner(new Scan());
            for (Result r : rs) {
                System.out.println("获得到的rowkey：" + new String(r.getRow()));
                for (KeyValue keyValue : r.raw()) {
                    System.out.println("列：" + new String(keyValue.getFamily())
                            + "=====值：" + new String(keyValue.getValue()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据rowkey查询
     */
    @Test
    public void queryByCondition() {
        HTablePool pool = new HTablePool(configuration, 1000);
        HTableInterface table = pool.getTable(tableName);
        Get scan = new Get(rowKey.getBytes());//根据rowkey查询
        try {
            Result r = table.get(scan);
            System.out.println("获得到rowkey：" + new String(r.getRow()));
            for (KeyValue keyValue : r.raw()) {
                System.out.println("列：" + new String(keyValue.getFamily())
                        + "====值:" + new String(keyValue.getValue()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
