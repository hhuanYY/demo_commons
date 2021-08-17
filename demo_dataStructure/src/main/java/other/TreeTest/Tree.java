package other.TreeTest;

public class Tree<E extends Comparable> {
    private Node root;
    class Node{
        E data;
        Node left;
        Node right;
        Node(E e){
            data = e;
        }

        public boolean append(E e) {
            Node node = new Node(e);
            if (data.compareTo(e) == 0){
                return false;
            }
            if (data.compareTo(e) > 0){ //根节点大于的节点，添加到左子树
                if (left == null){
                    left = node;
                    return  true;
                }else{
                    return left.append(e);
                }
            }else {
                if (right == null){
                    right = node;
                    return  true;
                }else {
                    return right.append(e);
                }
            }
        }
    }

    //1. boolean add(E e)
    public boolean add(E e){
        Node node = new Node(e);
        if (root == null){
            root = node;
            return  true;
        }

        return root.append(e);
    }
}
