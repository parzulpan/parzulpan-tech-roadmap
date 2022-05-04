package cn.parzulpan.code.common;

import java.util.Iterator;

/**
 * 单链表的实现
 *
 * @author parzulpan
 * @since 2022/5/4
 */
public class SingleLinkedList<T> implements Iterable<T> {
    /**
     * 头结点
     */
    private LinkedListNode<T> head;
    /**
     * 结点个数
     */
    private int size;

    public SingleLinkedList() {
        this.head = new LinkedListNode<T>(null, null);
        size = 0;
    }

    /**
     *
     */
    public void clear() {
        this.head = new LinkedListNode<T>(null, null);
        size = 0;
    }

    /**
     *
     */
    public int length() {
        return this.size;
    }

    /**
     *
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     *
     */
    public T get(int index) {
        indexOutOfBoundsException(index);

        LinkedListNode<T> cur = head.getNext();
        for (int i = 0; i < index; i++) {
            cur = cur.getNext();
        }

        return cur.getValue();
    }

    /**
     *
     */
    public T getFirst() {
        return get(0);
    }

    /**
     *
     */
    public T getLast() {
        return get(size - 1);
    }

    /**
     *
     */
    public void set(int index, T value) {
        indexOutOfBoundsException(index);

        LinkedListNode<T> cur = head.getNext();
        for (int i = 0; i < index; i++) {
            cur = cur.getNext();
        }

        cur.setValue(value);
    }

    /**
     *
     */
    public void setFirst(T value) {
        set(0, value);
    }

    /**
     *
     */
    public void setLast(T value) {
        set(size - 1, value);
    }

    /**
     *
     */
    public void add(int index, T value) {
        indexOutOfBoundsException(index);

        LinkedListNode<T> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.getNext();
        }

        LinkedListNode<T> newNode = new LinkedListNode<>(cur.getNext(), value);
        cur.setNext(newNode);
        size++;
    }

    /**
     *
     */
    public void addFirst(T value) {
        add(0, value);
    }

    /**
     *
     */
    public void addLast(T value) {
        add(size, value);
    }

    /**
     *
     */
    public T remove(int index) {
        indexOutOfBoundsException(index);

        LinkedListNode<T> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.getNext();
        }

        LinkedListNode<T> retNode = cur.getNext();
        cur.setNext(retNode.getNext());
        retNode.setNext(null);
        size--;

        return retNode.getValue();
    }

    /**
     *
     */
    public T removeFirst() {
        return remove(0);
    }

    /**
     *
     */
    public T removeLast() {
        return remove(size - 1);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            LinkedListNode<T> cur = head;

            @Override
            public boolean hasNext() {
                return cur.getNext() != null;
            }

            @Override
            public T next() {
                cur = cur.getNext();
                return cur.getValue();
            }
        };
    }

    /**
     * indexOutOfBoundsException
     */
    private void indexOutOfBoundsException(int index) {
        if (index < 0 || index > this.size) {
            throw new RuntimeException("index out of bounds");
        }
    }
}
