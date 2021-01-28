package LeetCode;

import common.ListNode;

/**
 * @author ：CK
 * @date ：Created in 2020/10/13 9:05
 * @description：
 */
public class No24 {
    public ListNode swapPairs(ListNode head) {
        ListNode listNode = null;
        ListNode pre;
        ListNode next;
        if (head != null && head.next != null){
            pre = head;
            next = head.next;
            head = next;
        }
        else {
            return head;
        }
        while (next != null){
            if (listNode != null){
                listNode.next = next;
            }
            listNode = pre;
            pre.next = next.next;
            next.next = pre;
            pre = pre.next;
            if (pre != null){
                next = pre.next;
            }
            else {
                break;
            }
        }
        return head;
    }
}
