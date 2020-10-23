package 二叉搜索树;

import 二叉搜索树.printer.BinaryTrees;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Integer[] nums = {7, 4, 2, 1, 3, 5, 9, 8, 11, 10, 12};
        for (Integer num : nums) {
            binarySearchTree.add(num);
        }
        BinaryTrees.print(binarySearchTree);
        System.out.println();
        binarySearchTree.preorder(new BinarySearchTree.Visitor<Integer>() {
            @Override
            boolean visit(Integer element) {
                System.out.print(element + " ");
                return false;
            }
        });
        System.out.println();
        binarySearchTree.inorder(new BinarySearchTree.Visitor<Integer>() {
            @Override
            boolean visit(Integer element) {
                System.out.print(element + " ");
                return false;
            }
        });
        System.out.println();
        binarySearchTree.postorder(new BinarySearchTree.Visitor<Integer>() {
            @Override
            boolean visit(Integer element) {
                System.out.print(element + " ");
                return false;
            }
        });
        System.out.println();
        binarySearchTree.levelOrder(new BinarySearchTree.Visitor<Integer>() {
            @Override
            boolean visit(Integer element) {
                System.out.print(element + " ");
                return false;
            }
        });
    }
}
