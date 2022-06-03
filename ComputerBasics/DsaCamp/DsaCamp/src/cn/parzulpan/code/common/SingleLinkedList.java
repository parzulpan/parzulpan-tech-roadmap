package cn.parzulpan.code.common;

import java.util.Iterator;

/**
 * 单向链表的算法实现
 *
 * @author parzulpan
 * @since 2022/5/4
 */
public class SingleLinkedList<T> implements Iterable<T> {
    /**
     * 头结点
     */
    private SingleLinkedListNode<T> head;
    /**
     * 结点个数
     */
    private int size;

    public SingleLinkedList() {
        this.head = new SingleLinkedListNode<T>(null, null);
        size = 0;
    }

    /**
     * 任意位置插入
     */
    public void add(int index, T value) {
        indexOutOfBoundsException(index);

        SingleLinkedListNode<T> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.getNext();
        }

        SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>(cur.getNext(), value);
        cur.setNext(newNode);
        size++;
    }

    /**
     * 头插法
     */
    public void addFirst(T value) {
        add(0, value);
    }

    /**
     * 尾插法
     */
    public void addLast(T value) {
        add(size, value);
    }

    /**
     * 任意位置查询
     */
    public T get(int index) {
        indexOutOfBoundsException(index);

        SingleLinkedListNode<T> cur = head.getNext();
        for (int i = 0; i < index; i++) {
            cur = cur.getNext();
        }

        return cur.getValue();
    }

    /**
     * 查询第一个
     */
    public T getFirst() {
        return get(0);
    }

    /**
     * 查询最后一个
     */
    public T getLast() {
        return get(size - 1);
    }
    /**
     *
     */
    public void clear() {
        this.head = new SingleLinkedListNode<T>(null, null);
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
    public void set(int index, T value) {
        indexOutOfBoundsException(index);

        SingleLinkedListNode<T> cur = head.getNext();
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
    public T remove(int index) {
        indexOutOfBoundsException(index);

        SingleLinkedListNode<T> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.getNext();
        }

        SingleLinkedListNode<T> retNode = cur.getNext();
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
            SingleLinkedListNode<T> cur = head;

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
