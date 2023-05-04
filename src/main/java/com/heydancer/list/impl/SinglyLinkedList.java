package com.heydancer.list.impl;

import com.heydancer.list.CustomList;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements CustomList<T> {
    private Node<T> head;

    @Override
    public void add(int index, T e) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(e);
        } else if (index == size() - 1) {
            addLast(e);
        } else {
            Node<T> temp = new Node<>(e);
            Node<T> current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            temp.next = current.next;
            current.next = temp;
        }
    }

    @Override
    public void addFirst(T e) {
        Node<T> temp = new Node<>(e);
        temp.next = head;
        head = temp;
    }

    @Override
    public void addLast(T e) {
        Node<T> temp = new Node<>(e);

        if (head == null) {
            head = temp;
        } else {
            Node<T> current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = temp;
        }
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return removeFirst();
        } else if (index == size() - 1) {
            return removeLast();
        } else {
            Node<T> current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            Node<T> temp = current.next;
            current.next = current.next.next;

            return temp.value;
        }
    }

    @Override
    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        Node<T> temp = head;
        head = head.next;

        return temp.value;
    }

    @Override
    public T removeLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        if (head.next == null) {
            Node<T> temp = head;
            head = null;
            return temp.value;
        }

        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        Node<T> temp = current.next;
        current.next = null;

        return temp.value;
    }

    @Override
    public void reverse() {
        if (head == null) {
            return;
        }

        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    @Override
    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;

        while (current != null) {
            sb.append(current.value.toString()).append(", ");
            current = current.next;
        }

        if (size() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        sb.append("]");
        return sb.toString();
    }

    private static class Node<T> {
        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
