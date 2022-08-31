package 链表及相应练习;
/*
 * @Author: error: git config user.name && git config user.email & please set dead value or install git
 * @Date: 2022-08-31 11:57:01
 * @LastEditors: error: git config user.name && git config user.email & please set dead value or install git
 * @LastEditTime: 2022-08-31 15:54:37
 * @FilePath: \Leetcode\LinkedListPractise.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */ 
class SLinkedListT extends SingleLinkedList{
    //教训2：继承的类不要嵌套在main类中！
        SLinkedListT(){
            size = 0;
            head = new ListNode(0);
        }
        public void transpose(ListNode head){
            ListNode slowCur = null;
            ListNode fastCur = head;
            ListNode tmpListNode = null;
            while(fastCur!=null){
                tmpListNode = fastCur.next;
                fastCur.next = slowCur;
                slowCur = fastCur;
                fastCur = tmpListNode;
            }
            // 教训1：读链表都是通过head来读取的，反转后务必将head指向最后一个节点
            this.head.next = slowCur;
        }
    }

class DLinkedListT extends DoubleLinkedList{
    public void transpose(doubleListNode head){
        doubleListNode slowCur = null;
        doubleListNode fastCur = head;
        doubleListNode tmpListNode = null;
        while(fastCur!=null){
            if(slowCur == null){
                tmpListNode = fastCur.next;
                fastCur.next = slowCur;
                slowCur = fastCur;
                fastCur = tmpListNode;
            }
            else{
                tmpListNode = fastCur.next;
                fastCur.next = slowCur;
                slowCur.prev = fastCur;
                slowCur = fastCur;
                fastCur = tmpListNode;
            }

        }
        // TODO:为什么不能够直接写head=tail？
        head.next=tail.next;
        head.prev=null;
        fastCur = head;
        for (int i = 0; i < this.size; i++){
            fastCur = fastCur.next;
        }
        
        fastCur.next = this.tail;
        tail.prev = fastCur.next;
        tail.next = null;
    }
}
public class LinkedListPractise {
    public static void main(String[] avgs){
        SLinkedListT sl = new SLinkedListT();
        sl.addAtHead(10);
        sl.addAtTail(20);
        sl.addAtIndex(1, 22);
        sl.transpose(sl.head);
        System.out.println(sl.get(0));
        System.out.println(sl.get(1));
        System.out.println(sl.get(2));

        DLinkedListT dl =new DLinkedListT();
        dl.addAtHead(10);
        dl.addAtTail(20);
        dl.addAtIndex(1, 22);
        dl.transpose(dl.head);
        System.out.println(dl.get(0));
        System.out.println(dl.get(1));
        System.out.println(dl.get(2));

    }
}
