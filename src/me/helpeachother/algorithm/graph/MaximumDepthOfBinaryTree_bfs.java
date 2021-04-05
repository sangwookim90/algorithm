package me.helpeachother.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree_bfs {
    public static void main(String[] args) {
        TreeNode_bfs tree = new TreeNode_bfs(3);
        tree.left = new TreeNode_bfs(1);
        tree.right = new TreeNode_bfs(4);
        tree.left.left = new TreeNode_bfs(5);
        tree.left.right = new TreeNode_bfs(8);
        tree.left.left.left = new TreeNode_bfs(7);
        MaximumDepthOfBinaryTree_bfs a = new MaximumDepthOfBinaryTree_bfs();
        System.out.println(a.bfs(tree));

    }

    public int bfs(TreeNode_bfs root) {

        if(root==null) return 0;

        Queue<TreeNode_bfs> queue = new LinkedList<>();

        queue.offer(root);
        int count = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for(int i=0; i<size; i++){
                TreeNode_bfs node = queue.poll();
                if(node.right!=null){
                    queue.offer(node.right);
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
            }
        }
        return count;
    }

}

class TreeNode_bfs {
    int val;
    TreeNode_bfs left, right;
    TreeNode_bfs(int x){
        this.val = x;
    }
}
