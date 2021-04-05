package me.helpeachother.algorithm.queueandstack;

import java.util.*;

public class BinaryTreeLevelOrder {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BinaryTreeLevelOrder a = new BinaryTreeLevelOrder();

        System.out.println(a.solve(root));

    }

    public List<List<Integer>> solve(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }

            }
            result.add(list);

        }

        return result;

    }

    public List<List<Integer>> solve_practice_with_some_hint(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        result.add(rootList);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            List<Integer> list = new ArrayList<>();

            if(node.left != null) {
                queue.offer(node.left);
                list.add(node.left.val);
            }
            if(node.right != null) {
                queue.offer(node.right);
                list.add(node.right.val);
            }
            if(list.size()>0) result.add(list);
        }

        return result;
    }
}


class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        this.val = x;
    }
}