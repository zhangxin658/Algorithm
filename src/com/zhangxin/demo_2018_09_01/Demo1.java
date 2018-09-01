/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * <p>
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * <p>
 * 你可以假设 nums1 和 nums2 不同时为空。
 */

package com.zhangxin.demo_2018_09_01;

import java.util.Arrays;

public class Demo1 {

    public static void main(String[] args) {
        Demo1 demo = new Demo1();
        int[] nums1 = {};
        int[] nums2 = {2, 3};
        System.out.println(demo.findMedianSortedArrays(nums1, nums2));
    }

    //    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int l1 = nums1.length;
//        int l2 = nums2.length;
//        int i = 0;
//        int j = 0;
//        int cur = 0;
//        int[] val = new int[l1+l2];
//        while(i < l1 && j < l2){
//            val[cur++] = (nums1[i] < nums2[j])? nums1[i++] : nums2[j++];
//        }
//        while(j < l2){
//            val[cur++] = nums2[j++];
//        }
//        while(i < l1){
//            val[cur++] = nums1[i++];
//        }
//        if ((l1 + l2) % 2 == 0){
//            return (val[(l1 + l2) / 2 - 1] + val[(l1 + l2) / 2])/2.0;
//        }else{
//            return val[(l1 + l2) / 2];
//        }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, left = (m + n + 1) / 2, right = (m + n + 2) / 2;
        return (findKth(nums1, nums2, left) + findKth(nums1, nums2, right)) / 2.0;
    }

    int findKth(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        if (m > n) return findKth(nums2, nums1, k);
        if (m == 0) return nums2[k - 1];
        if (k == 1) return Math.min(nums1[0], nums2[0]);
        int i = Math.min(m, k / 2), j = Math.min(n, k / 2);
        if (nums1[i - 1] > nums2[j - 1]) {
            return findKth(nums1, Arrays.copyOfRange(nums2, j, n), k - j);
        } else {
            return findKth(Arrays.copyOfRange(nums1, i, m), nums2, k - i);
        }
    }
}

