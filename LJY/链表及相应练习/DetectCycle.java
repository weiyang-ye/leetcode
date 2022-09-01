/**
 * @Class：detectCycle
 * @Author:520.2.1
 * @BulidDate:2022/09/01
 */
package 链表及相应练习;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fastCur=head;
        ListNode slowCur=head;
        while(fastCur!=null&&fastCur.next!=null){
            fastCur=fastCur.next.next;
            slowCur=slowCur.next;
            if(fastCur==slowCur){
                ListNode cur1=head;
                ListNode cur2=slowCur;
                while (cur2!=cur1){
                    cur2=cur2.next;
                    cur1=cur1.next;
                }
                return cur1;
            }
        }
        return null;
    }
}
