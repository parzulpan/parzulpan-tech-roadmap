package cn.parzulpan.code.test;

import cn.parzulpan.code.common.SingleLinkedList;

/**
 * @author parzulpan
 * @since 2022/5/4
 */
public class TestSingleLinkedList {
    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();

//        // 头插法
//        list.addFirst(1);
//        list.addFirst(2);
//        list.addFirst(3);
//        list.addFirst(4);
//        list.addFirst(5);
//        list.addFirst(6);
//        list.addFirst(7);

        // 尾插法
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        System.out.println(list.length());
        System.out.println();
        for (Integer i : list) {
            System.out.println(i + " ");
        }
        System.out.println();

        System.out.println(list.remove(3));
        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());
        System.out.println();
        for (Integer i : list) {
            System.out.println(i + " ");
        }
        System.out.println();

        System.out.println(list.get(3));
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println();

        list.set(3, 33);
        list.setFirst(11);
        list.setLast(77);
        for (Integer i : list) {
            System.out.println(i + " ");
        }
        System.out.println();

        System.out.println(list.length());
        System.out.println();

        list.clear();

        System.out.println(list.length());
        System.out.println();
    }
}
