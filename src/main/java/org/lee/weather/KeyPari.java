package org.lee.weather;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by liqiangpeng on 2017/7/19.
 * 自定义封装类(定义年份和温度)
 * Hadoop的key和value的传递序列化需要涉及两个重要的接口Writable和WritableComparable
 * WritableComparable<T> extends Writable, Comparable<T>
 * WritableComparable比Writable多了一个compareTo方法，这个的用途是是为了确定是不是相同的key
 * hadoop为Key的数据类型必须实现WritableComparable，而Value的数据类型只需要实现Writable即可，能做Key的一定可以做Value，能做Value的未必能做Key.
 */
public class KeyPari implements WritableComparable<KeyPari> {

    //年份
    private int year;

    //温度
    private int hot;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    /**
     * @param o
     * @return 返回比较结果 0为相等
     */
    @Override
    public int compareTo(KeyPari o) {
        int res = Integer.compare(year, o.getYear());
        if (res != 0)
            return res;
        return Integer.compare(hot, o.getHot());
    }

    /**
     * @param out
     * @throws IOException 实现接口类的方法
     *                     序列化
     *                     将java对象写为二进制文件（rpc协议读取二进制文件，为了与java对象耦合，使用序列化）
     */
    @Override
    public void write(DataOutput out) throws IOException {

        out.writeInt(year);
        out.writeInt(hot);
    }

    /**
     * @param in
     * @throws IOException 实现接口类的方法
     *                     反序列化
     *                     从二进制文件读取数据为java对象（rpc协议读取二进制文件，为了与java对象耦合，使用序列化）
     */
    @Override
    public void readFields(DataInput in) throws IOException {

        this.year = in.readInt();
        this.hot = in.readInt();
    }

    @Override
    public String toString() {
        return year + "\t" + hot;
    }

    @Override
    public int hashCode() {
        return new Integer(year + hot).hashCode();
    }
}
