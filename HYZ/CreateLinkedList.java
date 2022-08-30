package com.jude.java;

/**
 * @author jude
 * @create 2022-08-29-16:52
 */
public class CreateLinkedList {
    public static void main(String[] args) {
//        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(1);
//        linkedList.addAtTail(3);
//        linkedList.addAtIndex(1, 2);
//        linkedList.get(1);
//        linkedList.deleteAtIndex(2);
//        System.out.println(linkedList.get(3));
//        System.out.println(linkedList);

        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(7);
//        linkedList.addAtHead(2);
//        linkedList.addAtHead(1);
//        linkedList.addAtIndex(3, 0);
//        linkedList.deleteAtIndex(2);
//        linkedList.addAtHead(6);
//        linkedList.addAtTail(4);
//        System.out.println(linkedList.head);
//        linkedList.get(4);
//        System.out.println(linkedList.get(4));
//        linkedList.addAtHead(4);
//        linkedList.addAtIndex(5, 0);
//        linkedList.addAtHead(6);
//        System.out.println(linkedList);

//        linkedList.addAtHead(1);
//        linkedList.addAtTail(3);
//        linkedList.addAtIndex(1,2);
//        linkedList.get(1);
//        System.out.println(linkedList.get(1));
//        linkedList.deleteAtIndex(1);
//        linkedList.get(1);
//        System.out.println(linkedList.get(1));

//        linkedList.addAtIndex(0,10);
//        linkedList.addAtIndex(0,20);
//        linkedList.addAtIndex(1,30);
//        linkedList.get(0);
//        System.out.println(linkedList.head);

//        linkedList.addAtTail(1);
//        linkedList.get(0);
//        System.out.println(linkedList.get(0));

//        linkedList.addAtHead(1);
//        linkedList.addAtTail(3);
//        linkedList.addAtIndex(1, 2);
//        linkedList.get(1);
//        System.out.println(linkedList.get(1));
//        linkedList.deleteAtIndex(1);
//        linkedList.get(1);
//        System.out.println(linkedList.get(1));
//        linkedList.get(3);
//        System.out.println(linkedList.get(3));
//        linkedList.deleteAtIndex(3);
//        linkedList.deleteAtIndex(0);
//        linkedList.get(0);
//        System.out.println(linkedList.get(0));
//        linkedList.deleteAtIndex(0);
//        linkedList.get(0);
//        System.out.println(linkedList.get(0));
//        System.out.println(linkedList.head);

        linkedList.addAtIndex(1, 0);
        System.out.println(linkedList.head);
        System.out.println(linkedList.get(0));

    }
}

class MyLinkedList {
    public DoubleListNode head = new DoubleListNode(-1);

    public MyLinkedList() {

    }

    public int get(int index) {
        if (index == 0) {
            if (head != null) {
                return head.val;
            } else {
                return -1;
            }
        }
        DoubleListNode temp = head;
        int i;
        for (i = 0; i < index; i++) {
            if (temp.next != null) {
                temp = temp.next;
            } else {
                break;
            }
        }
        if (i == index) {
            return temp.val;
        } else {
            return -1;
        }
    }

    public void addAtHead(int val) {
        if (head.val == -1) {
            head.val = val;
        } else {
            DoubleListNode node = new DoubleListNode(val);
            DoubleListNode temp = head;
            node.next = temp;
            temp.prev = node;
            head = node;
        }
    }

    public void addAtTail(int val) {
        if (head.val == -1) {
            addAtHead(val);
            return;
        }
        DoubleListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        DoubleListNode newNode = new DoubleListNode(val, null, node);
        node.next = newNode;

    }

    public void addAtIndex(int index, int val) {

        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (head.val == -1 && index > 0) {
            return;
        }
        DoubleListNode node = head;
        int i;
        for (i = 0; i < index; i++) {
            if (node.next != null) {
                node = node.next;
            } else {
                break;
            }
        }
        if (i == index - 1) {
            addAtTail(val);
            return;
        } else if (i < index - 1) {
            return;
        } else if (i == index) {
            DoubleListNode newNode = new DoubleListNode(val, node, node.prev);
            node.prev.next = newNode;
            node.prev = newNode;
        }

    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            if (head.next != null) {
                head.next.prev = null;
                head = head.next;
                return;
            } else {
                head = null;
                return;
            }

        }
        DoubleListNode temp = head;
        int i;
        for (i = 0; i < index; i++) {
            if (temp.next != null) {
                temp = temp.next;
            } else {
                break;
            }
        }
        if (i == index && temp.next != null) {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        } else if (i == index && temp.next == null) {
            temp.prev.next = null;
        } else {
            return;
        }


    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                '}';
    }
}

class DoubleListNode {
    public int val;
    public DoubleListNode next;
    public DoubleListNode prev;

    public DoubleListNode() {

    }

    public DoubleListNode(int val) {
        this.val = val;
    }

    public DoubleListNode(int val, DoubleListNode next, DoubleListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "DoubleListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
