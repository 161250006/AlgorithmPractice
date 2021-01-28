package LeetCode;

import common.ListNode;

import java.util.List;

/**
 * @author ：CK
 * @date ：Created in 2020/11/13 10:49
 * @description：
 */
public class No328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null ){
            return head;
        }
        ListNode pre1 = head , pre2 = head.next , after1 = pre2.next , after2 = null , second = head.next;
        while (after1 != null){
            after2 = after1.next;
            pre1.next = after1;
            pre2.next = after2;
            pre1 = after1;
            pre2 = after2;
            if (after2 != null) {
                after1 = after2.next;
            }
            else {
                break;
            }
        }
        pre1.next = second;
        return head;
    }
}
