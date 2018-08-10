package com.dyu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dyu
 * @date 2018/08/10
 */
public class BinaryTreeEach {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();

        if (root.left != null) {
            inorderTraversal(root.left);
        }
        return null;
    }

    void recursive(TreeNode root, List<Integer> nodes) {
        if (root.left != null) {
            recursive(root.left, nodes);
        }
        if (root.right != null) {
            recursive(root.right, nodes);
        }
        nodes.add(root.val);
    }


}

