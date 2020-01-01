package org.lee.red;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RedPackage {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入红包金额：");
        Integer totalAmount = in.nextInt();
        System.out.println("请输入人数：");
        Integer totalPeople = in.nextInt();
        List<Integer> amountList = redPackage(totalAmount, totalPeople);
//        String[] NameList = new String[]{"小黄", "张三", "李四", "王五", "鹤叔", "丽丽", "小明", "阿杰", "媚姐", "王姨"};
        for (Integer amount : amountList) {
            System.out.println("搶到金額：" + tras2Yuan(amount) + "元");
        }
    }

    public static BigDecimal tras2Yuan(Integer amount) {
        return new BigDecimal(amount).divide(new BigDecimal(100));
    }

    public static List<Integer> redPackage(Integer totalAmount, Integer totalPeople) {
        List<Integer> amountList = new ArrayList<>();
        Integer restAmount = totalAmount;//剩餘金額
        Integer restPeople = totalPeople;//剩餘人數
        Random random = new Random();
        for (int i = 0; i < totalPeople - 1; i++) {
            //隨機範圍：[1,剩餘人均金額的兩倍]
            int bound = restAmount / restPeople * 2 - 1;
            int amount = random.nextInt(bound) + 1;
            System.out.println("================");
            System.out.println("restPeople:" + restPeople);
            System.out.println("restAmount:" + tras2Yuan(restAmount));
            System.out.println("bound:" + tras2Yuan(bound));
            System.out.println("amount:" + tras2Yuan(amount));
            restAmount -= amount;
            restPeople--;
            amountList.add(amount);
            System.out.println("restAmount after:" + tras2Yuan(restAmount));
            System.out.println("restPeople after:" + restPeople);
        }
        amountList.add(restAmount);
        return amountList;
    }
}
