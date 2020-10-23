package 二叉搜索树;

import sun.reflect.generics.visitor.Visitor;
import 二叉搜索树.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E> implements BinaryTreeInfo {

    private int size;
    private Node<E> root;
    private Comparator<E> comparator;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {

    }

    /*
        添加一个元素
     */
    public void add(E element) {
        elementNotNullCheck(element);
        // 如果是添加第一个元素
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }
        // 如果不是添加的第一个元素
        // 找到父节点
        Node<E> parent = root;
        // 存放遍历前，parent的值，防止parent为null的时候找不到上一个节点
        Node<E> node = root;
        int cmp = 0;
        while (parent != null) {
            cmp = compare(element, parent.element);
            node = parent;
            if (cmp > 0) {
                // 如果元素比父节点大，则放在右子树
                parent = parent.right;
            } else if (cmp < 0) {
                // 如果元素比父节点小，则放在左子树
                parent = parent.left;
            } else {
                // 如果元素等于父节点
                break;
            }
        }
        if (cmp > 0) {
            node.right = new Node<>(element, node);
        } else if (cmp < 0) {
            node.left = new Node<>(element, node);
        } else {
            // 如果元素等于父节点
            node.element = element;
            return;
        }
        size++;
    }

    public void preorder(Visitor<E> visitor) {
        if (visitor == null) return;
        preorder(root, visitor);
    }

    private void preorder(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;

        visitor.stop = visitor.visit(node.element);
        preorder(node.left, visitor);
        preorder(node.right, visitor);
    }

    public void inorder(Visitor<E> visitor) {
        if (visitor == null) return;
        inorder(root, visitor);
    }

    private void inorder(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;

        inorder(node.left, visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
        inorder(node.right, visitor);
    }

    public void postorder(Visitor<E> visitor) {
        if (visitor == null) return;
        postorder(root, visitor);
    }

    private void postorder(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;

        postorder(node.left, visitor);
        postorder(node.right, visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
    }

    public void levelOrder(Visitor<E> visitor) {
        if (root == null || visitor == null) return;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (visitor.visit(node.element)) return;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static abstract class Visitor<E> {
        boolean stop = false;
        /*
            如果返回true就停止遍历
         */
        abstract boolean visit(E element);
    }



    @SuppressWarnings("unchecked")
    private int compare(E e1, E e2) {
        if (comparator == null) {
            return ((Comparable<E>) e1).compareTo(e2);
        }
        return comparator.compare(e1, e2);
    }

    public void remove(E element) {

    }

    public boolean contains(E element) {
        return false;
    }

    private void remove() {

    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>) node;
        Node<E> parent = ((Node<E>) node).parent;
        String parentStr;
        if (parent == null) {
            parentStr = "null";
        } else {
            parentStr = parent.element.toString();
        }
        return "(" + myNode.element + ")_" + parentStr;
    }

//    /**
//     * 前序遍历
//     */
//    public void preorderTraversal() {
//        preorderTraversal(root);
//    }
//
//    private void preorderTraversal(Node<E> node) {
//        if (node == null) return;
//        System.out.print(node.element + " ");
//        preorderTraversal(node.left);
//        preorderTraversal(node.right);
//    }
//
//    /**
//     * 中序遍历
//     */
//    public void inorderTraversal() {
//        inorderTraversal(root);
//    }
//
//    private void inorderTraversal(Node<E> node) {
//        if (node == null) return;
//        inorderTraversal(node.left);
//        System.out.print(node.element + " ");
//        inorderTraversal(node.right);
//    }
//
//    /**
//     * 后序遍历
//     */
//    public void postorderTraversal() {
//        postorderTraversal(root);
//    }
//
//    private void postorderTraversal(Node<E> node) {
//        if (node == null) return;
//        postorderTraversal(node.left);
//        postorderTraversal(node.right);
//        System.out.print(node.element + " ");
//    }
//
//    /**
//     * 层序遍历
//     */
//    public void levelOrderTranversal() {
//        if (root == null) return;
//        Queue<Node<E>> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            Node<E> node = queue.poll();
//            System.out.print(node.element + " ");
//            if (node.left != null) queue.offer(node.left);
//            if (node.right != null) queue.offer(node.right);
//        }
//    }
}
