package LeetCode;

import java.util.*;

/**
 * @author ：CK
 * @date ：Created in 2020/11/2 10:33
 * @description：
 */
public class No349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i:nums1){
            set1.add(i);
        }
        for (int i:nums2){
            set2.add(i);
        }
        Set<Integer> s =new HashSet();
        for (int i: set1){
            if (set2.contains(i)){
                s.add(i);
            }
        }
        int[] result = new int[s.size()];
        int j = 0;
        for (int i:s){
            result[j] = i;
            j++;
        }
        return result;
    }

    //双指针，先排序，再归并找
    public int[] intersection1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[length1 + length2];
        int index = 0, index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            int num1 = nums1[index1], num2 = nums2[index2];
            if (num1 == num2) {
                // 保证加入元素的唯一性
                if (index == 0 || num1 != intersection[index - 1]) {
                    intersection[index++] = num1;
                }
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
