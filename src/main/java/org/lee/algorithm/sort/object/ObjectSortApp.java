package org.lee.algorithm.sort.object;

/**
 * Created by liqiangpeng on 2018/1/4.
 */
public class ObjectSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayInOb arr = new ArrayInOb(maxSize);

        arr.insert("Evans","Patty",24);
        arr.insert("Smith","Doc",59);
        arr.insert("Smith","Lorraine",37);
        arr.insert("Smith","Paul",37);
        arr.insert("Yee","Tom",43);
        arr.insert("Hashimoto","Sato",21);
        arr.insert("Stimson","Henry",29);
        arr.insert("Velasquez","Jose",72);
        arr.insert("Vang","Minh",22);
        arr.insert("Creswell","Luvinda",18);

        System.out.println("排序前：");
        arr.dispaly();
        arr.insertionSort();
        System.out.println("排序后：");
        arr.dispaly();

    }
}
