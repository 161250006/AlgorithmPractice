package LeetCode;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：CK
 * @date ：Created in 2020/10/20 9:07
 * @description：
 */
public class No143 {
    public void reorderList(ListNode head) {
        if (head == null){
            return;
        }
        ArrayList<ListNode> listNodeArrayList = new ArrayList<>();
        while (head != null){
            listNodeArrayList.add(head);
            head = head.next;
        }
        ListNode listNode = null;
        int begin = 0, end = listNodeArrayList.size()-1;
        while (begin <= end){
            if (begin != end) {
                if (listNode == null) {
                    listNode = listNodeArrayList.get(begin);
                    listNode.next = listNodeArrayList.get(end);
                    listNode = listNode.next;
                }
                else {
                    listNode.next = listNodeArrayList.get(begin);
                    listNode = listNode.next;
                    listNode.next = listNodeArrayList.get(end);
                    listNode = listNode.next;
                }
            }
            else {
                if (listNode == null) {
                    listNode = listNodeArrayList.get(begin);
                }
                else {
                    listNode.next = listNodeArrayList.get(begin);
                    listNode = listNode.next;
                }
            }
            begin++;
            end--;
        }
        listNode.next = null;
    }
//寻找链表中点 + 链表逆序 + 合并链表
    public void reorderList1(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}
