package AVL树;

import AVL树.printer.BinaryTrees;

public class Main {
    public static void main(String[] args) {
        BST<Integer> avlTree = new AVLTree();
        Integer[] nums = {79, 84, 94, 46, 76, 68, 83, 90, 25, 19, 51, 7, 11, 41, 37, 55, 67};
        for (Integer num : nums) {
            avlTree.add(num);
        }
        avlTree.remove(51);
        BinaryTrees.print(avlTree);
    }
}
