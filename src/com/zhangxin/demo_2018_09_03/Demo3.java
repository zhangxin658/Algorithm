/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 *
 * 注意:
 *
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
package com.zhangxin.demo_2018_09_03;

import java.math.BigInteger;

public class Demo3 {
    public static void main(String[] args){
        Demo3 demo = new Demo3();
        int val = 1534236469;
        System.out.println(demo.reverse(val));
    }
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
