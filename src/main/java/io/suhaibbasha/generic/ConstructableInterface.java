package io.suhaibbasha.generic;

public interface ConstructableInterface<T> {

    T top();

    void push(T value);

    T pop();

    void clear();

    boolean isEmpty();

    void display();

    int size();

    boolean contains(T value);
}
