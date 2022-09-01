/**
 * @Class：getIntersectionNodeSolution
 * @Author:520.2.1
 * @BulidDate:2022/09/01
 */
package 链表及相应练习;

public class getIntersectionNodeSolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //两种思路：1.快慢指针，快指针总会追上满指针的 2. 分别遍历，然后对齐末尾再遍历
        ListNode fastCur = headA;
        ListNode slowCur = headB;
        while (fastCur!=slowCur){
            if(fastCur!=null){
                fastCur=fastCur.next;
            }
            else {
                fastCur=headB;
            }
            if(slowCur!=null){
                slowCur=slowCur.next;
            }
            else{
                slowCur=headA;
            }
        }
        return fastCur;
    }
}
