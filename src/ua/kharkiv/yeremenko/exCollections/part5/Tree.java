package ua.kharkiv.yeremenko.exCollections.part5;

public class Tree<E extends Comparable<E>> {
    private static final String INDENT = "   ";
    private Node<E> root = null;
    private static boolean checkFirst = true;

    public boolean remove(E element) {
        Node<E> parent = root;
        Node<E> current = root;
        boolean isLeftChild = false;
        while(current.key != element){
            parent = current;
            if(current.key.compareTo(element) == 1){
                isLeftChild = true;
                current = current.left;
            }else{
                isLeftChild = false;
                current = current.right;
            }
            if(current == null){
                return false;
            }
        }
        //Case 1: if deleted node has no children
        if(current.left==null && current.right==null){
            if(current==root){
                root = null;
            }
            if(isLeftChild ==true){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }
        //Case 2 : if deleted node has only one child
        else if(current.right==null){
            if(current==root){
                root = current.left;
            }else if(isLeftChild){
                parent.left = current.left;
            }else{
                parent.right = current.left;
            }
        }
        else if(current.left==null){
            if(current==root){
                root = current.right;
            }else if(isLeftChild){
                parent.left = current.right;
            }else{
                parent.right = current.right;
            }
        }else if(current.left!=null && current.right!=null){
            //now we have found the minimum element in the right sub tree
            Node successor	 = getSuccessor(current);
            if(current==root){
                root = successor;
            }else if(isLeftChild){
                parent.left = successor;
            }else{
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public Node getSuccessor(Node<E> deleledNode){
        Node<E> successsor = null;
        Node<E> successsorParent = null;
        Node current = deleledNode.right;
        while(current!=null){
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        //check if successor has the right child, it cannot have left child for sure
        //if it does have the right child, add it to the left of successorParent.
        //successsorParent
        if(successsor!=deleledNode.right){
            successsorParent.left = successsor.right;
            successsor.right = deleledNode.right;
        }
        return successsor;
    }

    public void add(E[] elements) {
        for (int i = 0; i < elements.length; i++) {
            add(elements[i]);
        }
    }

    public boolean add(E key) {
        if (checkFirst) {
            checkFirst = false;
            root = new Node<E>(key);
            return true;
        }
        if (root == null) {
            root = new Node(key);
            return true;
        }
        Node<E> node = root;
        while (true) {
            if(node.key == null) return true;
            if (key.compareTo(node.key) == -1) {
                if (node.left == null) {
                    node.left = new Node<E>(key);
                    return true;
                } else {
                    node = node.left;
                }
            } else if (key.compareTo(node.key) == 1) {
                if (node.right == null) {
                    node.right = new Node<E>(key);
                    return true;
                } else {
                    node = node.right;
                }
            } else {
                return false;
            }
        }
    }

    public void display(int deep, Node<E> x){
        if(x!=null){
            display(deep + 1, x.left);
            for ( int i = 0; i < deep; i ++){
                System.out.print(INDENT);
            }
            System.out.println(x.key);
            display(deep + 1, x.right);
        }
    }

    public void print() {
        Node<E> x = root;
        display(0, x);
    }

    /*public void display(Node<E> x){
        if(x!=null){
            System.out.print(INDENT);
            display(x.left);
            if (x.key!=root.key) System.out.println(x.key);
            else System.out.println("\b\b\b" + x.key);
            if (x.key!=root.key) System.out.print(INDENT+INDENT);
            else System.out.print(INDENT);
            display(x.right);
        }
        if (x==null) System.out.print("\b\b\b");
    }

    public void print() {
        Node<E> x = root;
        display(x);
        System.out.print("\b\b\b");
    }*/

    private static class Node<E extends Comparable> {
        public E key;
        Node<E> left, right;
        Node(E key) {
            this.key = key;
        }
    }
}
