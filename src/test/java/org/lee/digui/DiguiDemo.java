package org.lee.digui;

import org.junit.Test;

/**
 * Created by liqiangpeng on 2017/6/2.
 * <p>
 * 递归使用栈内存计算，递归次数过多则有可能导致栈内存益处
 */
public class DiguiDemo {

    @Test
    public void testDigui() {


        /**
         *         数字求和
         */
        System.out.println(getSumAsFor(100));//使用for循环方式解决

        System.out.println(getSumAsDigui(100));//使用递归方式解决


        /**
         *         兔子问题 斐波那契数列 1 1 2 3 5 8 13 21 34 55 89 144 。从第三个开始，后面一项时前面2项的和
         */
        System.out.println(getRabbitAsArray(12));//使用数组方式解决（最好最简单方式）

        System.out.println(getRabbitAsDigui(12));//使用递归方式解决
    }

    /**
     * 求和问题 for循环方式
     *
     * @param num
     * @return
     */
    public static int getSumAsFor(int num) {
        int sum = 0;
        for (int x = 1; x < num; x++)
            sum = sum + x;
        return sum;
    }

    /**
     * 求和问题 递归方式
     *
     * @param num
     * @return
     */
    public static int getSumAsDigui(int num) {
        if (num == 1)//最后加到1时停止递归
            return 1;
        return num + getSumAsDigui(num - 1);
    }

    /**
     * 兔子问题 数组方式
     *
     * @param month
     * @return
     */
    public static int getRabbitAsArray(int month) {
        int[] arr = new int[month];
        arr[0] = 1;
        arr[1] = 1;
        for (int x = 2; x < arr.length; x++) {
            arr[x] = arr[x - 1] + arr[x - 2];
        }
        return arr[arr.length - 1];
    }

    /**
     * 兔子问题 递归方式
     *
     * @param month
     * @return
     */
    public static int getRabbitAsDigui(int month) {
        if (month == 1 || month == 2)
            return 1;
        return getRabbitAsDigui(month - 1) + getRabbitAsDigui(month - 2);
    }

}
