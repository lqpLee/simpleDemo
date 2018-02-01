package org.lee.algorithm.stackAndQueue.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 栈
 */
public class StackX {
    private int maxSize;
    private char[] stackArray;
    private int top;

    /**
     * 初始化
     *
     * @param s 长度
     */
    public StackX(int s) {
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }

    /**
     * 压栈
     *
     * @param j
     */
    public void push(char j) {
        stackArray[++top] = j;
    }

    /**
     * 出栈
     *
     * @return
     */
    public char pop() {
        return stackArray[top--];
    }

    /**
     * 查看
     *
     * @return
     */
    public char peek() {
        return stackArray[top];
    }

    /**
     * 非空判断
     *
     * @return
     */
    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * 数组是否满
     *
     * @return
     */
    public boolean isFull() {
        return (top == maxSize - 1);
    }
}

/**
 * 测试栈
 */
class StackApp {
    public static void main(String[] args) {
        StackX stackX = new StackX(10);
        stackX.push('l');
        stackX.push('e');
        stackX.push('e');
        stackX.push('s');

        while (!stackX.isEmpty()) {
            System.out.println("查看到 " + stackX.peek());
            char value = stackX.pop();
            System.out.println(value + " 已出栈");
            System.out.println("==========");

        }
    }
}

/**
 * 输入工具
 */
class InputUtils {
    public static String getString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}

