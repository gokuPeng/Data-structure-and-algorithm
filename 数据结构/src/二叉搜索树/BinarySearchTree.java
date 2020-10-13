package 二叉搜索树;

import java.util.Comparator;

public class BinarySearchTree<E>{

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
            return;
        }
        // 如果不是添加的第一个元素
        // 找到父节点
        Node<E> parent = root;
        // 存放遍历前，parent的值，防止parent为null的时候找不到上一个节点
        Node<E> node = root;
        int cmp = compare(element, parent.element);
        while (parent != null) {
            node = parent;
            if (cmp > 0) {
                // 如果元素比父节点大，则放在右子树
                parent = parent.right;
            } else if (cmp < 0) {
                // 如果元素比父节点小，则放在左子树
                parent = parent.left;
            } else {
                // 如果元素等于父节点，那什么也不做
                return;
            }
        }
        if (cmp > 0) {
            node.right = new Node<>(element, node);
        } else {
            node.left = new Node<>(element, node);
        }
        size++;
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
}
