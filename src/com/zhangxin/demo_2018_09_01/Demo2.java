/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 */

package com.zhangxin.demo_2018_09_01;

public class Demo2 {
    public static void main(String[] args) {
        Demo2 demo = new Demo2();
        String s = "a";
        System.out.println(demo.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int num = 0;
        int low = 0;
        int high = s.length();
        for (int i = 0; i < s.length() - 1; i++) {
            int curlow = 0;
            int curhigh = 0;
            int sign = i;
            while (sign + 1 < s.length() && s.charAt(sign) == s.charAt(sign + 1)) {
                sign++;
            }
            curlow = i - 1;
            curhigh = sign + 1;
            while (curlow >= 0 && curhigh < s.length()) {
                if (s.charAt(curlow) == s.charAt(curhigh)) {
                    curlow--;
                    curhigh++;
                } else {
                    break;
                }
            }
            curlow++;
            int curnum = curhigh - curlow;
            if(curnum > num){
                low = curlow;
                high = curhigh;
                num = curnum;
            }
        }
        return s.substring(low, high);
    }
}
