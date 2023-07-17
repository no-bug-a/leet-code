package com.example.p801_900;

/**
 * @author zhangyi
 * @date 2022-12-12 17:47
 */
public class P876 {
    public static void main(String[] args) {
        int[] numbes = new int[]{1,2,3,4};
        ListNode.print(new P876().middleNode(ListNode.build(numbes)));
    }

    /**
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     *
     * 如果有两个中间结点，则返回第二个中间结点。
     *
     * 示例 1：
     *
     * 输入：[1,2,3,4,5]
     * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
     * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
     * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
     * 示例 2：
     *
     * 输入：[1,2,3,4,5,6]
     * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
     * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
     *
     *
     * 提示：
     *
     * 给定链表的结点数介于 1 和 100 之间。
     */
    public ListNode middleNode(ListNode head) {
        ListNode nextNode = head;
        int len = 0;
        while (nextNode != null) {
            len++;
            nextNode = nextNode.next;
        }
        nextNode = head;
        int count = 0;
        int mind = len / 2;
        while (nextNode != null) {
            if (count == mind) {
                return nextNode;
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
