package cn.parzulpan.code.common;

/**
 * 双向链表结点的数据结构
 *
 * @author parzulpan
 * @since 2022/5/6
 */
public class DoubleLinkedListNode<T> {
    private DoubleLinkedListNode<T> prev;
    private DoubleLinkedListNode<T> next;
    private T value;

    public DoubleLinkedListNode(DoubleLinkedListNode<T> prev, DoubleLinkedListNode<T> next, T value) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }

    public DoubleLinkedListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoubleLinkedListNode<T> prev) {
        this.prev = prev;
    }

    public DoubleLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleLinkedListNode<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
