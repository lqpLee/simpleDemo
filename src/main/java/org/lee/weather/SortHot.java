package org.lee.weather;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 * Created by liqiangpeng on 2017/7/19.
 * 温度排序
 */
public class SortHot extends WritableComparator {

    public SortHot() {
        /**
         * 调用父类构造
         *  1：当对象
         *  2：是否创建实例
         */
        super(KeyPari.class, true);
    }

    /**
     * @param a KeyPari对象
     * @param b KeyPari对象
     * @return
     */
    @Override
    public int compare(WritableComparable a, WritableComparable b) {

        KeyPari o1 = (KeyPari) a;
        KeyPari o2 = (KeyPari) b;
        int res = Integer.compare(o1.getYear(), o2.getYear());
        if (res != 0)//不等
            return res;
        //年份相等，温度进行降序排序
        return -Integer.compare(o1.getHot(), o2.getHot());

    }
}
