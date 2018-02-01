package org.lee.algorithm.sort.charu;

/**
 * Created by liqiangpeng on 2018/1/4.
 */
public class InsertSort {
    private long[] a;
    private int nElems;

    /**
     * 构造方法初始化
     *
     * @param max 数组最大长度
     */
    public InsertSort(int max) {
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
    public void insertionSort() {
        int in, out;
        for (out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] > temp) {
                a[in] = a[in - 1];
                --in;
                //将以下注释打开查看详细交换情况
                /*System.out.print("out=====" + out);
                System.out.print("    temp====" + temp);
                System.out.println("    in=====" + in);
                dispaly();*/
            }
            a[in] = temp;
            /*System.out.print("第" + out + "次外循环交换后： ");
            dispaly();*/
        }
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
