package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/9/6 16:02
 * @description：
 */
public class No2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
 }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ln=new ListNode(0);
        ListNode first=ln;
        int k=0;
        while(l1!=null&&l2!=null){
            if(k==1){
                if((l2.val+l1.val+k)>=10){
                    k=1;
                    ln.val=l2.val+l1.val+k-10;
                }
                else{
                    ln.val=l2.val+l1.val+k;
                    k=0;
                }
            }
            else{
                if((l2.val+l1.val)>=10){
                    k=1;
                    ln.val=l2.val+l1.val-10;
                }
                else{
                    ln.val=l2.val+l1.val;
                }
            }
            l2=l2.next;
            l1=l1.next;
            ln.next=new ListNode(0);
            ln=ln.next;
        }
        while(l1!=null){
            if(k==1){
                if((l1.val+k)>=10){
                    k=1;
                    ln.val=l1.val+k-10;
                }
                else{
                    ln.val=l1.val+k;
                    k=0;
                }
            }
            else{
                ln.val=l1.val;
            }
            l1=l1.next;
            ln.next=new ListNode(0);
            ln=ln.next;
        }
        while(l2!=null){
            if(k==1){
                if((l2.val+k)>=10){
                    k=1;
                    ln.val=l2.val+k-10;
                }
                else{
                    ln.val=l2.val+k;
                    k=0;
                }
            }
            else{
                ln.val=l2.val;
            }
            l2=l2.next;
            ln.next=new ListNode(0);
            ln=ln.next;
        }
        if(k==1){
            ln.val=k;
        }
        else{
            ListNode l=first;
            while(l.next!=ln){
                l=l.next;
            }
            l.next=null;
        }
        return first;
    }
}
