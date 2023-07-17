package com.example.p601_700;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangyi
 * @date 2022-12-13 15:18
 */
public class P617 {
    public static void main(String[] args) {
        TreeNode root1 = TreeNode.build(new int[]{1,3,2,5});
        TreeNode root2 = TreeNode.build(new int[]{2,1,3,Integer.MIN_VALUE,4,Integer.MIN_VALUE,7});
        TreeNode.print(new P617().mergeTrees(root1, root2));
        System.out.println();
    }

    /**
     * 给你两棵二叉树： root1 和 root2 。
     *
     * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
     *
     * 返回合并后的二叉树。
     *
     * 注意: 合并过程必须从两个树的根节点开始。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
     * 输出：[3,4,5,5,4,null,7]
     * 示例 2：
     *
     * 输入：root1 = [1], root2 = [1,2]
     * 输出：[2,2]
     *
     * 提示：
     *
     * 两棵树中的节点数目在范围 [0, 2000] 内
     * -104 <= Node.val <= 104
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        TreeNode root = new TreeNode(root1.val + root2.val);
        fnc(root, root1, root2);

        return root;
    }

    private void fnc(TreeNode node, TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return;
        if (node1 == null) {
            node.val = node2.val;
        } else if (node2 == null) {
            node.val = node1.val;
        } else {
            node.val = node1.val + node2.val;
        }
        if (node1 != null && node1.left != null || node2 != null && node2.left != null) {
            node.left = new TreeNode();
        }
        if (node1 != null && node1.right != null || node2 != null && node2.right != null) {
            node.right = new TreeNode();
        }
        fnc(node.left, node1 == null ? null : node1.left, node2 == null ? null : node2.left);
        fnc(node.right, node1 == null ? null : node1.right, node2 == null ? null : node2.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
    public static TreeNode build(int[] nums) {
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int n = 2;
        while (!queue.isEmpty() && Math.pow(2, n - 1) - 1 < nums.length) {
            for (int i = (int)Math.pow(2, n - 1) - 1; i < nums.length && i < (int)Math.pow(2, n) - 1; i += 2) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    queue.add(null);
                    queue.add(null);
                    continue;
                }
                if (nums[i] != Integer.MIN_VALUE) {
                    poll.left = new TreeNode(nums[i]);
                }
                queue.add(poll.left);
                if (i + 1 < nums.length) {
                    if (nums[i + 1] != Integer.MIN_VALUE) {
                        poll.right = new TreeNode(nums[i + 1]);
                    }
                    queue.add(poll.right);
                }
            }
            n++;
        }

        return root;
    }

    public static void print(TreeNode mergeTrees) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(mergeTrees);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
// start: 2^(n-1) - 1, end: 2^n - 1
/**



                0
        1               2
    3      4       5        6
 7    8  9   10  11 12   13  14


 */