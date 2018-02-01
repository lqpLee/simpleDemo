package org.lee.algorithm.sort.object;

/**
 * Created by liqiangpeng on 2018/1/4.
 */
public class ArrayInOb {
    private Person[] a;
    private int nElems;

    public ArrayInOb(int max) {
        a = new Person[max];
        nElems = 0;
    }

    public void insert(String last, String first, int age) {
        a[nElems] = new Person(last, first, age);
        nElems++;
    }

    public void dispaly() {
        for (int j = 0; j < nElems; j++) {
            System.out.println(a[j]);
        }
    }

    /**
     * 根据lastName排序
     */
    public void insertionSort() {
        int in, out;
        for (out = 1; out < nElems; out++) {
            Person temp = a[out];
            in = out;
            while (in > 0 && a[in - 1].getLastName().compareTo(temp.getLastName()) > 0) {
                a[in] = a[in - 1];
                --in;
            }
            a[in] = temp;
        }
    }
}
