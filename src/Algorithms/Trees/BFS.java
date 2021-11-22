package Algorithms.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(BFS(root, 4));
    }

    public static boolean BFS(TreeNode root, int val){
        Queue<TreeNode> bfsqueue = new LinkedList<>();
        bfsqueue.offer(root);
        while(!bfsqueue.isEmpty()){
            int size = bfsqueue.size();
            while(size-- > 0){
                TreeNode node = bfsqueue.poll();
                if(node.val == val){
                    return true;
                }
                if(node.left != null){
                    bfsqueue.offer(node.left);
                }
                if(node.right != null){
                    bfsqueue.offer(node.right);
                }
            }
        }
        return false;
    }
}
