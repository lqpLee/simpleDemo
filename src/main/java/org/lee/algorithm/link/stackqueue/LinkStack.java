package org.lee.algorithm.link.stackqueue;

import org.lee.algorithm.link.singleend.LinkList;

/**
 * 使用链表实现棧
 * 先进后出
 * <p>
 * Created by liqiangpeng on 2018/6/25.
 */
public class LinkStack {

    private LinkList theList;

    public LinkStack() {
        theList = new LinkList();
    }

    public void push(int id, double dd) {
        theList.insertFirst(id, dd);
    }

    public int pop() {
        return theList.deleteFirst().iData;
    }

    public boolean isEmpty() {
        return theList.isEmpty();
    }

    public void displayStack() {
        theList.dispalyList();
    }
}

class LinkStackApp {
    public static void main(String[] args) {
        LinkStack theStack = new LinkStack();
        theStack.push(22, 2.99);
        theStack.push(44, 4.99);
        theStack.push(66, 6.99);
        theStack.push(88, 8.99);

        theStack.displayStack();

        theStack.pop();
        theStack.pop();
        theStack.pop();

        theStack.displayStack();
    }
}
