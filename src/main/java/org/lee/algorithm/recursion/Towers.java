package org.lee.algorithm.recursion;

/**
 * @author wb-lqp383186
 * @date Created in 17:03 2018/9/4
 */
public class Towers {

    static int nDisks = 22;
    static int ff = 0;

    public static void main(String[] args) {
        doTowers(nDisks, 'A', 'B', 'C');
        System.out.println(ff);
    }

    private static void doTowers(int topN, char from, char inter, char to) {
        if (topN == 1) {
            ff++;
            //System.out.println("Disk 1 from " + from + " to" + to);
        } else {
            doTowers(topN - 1, from, to, inter);
            //System.out.println("Disk " + topN + " from " + from + " to" + to);
            ff++;
            doTowers(topN - 1, inter, from, to);
        }
    }

}
