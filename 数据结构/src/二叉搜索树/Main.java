package 二叉搜索树;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Person> binarySearchTree1 = new BinarySearchTree<>();
        binarySearchTree1.add(new Person("张三", 18));
        binarySearchTree1.add(new Person("李四", 19));
        binarySearchTree1.add(new Person("王五", 18));
        BinarySearchTree<Person> binarySearchTree2 = new BinarySearchTree<>((e1, e2) -> e2.getAge() - e2.getAge());
        binarySearchTree2.add(new Person("张三", 18));
        binarySearchTree2.add(new Person("李四", 19));
        binarySearchTree2.add(new Person("王五", 18));
    }
}
