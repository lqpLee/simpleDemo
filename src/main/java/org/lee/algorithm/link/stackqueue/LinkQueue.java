package org.lee.algorithm.link.stackqueue;

import org.lee.algorithm.link.doubleend.FirstLastLinkList;

/**
 * 用链表实现队列
 * 先进先出
 * <p>
 * Created by liqiangpeng on 2018/6/30.
 */
public class LinkQueue {

    private FirstLastLinkList theList;

    public LinkQueue() {
        theList = new FirstLastLinkList();
    }

    public boolean isEmpty() {
        return theList.isEmpty();
    }

    public void insert(long j) {
        theList.insertLast(j);
    }

    public long remove() {
        return theList.deleteFirst();
    }

    public void displayQueue() {
        System.out.print("Queue (front --> rear): ");
        theList.dispalyList();
    }
}


class LinkQueueApp {

    public static void main(String[] args) {
        LinkQueue theQueue = new LinkQueue();
        theQueue.insert(20);
        theQueue.insert(40);

        theQueue.displayQueue();

        theQueue.insert(60);
        theQueue.insert(80);

        theQueue.displayQueue();

        theQueue.remove();
        theQueue.remove();

        theQueue.displayQueue();
    }
}













