package io.suhaibbasha.datastructure;

import java.util.Arrays;

import io.suhaibbasha.exception.datastructure.IndexOutOfScopeException;

public class ArrayListDS<T> {

    private T[] data;
    private int pointer;

    public ArrayListDS() {
        data = (T[]) new Object[0];
        pointer = 0;
    }

    public void add(T entry) {
        createMoreRoom();
        data[pointer++] = entry;
    }

    public T get(int index) {
        if (index >= pointer) {
            throw new IndexOutOfScopeException("Index " + index + " is out of range..");
        }
        return data[index];
    }

    public void remove(int index) {
        if (index >= pointer) {
            throw new IndexOutOfScopeException("Index " + index + " is out of range..");
        }
        System.arraycopy(data, index + 1, data, index, pointer - index - 1);
        pointer--;
    }

    public void set(int index, T entry) {
        if (index >= pointer) {
            throw new IndexOutOfScopeException("Index " + index + " is out of range..");
        }
        createMoreRoom();
        data[index] = entry;
    }

    public void insert(int index, T entry) {
        if (index > pointer) {
            throw new IndexOutOfScopeException("Index " + index + " is out of range..");
        }
        createMoreRoom();
        System.arraycopy(data, index, data, index + 1, pointer - index);
        data[index] = entry;
        pointer++;
    }

    public void clear() {
        data = (T[]) new Object[0];
        pointer = 0;
    }

    public boolean isEmpty() {
        return pointer == 0;
    }

    public int size() {
        return pointer;
    }

    public void display() {
        StringBuilder displayString = new StringBuilder("[");
        for (int i = 0; i < pointer; i++) {
            displayString.append(data[i].toString());
            if (i < pointer - 1) {
                displayString.append(", ");
            }
        }
        displayString.append("]");
        System.out.println(displayString);
    }

    public String join(String delimiter) {
        StringBuilder displayString = new StringBuilder();
        for (int i = 0; i < pointer; i++) {
            displayString.append(data[i].toString());
            if (i < pointer - 1) {
                displayString.append(delimiter);
            }
        }
        return displayString.toString();
    }

    public ArrayListDS<T> concat(ArrayListDS<T> list) {
        ArrayListDS<T> newList = new ArrayListDS<>();
        newList.data = Arrays.copyOf(this.data, this.pointer + list.pointer);
        System.arraycopy(this.data, 0, newList.data, 0, this.pointer);
        System.arraycopy(list.data, 0, newList.data, this.pointer, list.pointer);
        newList.pointer = this.pointer + list.pointer;
        this.data = newList.data;
        this.pointer = newList.pointer;
        return newList;
    }

    @Override
    public String toString() {
        return "ArrayListDS{" +
                "data=" + Arrays.toString(data) +
                ", size=" + pointer +
                '}';
    }

    private void createMoreRoom() {
        T[] newData = Arrays.copyOf(data, data.length + 1);
        data = newData;
    }
}
