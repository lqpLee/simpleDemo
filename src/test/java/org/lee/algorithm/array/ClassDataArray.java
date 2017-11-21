package org.lee.algorithm.array;

/**
 * 对象数组
 * <p>
 * Created by liqiangpeng on 2017/11/10.
 */
public class ClassDataArray {
    private Person[] a;
    private int nElems;

    /**
     * @param max 数组长度
     */
    public ClassDataArray(int max) {
        a = new Person[max];
        nElems = 0;
    }

    /**
     * @param searchName 关键字
     * @return 类
     */
    public Person find(String searchName) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j].getLastName().equals(searchName))
                break;
        if (j == nElems)
            return null;
        else
            return a[j];
    }

    /**
     * @param lastName  lastName
     * @param firstName firstName
     * @param age       age
     */
    public void insert(String lastName, String firstName, int age) {
        a[nElems] = new Person(lastName, firstName, age);
        nElems++;
    }

    public boolean delete(String searchName) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j].getLastName().equals(searchName))
                break;
        if (j == nElems)
            return false;
        else {
            for (int k = j; k < nElems; k++)
                a[k] = a[k + 1];
            nElems--;
            return true;
        }
    }

    public void dispalyA() {
        for (int j = 0; j < nElems; j++)
            System.out.println(a[j].toString());
    }
}
