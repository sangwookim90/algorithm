package me.helpeachother.algorithm.graph;

import java.util.Stack;

public class MaximumDepthOfBinaryTree_dfs {
    public static void main(String[] args) {
        TreeNode_dfs tree = new TreeNode_dfs(3);
        tree.left = new TreeNode_dfs(1);
        tree.right = new TreeNode_dfs(4);
        tree.left.left = new TreeNode_dfs(5);
        tree.left.right = new TreeNode_dfs(8);
        tree.left.left.left = new TreeNode_dfs(7);
        MaximumDepthOfBinaryTree_dfs a = new MaximumDepthOfBinaryTree_dfs();
        System.out.println(a.dfs(tree));

    }

    public int dfs(TreeNode_dfs root) {
        if(root == null) return 0;
        Stack<TreeNode_dfs> stack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();

        stack.push(root);
        valueStack.push(1);
        int max = 0;

        while(!stack.empty()) {
            TreeNode_dfs node = stack.pop();
            int count = valueStack.pop();

            max = Math.max(max, count);
            if(node.left!=null) {
                stack.push(node.left);
                valueStack.push(count+1);
            }
            if(node.right!= null) {
                stack.push(node.right);
                valueStack.push(count+1);
            }
        }

        return max;



    }

}

class TreeNode_dfs {
    int val;
    TreeNode_dfs left, right;
    TreeNode_dfs(int x){
        this.val = x;
    }
}
