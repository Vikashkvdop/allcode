
package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class traversal {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }
    //preorder traversal root->left->right
    public static void preorder(TreeNode root){
        if(root==null) return;
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }

    //inorder traversal left->root->right
    public static void inorder(TreeNode root){
        if (root==null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }

    //postorder traversal left->right->root
    public static void postorder(TreeNode root){
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val+" ");
    }
    //find product of all nodes
    

    //print nth level of tree
    public static void nthLevel(TreeNode root, int n){
        if(root==null) return;
        if(n==1) System.out.print(root.val+" ");
        nthLevel(root.left, n-1);
        nthLevel(root.right, n-1);
    }

    //Breath first search (BFS) traversal
    public static void bfs(TreeNode root){
        Queue<TreeNode>q=new LinkedList<>();
        if(root!=null) q.add(root);
        while (q.size()>0) {
            TreeNode temp=q.peek();
            if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
            System.out.print(temp.val+" ");
            q.remove();
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(4);
        TreeNode a=new TreeNode(2);
        TreeNode b=new TreeNode(6);
        root.left=a;
        root.right=b;
        TreeNode c=new TreeNode(1);
        TreeNode d=new TreeNode(5);
        a.left=c;
        a.right=d;
        TreeNode e=new TreeNode(9);
        b.right=e;

        // preorder(root);
        // System.out.println();
        // inorder(root);
        // System.out.println();
        // postorder(root);

        //nthLevel(root, 3);
        bfs(root);

    }
}
