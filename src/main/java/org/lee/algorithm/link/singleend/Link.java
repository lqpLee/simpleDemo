package org.lee.algorithm.link.singleend;

/**
 * 链结点
 * <p>
 * Created by liqiangpeng on 2018/6/25.
 */
public class Link {
    public int iData;   //数据项

    public double dData;  //数据项

    public Link next;   //指向下一个链接点,引用reference

    /**
     * 数据项字段较多，一般使用对象来表示
     *
     * @param id 数据项
     * @param dd 数据项
     */
    public Link(int id, double dd) {
        iData = id;
        dData = dd;
    }

    public void disPlayLink() {
        System.out.print("{" + iData + "," + dData + "}");
    }

}
