/**
 * @Class：DeleteNNode
 * @Author:520.2.1
 * @BulidDate:2022/09/01
 */
package 链表及相应练习;

class SLinkedListD extends SingleLinkedList{
    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode dummyNode=new ListNode(0);
        dummyNode.next=head;
        ListNode fastCur=dummyNode;
        ListNode slowCur=dummyNode;
        int count=0;
        while (n!=0 && fastCur!=null){
            n--;
            fastCur=fastCur.next;
        }
        fastCur=fastCur.next;
        while(fastCur!=null){
            fastCur=fastCur.next;
            slowCur=slowCur.next;
        }
        slowCur.next=slowCur.next.next;
        return dummyNode.next;
    }
}

public class DeleteNNode {
    public static void main(String[] args) {
        SLinkedListD se = new SLinkedListD();
        se.addAtTail(1);
        se.addAtTail(2);
        se.addAtTail(3);
        se.addAtTail(4);
        se.head=se.removeNthFromEnd(se.head.next,2);
        System.out.println(se.head.toString());
    }
}
