package com.leetcode.Date0823;

// 判断一个树是否是平衡二叉树

import sun.reflect.generics.tree.Tree;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }
}

public class BalanceTree {

    private boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        getLength(root);
        return flag;
    }

    // 遍历树的节点 求树的深度
    private int getLength(TreeNode root){
        // 如果树根据当前节点可以检验出已经不是平衡树 就无需做其他节点的检验了
        if (root == null || !flag){
            return 0;
        }
        int left = getLength(root.left);
        int right = getLength(root.right);
        if (Math.abs(left - right) > 1){
            flag = false;
        }
        return Math.max(left, right) + 1;
    }

}
