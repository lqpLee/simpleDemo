package org.lee.algorithm.sort.maopao;

/**
 * 对象化
 * <p>
 * Created by liqiangpeng on 2018/1/4.
 */
public class ArrayBub {
    private long[] a;
    private int nElems;

    /**
     * 构造方法初始化
     *
     * @param max 数组最大长度
     */
    public ArrayBub(int max) {
        a = new long[max];
        nElems = 0;
    }

    /**
     * 给数组中添加值
     *
     * @param value
     */
    public void insert(long value) {
        a[nElems] = value;//将值插入到当前数组长度中
        nElems++;//长度+1
    }

    /**
     * 打印
     */
    public void dispaly() {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }

    /**
     * 排序
     */
    public void bubbleSort() {
        int out, in;
        for (out = nElems - 1; out > 1; out--)
            for (in = 0; in < out; in++) {
                if (a[in] > a[in + 1])
                    swap(in, in + 1);
                //将以下注释打开可查看每次比对情况
                /*System.out.print("out===== " + out);
                System.out.print("     in===== " + in);
                System.out.println("   开始比较第" + in + "和第" + (in + 1) + "下标的值");
                dispaly();*/
            }
    }

    /**
     * 交换位置 [将交换独立出来不一定好，因为方法会增加额外的消耗，出入棧？]
     *
     * @param one val1
     * @param two val2
     */
    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    /**
     * 数组长度
     *
     * @return 数组长度
     */
    public int size() {
        return nElems;
    }
}
