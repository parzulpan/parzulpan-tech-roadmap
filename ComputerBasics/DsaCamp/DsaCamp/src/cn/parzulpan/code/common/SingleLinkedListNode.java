package cn.parzulpan.code.common;


/**
 * 单向链表结点的数据结构
 *
 * @author parzulpan
 * @since 2022/5/4
 */
public class SingleLinkedListNode<T> {
    private SingleLinkedListNode<T> next;
    private T value;

    public SingleLinkedListNode(SingleLinkedListNode<T> next, T value) {
        this.next = next;
        this.value = value;
    }

    public void setNext(SingleLinkedListNode<T> next) {
        this.next = next;
    }

    public SingleLinkedListNode<T> getNext() {
        return next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
