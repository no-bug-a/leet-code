package com.example.p1_100;


/**
 * @author zhangyi
 * @date 2022-12-12 19:36
 */
public class P19 {
    public static void main(String[] args) {
        int[] numbes = new int[]{1, 2, 3};
        ListNode.print(new P19().removeNthFromEnd(ListNode.build(numbes), 3));
    }

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * 示例 2：
     *
     * 输入：head = [1], n = 1
     * 输出：[]
     * 示例 3：
     *
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     *
     *
     * 提示：
     *
     * 链表中结点的数目为 sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     *
     *
     * 进阶：你能尝试使用一趟扫描实现吗？
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode nextNode = head;
        int len = 0;
        while (nextNode != null) {
            len++;
            nextNode = nextNode.next;
        }
        if (len == 1 && n == 1) return null;
        if (len == n) {
            head = head.next;
            return head;
        }
        nextNode = head;
        int count = 0;
        while (nextNode != null) {
            if (len - count == n + 1) {
                if (nextNode.next.next != null) {
                    nextNode.next = nextNode.next.next;
                } else {
                    nextNode.next = null;
                }
                return head;
            }
            count++;
            nextNode = nextNode.next;
        }
        return head;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public static ListNode build(int[] numbes) {
        ListNode root = new ListNode(numbes[0]);
        ListNode preNode = root;
        for (int i = 1; i < numbes.length; i++) {
            preNode.next = new ListNode(numbes[i]);
            preNode = preNode.next;
        }
        return root;
    }

    public static void print(ListNode node) {
        if (node == null) return;
        while (node != null) {
            System.out.print(node.val + "  ");
            node = node.next;
        }
        System.out.println();
    }
}

