package LeetCode;

import common.ListNode;

import java.util.List;

/**
 * @author ：CK
 * @date ：Created in 2021/1/3 10:49
 * @description：
 */
public class No86 {
    //模拟
    public ListNode partition(ListNode head, int x) {
        ListNode left = null;
        ListNode leftFirst = null;
        ListNode right = null;
        ListNode rightFirst = null;
        while (head != null){
            if (head.val >= x){
                if (right == null){
                    right = head;
                    rightFirst = head;
                }
                else {
                    right.next = head;
                    right = right.next;
                }
            }
            else {
                if (left == null){
                    left = head;
                    leftFirst = head;
                }
                else {
                    left.next = head;
                    left = left.next;
                }
            }
            head = head.next;
        }
        if (right != null){
            right.next = null;
        }
        if (left == null){
            return rightFirst;
        }
        else {
            left.next = rightFirst;
            return leftFirst;
        }
    }
}
