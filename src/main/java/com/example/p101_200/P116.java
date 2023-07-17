package com.example.p101_200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangyi
 * @date 2022-12-15 20:59
 */
public class P116 {
    public static void main(String[] args) {
        new P116().connect(Node.build(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    /**
     * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
     *
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     *
     * 初始状态下，所有 next 指针都被设置为 NULL。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：root = [1,2,3,4,5,6,7]
     * 输出：[1,#,2,3,#,4,5,6,7,#]
     * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
     * 示例 2:
     *
     * 输入：root = []
     * 输出：[]
     *
     *
     * 提示：
     *
     * 树中节点的数量在 [0, 212 - 1] 范围内
     * -1000 <= node.val <= 1000
     *
     *
     * 进阶：
     *
     * 你只能使用常量级额外空间。
     * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
     */
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        int n = 1;
        Node preNode = root;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
            if (Math.pow(2, n - 1) - 1 == count) {
                //换层
                n++;
            } else {
                preNode.next = poll;
            }
            preNode = poll;
            count++;
        }
        return root;
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static Node build(int[] nums) {
        if (nums.length == 0) return null;
        Node root = new Node(nums[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int n = 2;
        while (!queue.isEmpty() && Math.pow(2, n - 1) - 1 < nums.length) {
            for (int i = (int)Math.pow(2, n - 1) - 1; i < nums.length && i < (int)Math.pow(2, n) - 1; i += 2) {
                Node poll = queue.poll();
                assert poll != null;
                poll.left = new Node(nums[i]);
                queue.offer(poll.left);
                if (i + 1 < nums.length) {
                    poll.right = new Node(nums[i + 1]);
                    queue.offer(poll.right);
                }
            }
            n++;
        }
        return root;
    }
}
