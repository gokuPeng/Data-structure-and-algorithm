package 二叉搜索树;

import 二叉搜索树.printer.BinaryTrees;

public class Main {
    public static void main(String[] args) {
        BST binarySearchTree = new BST();
        Integer[] nums = {7, 4, 2, 1, 3, 5, 9, 8, 11, 10, 12};
        for (Integer num : nums) {
            binarySearchTree.add(num);
        }
        BinaryTrees.print(binarySearchTree);
        System.out.println();
        BinaryTrees.print(binarySearchTree);
    }
}
