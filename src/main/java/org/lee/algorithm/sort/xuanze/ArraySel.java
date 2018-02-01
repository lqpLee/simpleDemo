package org.lee.algorithm.sort.xuanze;

/**
 * Created by liqiangpeng on 2018/1/4.
 */
public class ArraySel {
    private long[] a;
    private int nElems;

    /**
     * 构造方法初始化
     *
     * @param max 数组最大长度
     */
    public ArraySel(int max) {
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
    public void selectionSort() {
        int out, in, min;
        for (out = 0; out < nElems - 1; out++) {
            min = out;//当每次循环结束时，已经确定了out所在右边已经排好序，记录最小数，下次循环从out+1开始，忽略前面已排好序的数据
            for (in = out + 1; in < nElems; in++)//从out右边开始
                if (a[in] < a[min])
                    min = in;//只要发现最小的数据，记录下来
            swap(out, min);//跟out交换
            //将以下注释打开可查看详细交换信息
            /*System.out.print("out=====" + out);
            System.out.print("  in======" + in);
            System.out.println("  min======" + min);
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
