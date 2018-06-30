package org.lee.algorithm.link.doubleend;


/**
 * 双端链表
 * Created by liqiangpeng on 2018/6/25.
 */
public class FirstLastLinkList {
    private Link first;

    private Link last;

    public FirstLastLinkList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 如果链表为空，则表头和表尾都是newLink
     *
     * @param dd data
     */
    public void insertFirst(long dd) {
        Link newLink = new Link(dd);
        if (isEmpty())
            last = newLink;
        newLink.next = first;
        first = newLink;
    }

    /**
     * 如果链表为空，则表头表尾都为newLink，否则表尾的next为newLink
     * 将表尾设置为newLink
     *
     * @param dd
     */
    public void insertLast(long dd) {
        Link newLink = new Link(dd);
        if (isEmpty())
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
    }

    /**
     * 如果表头的下一个为空，说明链表只有一个链结点，表尾设为空
     * 将表头的链结点设为链结点的下一个
     *
     * @return delete data
     */
    public long deleteFirst() {
        long temp = first.dData;
        if (first.next == null)
            last = null;
        first = first.next;
        return temp;
    }

    public void dispalyList() {
        System.out.print("List (first --> last): ");
        Link current = first;
        while (current != null) {
            current.disPlayLink();
            current = current.next;
        }
        System.out.println("");
    }

}

class Link {

    public long dData;  //数据项

    public Link next;   //指向下一个链接点,引用reference

    /**
     * 数据项字段较多，一般使用对象来表示
     *
     * @param dd 数据项
     */
    public Link(long dd) {
        dData = dd;
    }

    public void disPlayLink() {
        System.out.print("{" + dData + "}");
    }

}

class FirstLastApp {
    public static void main(String[] args) {
        FirstLastLinkList theList = new FirstLastLinkList();
        theList.insertFirst(22L);
        theList.insertFirst(44L);
        theList.insertFirst(66L);
        theList.insertFirst(88L);
        
        theList.insertLast(99L);

        theList.dispalyList();

        theList.deleteFirst();
        theList.deleteFirst();
        theList.deleteFirst();

        theList.dispalyList();
    }
}
