package com.heydancer;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements CustomList<T> {
    private Node<T> head;
    private Node<T> tail;

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
            current.next.prev = temp;
            current.next = temp;
            temp.prev = current;
        }
    }

    @Override
    public void addFirst(T e) {
        Node<T> temp = new Node<>(e);

        if (head == null) {
            tail = temp;
        } else {
            head.prev = temp;
        }

        temp.next = head;
        head = temp;
    }

    @Override
    public void addLast(T e) {
        Node<T> temp = new Node<>(e);

        if (head == null) {
            head = temp;
        } else {
            tail.next = temp;
        }

        temp.prev = tail;
        tail = temp;
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
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;

            return current.value;
        }
    }

    @Override
    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        Node<T> temp = head;
        head = head.next;

        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }

        return temp.value;
    }

    @Override
    public T removeLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }

        Node<T> temp = tail;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }

        return temp.value;
    }

    @Override
    public void reverse() {
        if (head == null) {
            return;
        }

        Node<T> temp = null;
        Node<T> current = head;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
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
        private Node<T> prev;

        public Node(T value) {
            this.value = value;
        }
    }
}