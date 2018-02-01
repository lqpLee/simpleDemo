package org.lee.algorithm.stackAndQueue.stack;

import java.io.IOException;

/**
 * 栈模拟编译器中的分隔符匹配
 * <p>
 * Created by liqiangpeng on 2018/1/18.
 */
public class BracketChecker {
    private String input;

    public BracketChecker(String in) {
        input = in;
    }

    public void check() {
        int stackSize = input.length();
        StackX theStack = new StackX(stackSize);

        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    theStack.push(ch);//将作分割符的数据压栈
                    break;
                case '}':
                case ']':
                case ')':
                    if (!theStack.isEmpty()) {//说明栈中已有左分隔符的数据，弹出栈顶的数据，与右分隔符比较
                        char chx = theStack.pop();
                        if ((ch == '}' && chx != '{') ||
                                (ch == ']' && chx != '[') ||
                                (ch == ')' && chx != '('))
                            System.out.println("Error :" + ch + " at " + j);
                    } else
                        System.out.println("Error: " + ch + " at " + j);
                    break;
                default:
                    break;
            }
        }
        if (!theStack.isEmpty())//不等于空，说明没有完全出栈,分隔符数量不匹配
            System.out.println("Error: missing right delimiter");
    }
}

/**
 * 测试分隔符匹配
 */
class BracketsApp {
    public static void main(String[] args) throws IOException {
        String input;
        while (true) {
            System.out.println("输入分隔符字符串：");
            System.out.flush();
            input = InputUtils.getString();
            if (input.equals(""))
                break;
            BracketChecker theChecker = new BracketChecker(input);
            theChecker.check();
        }
    }
}
