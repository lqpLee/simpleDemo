package org.lee.weather;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 * Created by liqiangpeng on 2017/7/19.
 * 自定义分组
 */
public class GroupHot extends WritableComparator{
    public GroupHot(){
        super(KeyPari.class,true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        KeyPari o1 = (KeyPari) a;
        KeyPari o2 = (KeyPari) b;
        return Integer.compare(o1.getYear(), o2.getYear());
    }
}
