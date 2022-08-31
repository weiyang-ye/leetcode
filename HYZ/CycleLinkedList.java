package com.jude.java;

/**
 * @author jude
 * @create 2022-08-31-10:04
 */
public class CycleLinkedList {
    public static void main(String[] args) {
//        ListNode node1 = new ListNode(3);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(0);
//        ListNode node4 = new ListNode(-4);
//        ListNode node5 = new ListNode(5);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node2;
//        ListNode printNode = node1;
//        int size = 6;
//        while (size-- > 0) {
//            System.out.print(printNode + " -> ");
//            printNode = printNode.next;
//        }
//        System.out.println();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        node2.next = node1;
        ListNode findNode = detectCycle(node1);
        System.out.println(findNode);

    }

    /**
     * 思路分析：定义一个fast指针，一次走两步；定义一个slow指针，一次走一步
     * 两指针相遇时比在环内，假定slow在环内走过的距离为y，则slow一种走过的距离为 x+y
     * fast一共走过的距离为 x+n(y+z)+y，n为fast在环内已经走过的圈数
     * 此时有 fast = 2 * slow ，即 x+n(y+z)+y = 2(x+y),移项得：x = n(y+z)-y = (n-1)(y+z)+z
     * 此时从出发点发出一个index1指针，从相遇点发出一个index2指针，当走过 x = (n-1)(y+z)+z步数时，
     * 二者在环形链表的入环结点相遇，即为所求点
     *
     * @param
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode index = head;
        boolean flag = true;//判断指针是否已经出发
        while (flag || fast != slow) {//循环终止时即为环内处相遇位置
            flag = false;
            if (fast.next != null && fast.next.next != null && slow.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                return null;
            }
        }
        while (index != slow) {
            index = index.next;
            slow = slow.next;
        }

        return index;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val;
    }
}
