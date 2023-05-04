package com.heydancer.list;

public interface CustomList<T> {
    void add(int index, T e);

    void addFirst(T e);

    void addLast(T e);

    T remove(int index);

    T removeFirst();

    T removeLast();

    void reverse();

    int size();
}
