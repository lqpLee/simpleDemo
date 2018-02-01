package org.lee.algorithm.stackAndQueue.queue;

/**
 * 队列
 * <p>
 * Created by liqiangpeng on 2018/1/26.
 */
public class Queue {

    private int maxSize;
    private long[] queArray;
    private int front;//队头
    private int rear;//队尾
    private int nItems;

    public static void main(String[] args) {
        int i = 9 ;
        switch(i) {
            default:
                System.out.println("default");
            case 0 :
                System.out.println("zero");
                break ;
            case 1 : System.out.println("one");
            case 2 : System.out.println("two");
        }
    }
}
