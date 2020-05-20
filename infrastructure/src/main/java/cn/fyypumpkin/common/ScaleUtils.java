package cn.fyypumpkin.common;

import java.util.Stack;

/**
 * @author juntuan
 * @date 2020-05-19
 */
public class ScaleUtils {
    /**
     * 将10进制数字转换为62进制
     */
    public static String convert(long number, int length) {
        char[] charSet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

        long temp = Math.abs(number);
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder(0);

        while (temp != 0) {
            stack.add(charSet[new Long((temp % 63)).intValue()]);
            temp = temp / 62;
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        int resLength = result.length();

        // 0 前缀
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < length - resLength; i++) {
            prefix.append('0');
        }

        return prefix.toString() + result.toString();
    }

}
