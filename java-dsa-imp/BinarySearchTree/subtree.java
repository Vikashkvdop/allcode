package BinarySearchTree;

//Subtree of another tree
// Given the of two binary trees and subroot return true if there is a subtree of root with same structure and node
//values of subroot and false otherwise
public class subtree {
    static class treeNode{
        int data;
        treeNode left,right;
        public treeNode(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static boolean isSubtree(treeNode root,treeNode subRoot){
        if (root==null) {
            return false;
        }
        if(root.data==subRoot.data){
            if (isIdentical(root,subRoot)) {
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public static boolean isIdentical(treeNode node, treeNode subRoot){
        if(node==null && subRoot==null){
            return true;
        }else if(node==null || subRoot==null || node.data!=subRoot.data){
            return false;
        }
        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        treeNode node=new treeNode(1);
        treeNode b= node.left=new treeNode(2);
        b.left=new treeNode(4);
        b.right=new treeNode(5);
        treeNode c=node.right=new treeNode(3);
        c.right=new treeNode(6);

        treeNode subRoot=new treeNode(2);
        subRoot.left=new treeNode(4);
        subRoot.right=new treeNode(5);

        System.out.println(isSubtree(node, subRoot));
    }
}
