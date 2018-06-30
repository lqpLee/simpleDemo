package org.lee.algorithm.link.singleend;

/**
 * 单链表
 * <p>
 * Created by liqiangpeng on 2018/6/24.
 */
public class LinkList {

    private Link first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 在插入操作时，先将新引用的下一个链结点(newLink.next)赋值为第一个链结点(first)
     * 在将第一个链结点赋值为新的引用即可
     *
     * @param id 数据项
     * @param dd 数据项
     */
    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }

    /**
     * 被称为current的变量开始时指向first
     * 然后通过b不断地把自己赋值为first.next,沿着链表向前移动。
     * 在每个链结点处，find()检查链结点的关键值是否与它寻找的相同
     * 如果找到了，返回对该链结点的引用。
     * 如果find()到达链结点的尾处都没找到，返回null。
     *
     * @param key iData
     * @return target
     */
    public Link find(int key) {
        Link current = first;
        while (current.iData != key) {
            if (current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

    /**
     * 和find（）方法类似
     * 它先搜索要删除的链结点。
     * 然而它需要掌握的不仅是指向当前链结点(current)的引用，还有指向当前链结点的前一个(previous)链结点的引用。
     * 这是因为，如果要删除当前链结点，必须把前一个链结点和后一个链结点连在一起。
     *
     * @param key iData
     * @return target
     */
    public Link delete(int key) {
        Link current = first;
        Link previous = first;
        while (current.iData != key) {
            if (current.next == null)
                return null;
            else {
                /*
                    在while语句的每一次论循环中，每当current变量赋值为current.next之前
                    先把previous变量赋值为current。
                    这保证了它总是指向current所指链结点的前一个链结点
                 */
                previous = current;
                current = current.next;
            }
        }
        /*
        一旦发现当前链结点是要被删除的链结点，就把前一个链结点的next字段赋值为当前链结点的下一个链结点。
        如果当前链结点是第一个链结点，这是一种特殊情况，因为这是由LinkList对象的first域指向的链结点，而不是别的链结点的next字段所指的。
        这种情况下，使first字段指向first.next就可以删除第一个链结点。
         */
        if (current == first)
            first = first.next;
        else
            previous.next = current.next;
        return current;

    }


    /**
     * 在删除操作时，temp变量赋值为第一个链结点
     * 将第一个链结点(first)赋值为下一个链结点first.next即可
     *
     * @return 被删除的元素
     */
    public Link deleteFirst() {
        Link temp = first;
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


class LinkApp {
    public static void main(String[] args) {
        LinkList theList = new LinkList();
        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        theList.dispalyList();

        Link f = theList.find(44);
        if (f != null)
            System.out.println("found Link " + f.iData);
        else
            System.out.println("can not found link");

        Link d = theList.delete(66);
        if (d != null)
            System.out.println("delete link with key " + d.iData);
        else
            System.out.println("can not delete link");

        theList.dispalyList();

        while (!theList.isEmpty()) {
            Link aLink = theList.deleteFirst();
            System.out.print("Deleted ");
            aLink.disPlayLink();
            System.out.println("");
        }
        theList.dispalyList();
    }
}
