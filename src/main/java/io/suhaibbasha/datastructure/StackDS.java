package io.suhaibbasha.datastructure;

import java.util.Arrays;

import io.suhaibbasha.exception.IndexOutOfScopeException;
import io.suhaibbasha.generic.ConstructableInterface;

public class StackDS<T> implements ConstructableInterface<T> {

    private T[] data;
    private int head;
    private int size;

    @SuppressWarnings("unchecked")
    public StackDS() {
        data = (T[]) new Object[0];
        head = -1;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            throw new IndexOutOfScopeException("Stack is empty..");
        }
        return data[head];
    }

    @Override
    public void push(T value) {
        createMoreRoom();
        data[++head] = value;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IndexOutOfScopeException("Stack is empty..");
        }
        T value = data[head];
        data[head--] = null;
        size--;
        return value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        data = (T[]) new Object[0];
        head = -1;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == -1;
    }

    @Override
    public void display() {
        StringBuilder displayString = new StringBuilder("[");
        for (int i = head; i >= 0; i--) {
            displayString.append(data[i].toString());
            if (i > 0) {
                displayString.append(", ");
            }
        }
        displayString.append("]");
        System.out.println(displayString.toString());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i <= head; i++) {
            if (data[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "StackDS{" +
                "data=" + Arrays.toString(data) +
                ", head=" + data[head] +
                ", size=" + size +
                "}";
    }

    private void createMoreRoom() {
        T[] newData = Arrays.copyOf(data, data.length + 1);
        data = newData;
    }

}
