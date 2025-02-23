package io.suhaibbasha.generic;

public interface IterableInterface<T> {

    void add(T value);

    T get(int index);

    void remove(int index);

    void set(int index, T value);

    void insert(int index, T value);

    void clear();

    boolean isEmpty();

    int size();

    void display();

    boolean contains(T value);

    int indexOf(T value);

}
