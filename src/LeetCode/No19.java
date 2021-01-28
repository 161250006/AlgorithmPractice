package LeetCode;

import common.ListNode;

import java.util.List;

/**
 * @author ：CK
 * @date ：Created in 2020/10/18 10:23
 * @description：
 */
public class No19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode listNode = head;
        for (int i = 1 ; i <= n ; i ++){
            listNode = listNode.next;
        }
        ListNode remove = head;
        ListNode removeBefore = null;
        while (listNode != null){
            removeBefore = remove;
            remove = remove.next;
            listNode = listNode.next;
        }
        if (removeBefore != null) {
            removeBefore.next = remove.next;
            remove.next = null;
        }
        else {
            head = head.next;
        }
        return head;
    }
}
