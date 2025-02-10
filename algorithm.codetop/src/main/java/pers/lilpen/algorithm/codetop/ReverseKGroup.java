package pers.lilpen.algorithm.codetop;

/**
 * @author : penghuaishun
 * @version : 1.0
 * @date : 2024-11-01 15:09
 **/
public class ReverseKGroup {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        while (head != null) {
            for (int i = 0; i < k - 1; i++) {

            }
        }
        return null;
    }

    /**
     * 反转链表
     *
     * @param head 链表头节点
     * @return 返回反转后的链表和尾节点
     */
    private ListNode[] reverse(ListNode head, int k) {
        ListNode pre = null;
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return new ListNode[]{pre, tail};
    }
}
