package 每日一练;

/**
 * @ClassName LinkedListDemo
 * @Description TODO
 * @Author yyhuan
 * @Date 2023/4/1 12:44
 * @Version 1.0
 */
public class LinkedListDemo<E> {

    private Node head;

    class Node{
        E data;
        Node next;
        Node prev;
        Node(E e){
            data = e;
        }
    }

    boolean add(E e) {
        Node node = new Node(e);
        // 如果没有任何元素，则把该元素设置为头结点
        if (head == null) {
            head = node;
            head.next = node;
            head.prev = node;
            return true;
        }
        // 链表不为空，则顺序添加到尾结点；头结点的前驱节点就是最后一个节点
        Node last = head.prev;
        last.next = node;
        node.prev = last;
        node.next = head;
        head.prev = node;
        return true;

    }

}
