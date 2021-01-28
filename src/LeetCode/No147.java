package LeetCode;

import common.ListNode;

/**
 * @author ：CK
 * @date ：Created in 2020/11/21 11:12
 * @description：
 */
public class No147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode result = head , cur = head , pre = null , tmp = null;
        boolean k = false;
        head = head.next;
        result.next = null;
        while (head != null){
            tmp = head;
            head = head.next;
            tmp.next = null;
            pre = null;
            cur = result;
            k = false;
            while (cur != null){
                if (cur.val < tmp.val){
                    pre = cur;
                    cur = cur.next;
                }
                else {
                    if (pre != null) {
                        pre.next = tmp;
                    }
                    else {
                        result = tmp;
                    }
                    tmp.next = cur;
                    k = true;
                    break;
                }
            }
            if (!k){
                pre.next = tmp;
            }
        }
        return result;
    }
}
