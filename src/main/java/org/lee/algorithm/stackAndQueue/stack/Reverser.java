package org.lee.algorithm.stackAndQueue.stack;

import java.io.IOException;

/**
 * 单词反转
 * <p>
 * Created by liqiangpeng on 2018/1/18.
 */
public class Reverser {

    private String input;
    private String output;

    public Reverser(String in) {
        input = in;
    }

    public String doRev() {
        int stackSize = input.length();
        StackX theStack = new StackX(stackSize);
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            theStack.push(ch);
        }
        output = "";
        while (!theStack.isEmpty()) {
            char ch = theStack.pop();
            output = output + ch;
        }
        return output;
    }
}

/**
 * 测试单词反转
 */
class ReverseApp {

    public static void main(String[] args) throws IOException {
        String input, output;
        while (true) {
            System.out.println("输入字符串：");
            System.out.flush();
            input = InputUtils.getString();
            if (input.equals(""))
                break;
            Reverser theReverser = new Reverser(input);
            output = theReverser.doRev();
            System.out.println("字符串反转后：" + output);

        }
    }


}
