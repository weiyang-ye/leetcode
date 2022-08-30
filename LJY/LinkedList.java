/*
 * @Author: error: git config user.name && git config user.email & please set dead value or install git
 * @Date: 2022-08-30 16:27:24
 * @LastEditors: error: git config user.name && git config user.email & please set dead value or install git
 * @LastEditTime: 2022-08-30 17:46:11
 * @FilePath: \Leetcode\LinkedList.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val=val;
    }
}
//单链表
class SingleLinkedList{
    int size; //存储元素个数
    ListNode head; //虚拟头节点
    //初始化链表
    public SingleLinkedList(){
        size = 0;
        head = new ListNode(0);
    }
    //获取第index个节点的数值
    public int get(int index) {
        if (index < 0 || index >= size){
            return -1;
        }
        ListNode currentNode = head;
        for (int i = 0; i <= index; i++){
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }
    //在链表最前面插入一个节点
    public void addAtHead (int val) {
        addAtIndex(0, val);
    }
    //在链表最后面插入一个节点
    public void addAtTail (int val) {
        addAtIndex(size, val);
    }
    //在链表第index处插入一个节点
    public void addAtIndex (int index, int val) {
        if (index > size) { return;}
        if (index < 0) {index = 0;}
        size++;
        ListNode pred = head;
        for (int i =0; i < index; i++){
            pred = pred.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }
    //在链表中删除第index个节点
    public void deleteAtIndex (int index) {
        if (index <0 || index >=size) {
            return;
        }
        size--;
        ListNode pred = head;
        for (int i = 0; i < index; i++){
            pred = pred.next;
        }
        pred.next = pred.next.next;

    }
}
// 双链表
class DoubleLinkedList{
    class doubleListNode{
        int val;
        doubleListNode next,prev;
        doubleListNode(int val){
            this.val = val;
        }
    }

    int size;
    doubleListNode head,tail;//虚拟头尾节点
    
    DoubleLinkedList(){
        size = 0;
        head = new doubleListNode(0);
        tail = new doubleListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    //获取链表第index个节点的数值
    public int get (int index) {
        if (index < 0 || index >= size){
            return -1;
        }
        doubleListNode cur = head;
        if (index < size  << 2 ){
            for ( int i = 0; i <= index; i++){
                cur = cur.next;
            }
        }
        else {
            cur = tail;
            for (int i = 0; i <= size - index; i++){
                cur = cur.prev;
            }
        }
        return cur.val;
    }
    //在首位增加节点
    public void addAtHead(int val){
        doubleListNode newnode = new doubleListNode(val);
        doubleListNode cur = head;
        newnode.next = cur.next;
        cur.next.prev = newnode;
        cur.next = newnode;
        newnode.prev = cur;
        size++;
    }
    //在末尾增加节点
    public void addAtTail(int val){
        doubleListNode newN = new doubleListNode(val);
        doubleListNode cur = tail;
        newN.prev = cur.prev;
        cur.prev.next = newN;
        newN.next = cur;
        cur.prev = newN;
        size++;
    }
    //在第index处增加节点
    public void addAtIndex(int index, int val){
        if (index < 0){index = 0;}
        if (index > size){return;}
        doubleListNode cur = head;
        for (int i = 0; i < index; i++){
            cur=cur.next;
        }
        doubleListNode newNode = new doubleListNode(val);
        newNode.next = cur.next;
        cur.next.prev = newNode;
        newNode.prev = cur;
        cur.next = newNode;
        size++;
    }
    //在第index处删除节点
    public void deleteAtIndex(int index){
        if (index < 0){index = 0;}
        if (index > size){return;}
        doubleListNode cur = head;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        cur.next.next.prev = cur;
        cur.next = cur.next.next;
        size--;
    }
}

public class LinkedList {
    public static void main(String[] agvs){
        SingleLinkedList sl = new SingleLinkedList();
        sl.addAtHead(10);
        sl.addAtTail(20);
        sl.addAtIndex(1, 22);
        System.out.println(sl.get(0));
        System.out.println(sl.get(1));
        System.out.println(sl.get(2));
        sl.deleteAtIndex(2);
        System.out.println(sl.get(2));

        DoubleLinkedList dl =new DoubleLinkedList();
        dl.addAtHead(10);
        dl.addAtTail(20);
        dl.addAtIndex(1, 22);
        //System.out.println(dl.get(0));
        System.out.println(dl.get(1));
        System.out.println(dl.get(2));
        dl.deleteAtIndex(2);
        System.out.println(dl.get(2));
    }
}

