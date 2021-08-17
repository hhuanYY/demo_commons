package other.LinkedListTest;

public class LinkedList<E> {
    private Node head;
    class Node{
        E data;
        Node next;
        Node prev;
        Node(E e){
            data = e;
        }
    }

    //1. boolean add(E e)
    public boolean add(E e){
        Node node = new Node(e);
        if (head == null){
            head = node;
            head.next = node;
            head.prev = node;
            return true;
        }
        Node last = head.prev;
        last.next = node;
        node.next = head;
        head.prev = node;
        node.prev = last;
        return  true;
    }

    //2.String toString()
    @Override
    public String toString() {
        if (head == null){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        sb.append(head.data);
        Node node = head.next;
        while (node != head){
            sb.append(","+node.data);
            node = node.next;
        }
        return  sb.append("]").toString();

    }

}
