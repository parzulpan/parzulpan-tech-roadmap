package cn.parzulpan.code.common;


/**
 * 链表结点的数据结构
 *
 * @author parzulpan
 * @since 2022/5/4
 */
public class LinkedListNode<T> {
    private LinkedListNode<T> next;
    private T value;

    public LinkedListNode(LinkedListNode<T> next, T value) {
        this.next = next;
        this.value = value;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

    public LinkedListNode<T> getNext() {
        return this.next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }
}
