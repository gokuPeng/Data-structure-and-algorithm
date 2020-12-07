package AVL树;

import java.util.Comparator;

public class AVLTree<E> extends BST<E> {
    public AVLTree() {
        this(null);
    }

    public AVLTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    protected void afterAdd(Node<E> node) {
        while((node = node.parent) != null) {
            if (isBalance(node)) {
                // 对于平衡的结点，更新高度
                ((AVLNode<E>)node).updateHeight();
            } else {
                // 恢复平衡
                rebanlance(node);
                break;
            }
        }
    }

    @Override
    protected void afterRemove(Node<E> node) {
        while((node = node.parent) != null) {
            if (isBalance(node)) {
                // 对于平衡的结点，更新高度
                ((AVLNode<E>)node).updateHeight();
            } else {
                // 恢复平衡
                rebanlance(node);
            }
        }
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new AVLNode<>(element, parent);
    }


    /**
     * 恢复平衡
     * @param grand 高度最低的那个不平衡结点
     */
    private void rebanlance(Node<E> grand) {
        // 下面要找到parent，和下面的node，才能进行旋转
        // 左右结点中高度最高的即为parent，同理往下就是node
        Node<E> parent = ((AVLNode<E>)grand).tallerChild();
        Node<E> node = ((AVLNode<E>)parent).tallerChild();
        if(parent.isLeft()) { // L
            if (node.isLeft()) { // LL
                rotateRight(grand);
            } else { // LR
                rotateLeft(parent);
                rotateRight(grand);
            }
        } else { // R
            if (node.isLeft()) { // RL
                rotateRight(parent);
                rotateLeft(grand);
            } else { // RR
                rotateLeft(grand);
            }
        }
    }

    /**
     * 左旋转
     * @param grand
     */
    private void rotateLeft(Node<E> grand) {
        Node<E> grandParent = grand.parent;
        Node<E> parent = grand.right;
        // 维护parent的父节点
        if (!grand.isLeft() && !grand.isRight()) {
            root = parent;
        } else if (grand.isLeft()) {
            grandParent.left = parent;
        } else {
            grandParent.right = parent;
        }
        parent.parent = grandParent;

        // 维护g的父节点,维护parent.left的父节点
        if (parent.left != null)
            parent.left.parent = grand;
        grand.parent = parent;

        // 旋转
        grand.right = parent.left;
        parent.left = grand;

        // 更新高度
        ((AVLNode<E>)grand).updateHeight();
        ((AVLNode<E>)parent).updateHeight();
    }

    /**
     * 右旋转
     * @param grand
     */
    private void rotateRight(Node<E> grand) {
        Node<E> grandParent = grand.parent;
        Node<E> parent = grand.left;
        // 维护parent的父节点
        if (!grand.isLeft() && !grand.isRight()) {
            root = parent;
        } else if (grand.isLeft()) {
            grandParent.left = parent;
        } else {
            grandParent.right = parent;
        }
        parent.parent = grandParent;

        // 维护g的父节点,维护parent.right
        if (parent.right != null)
            parent.right.parent = grand;
        grand.parent = parent;

        // 旋转
        grand.left = parent.right;
        parent.right = grand;

        // 更新高度
        ((AVLNode<E>)grand).updateHeight();
        ((AVLNode<E>)parent).updateHeight();
    }

    /**
     * 判断此结点是否平衡
     * @param node
     * @return
     */
    private boolean isBalance(Node<E> node) {
        return Math.abs(((AVLNode<E>)node).balanceFactory()) <= 1;
    }

    /**
     * AVL树自己维护的Node
     * @param <E>
     */
    private static class AVLNode<E> extends BST.Node<E> {

        int height = 1; // 每个新添加的叶子节点的高度都是1

        public AVLNode(E element, Node<E> parent) {
            super(element, parent);
        }

        /**
         * 获取平衡因子
         * @return
         */
        public int balanceFactory() {
            int leftHight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHight = right == null ? 0 : ((AVLNode<E>)right).height;
            return leftHight - rightHight;
        }
        /**
         * 维护自己的高度
         */
        public void updateHeight() {
            int l = 0;
            int r = 0;
            if (left != null) {
                l = ((AVLNode<E>)left).height;
            }
            if (right != null) {
                r = ((AVLNode<E>)right).height;
            }
            height = 1 + Math.max(l, r);
        }

        /**
         * 获得子结点中高度最高的结点
         * @return
         */
        public Node<E> tallerChild() {
            int leftHight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHight = right == null ? 0 : ((AVLNode<E>)right).height;
            if (leftHight > rightHight) return left;
            if (leftHight < rightHight) return right;
            return isLeft() ? left : right;
        }
    }
}
