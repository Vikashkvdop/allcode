package BinarySearchTree;

public class basicOperation {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val=val;
        }
    }
    public static int findSize(TreeNode root){
        if(root==null) return 0;
         return 1+findSize(root.left)+findSize(root.right);
    }

    //find height of tree
    public static int height(TreeNode root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 0;

        return 1+ Math.max(height(root.left),height(root.right));
    }

    //find max value in tree
    public static int max(TreeNode root){
        if (root==null) {
            return Integer.MIN_VALUE;
        }
        int a=root.val;
        int b=max(root.left);
        int c=max(root.right);
        return Math.max(a,Math.max(b,c));
    }

    //sum of nodes
    public static int findSum(TreeNode root){
        if(root==null) return 0;
        return root.val+findSum(root.left)+findSum(root.right);
    }
    public static void preorder(TreeNode root){
        if(root==null) return;
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void display(TreeNode root){
        if(root==null) return;
        System.out.print(root.val+" ");
        if (root.left!=null) {
            System.out.print(root.left.val+" ");
        }
        if (root.right!=null) {
            System.out.print(root.right.val+" ");
        }
        System.out.println();
        display(root.left);
        display(root.right);
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(4);
        TreeNode a=new TreeNode(3);
        TreeNode b=new TreeNode(6);
        root.left=a;
        root.right=b;
        TreeNode c=new TreeNode(2);
        TreeNode d=new TreeNode(5);
        a.left=c;
        a.right=d;
        TreeNode e=new TreeNode(12);
        b.right=e;

        //display(root);
        //System.out.println(findSize(root));
        //preorder(root);
        // System.out.println(findSum(root));
        // System.out.println(max(root));
        System.out.println(height(root));
    }
}
