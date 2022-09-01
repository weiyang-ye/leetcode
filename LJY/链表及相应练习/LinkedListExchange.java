/**
 * @Class：LinkedListExchange
 * @Author:520.2.1
 * @BulidDate:2022/09/01
 */

package 链表及相应练习;
/*题目：给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
* */


class SingleListE extends SingleLinkedList{
    public ListNode SwapPair(ListNode head){
        ListNode dummyhead= new ListNode(0);
        dummyhead.next=head;
        ListNode Cur=dummyhead;
        while (Cur.next!=null && Cur.next.next!=null){
            // 教训：循环的终止条件，注意不能够反转哦！！
            ListNode temp = head.next.next; // 缓存 next
            Cur.next = head.next;          // 将 prev 的 next 改为 head 的 next
            Cur.next.next = head;          // 将 head.next(prev.next) 的next，指向 head
            head.next = temp;               // 将head 的 next 接上缓存的temp
            Cur = head;                    // 步进1位
            head = head.next;               // 步进1位
        }
        return dummyhead.next;
    }

}

/**
 * @author 520.2.1
 */
public class LinkedListExchange {
    public static void main(String[] args) {
        SingleListE se = new SingleListE();
        se.addAtTail(1);
        se.addAtTail(2);
        se.addAtTail(3);
        se.addAtTail(4);
        se.head = se.SwapPair(se.head.next);
        System.out.println(se.head.toString());
    }
}
