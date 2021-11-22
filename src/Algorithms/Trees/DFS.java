package Algorithms.Trees;

public class DFS {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(DFS(root,4));
    }

    public static boolean DFS(TreeNode root, int val){
        if(root == null){
            return false;
        }
        if(root.val == val){
            return true;
        }
        return DFS(root.left,val) || DFS(root.right,val);
    }
}
