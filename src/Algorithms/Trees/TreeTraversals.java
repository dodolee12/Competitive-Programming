package Algorithms.Trees;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversals {
    static List<Integer> preorder = new ArrayList<>();
    static List<Integer> inorder = new ArrayList<>();
    static List<Integer> postorder = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        preorder(root);
        inorder(root);
        postorder(root);
        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postorder);

    }

    //root left right
    public static void preorder(TreeNode root){
        if(root == null){
            return;
        }
        preorder.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    //left root right
    public static void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        inorder.add(root.val);
        inorder(root.right);
    }

    //left right root
    public static void postorder(TreeNode root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        postorder.add(root.val);
    }
}
