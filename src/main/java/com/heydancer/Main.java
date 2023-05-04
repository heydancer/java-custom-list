package com.heydancer;

import com.heydancer.list.CustomList;
import com.heydancer.list.impl.DoublyLinkedList;
import com.heydancer.list.impl.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        CustomList<String> singlyList = new SinglyLinkedList<>();
        CustomList<String> doublyList = new DoublyLinkedList<>();

        System.out.println("SinglyList \n");

        singlyList.addLast("B");
        singlyList.addLast("C");
        singlyList.addLast("D");

        System.out.println(singlyList);
        System.out.println("-------------");

        singlyList.addFirst("A");

        System.out.println(singlyList);
        System.out.println("-------------");

        singlyList.removeLast();

        System.out.println(singlyList);
        System.out.println("-------------");

        singlyList.removeFirst();

        System.out.println(singlyList);
        System.out.println("-------------");

        singlyList.add(1, "F");

        System.out.println(singlyList);
        System.out.println("-------------");

        singlyList.remove(1);

        System.out.println(singlyList + "\n");

        System.out.println("DoublyList \n");

        doublyList.addLast("B");
        doublyList.addLast("C");
        doublyList.addLast("D");

        System.out.println(doublyList);
        System.out.println("-------------");

        doublyList.addFirst("A");

        System.out.println(doublyList);
        System.out.println("-------------");

        doublyList.removeLast();

        System.out.println(doublyList);
        System.out.println("-------------");

        doublyList.removeFirst();

        System.out.println(doublyList);
        System.out.println("-------------");

        doublyList.add(1, "F");

        System.out.println(doublyList);
        System.out.println("-------------");

        doublyList.remove(1);

        System.out.println(doublyList);


    }
}