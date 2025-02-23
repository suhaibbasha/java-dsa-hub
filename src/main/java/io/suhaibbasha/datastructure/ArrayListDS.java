package io.suhaibbasha.datastructure;

import java.util.Arrays;

import io.suhaibbasha.exception.IndexOutOfScopeException;
import io.suhaibbasha.generic.IterableInterface;

public class ArrayListDS<T> implements IterableInterface<T>{

    private T[] data;
    private int pointer;

    @SuppressWarnings("unchecked")
    public ArrayListDS() {
        data = (T[]) new Object[0];
        pointer = 0;
    }

    @Override
    public void add(T entry) {
        createMoreRoom();
        data[pointer++] = entry;
    }

    @Override
    public T get(int index) {
        if (index >= pointer) {
            throw new IndexOutOfScopeException("Index " + index + " is out of range..");
        }
        return data[index];
    }

    @Override
    public void remove(int index) {
        if (index >= pointer) {
            throw new IndexOutOfScopeException("Index " + index + " is out of range..");
        }
        System.arraycopy(data, index + 1, data, index, pointer - index - 1);
        pointer--;
    }

    @Override
    public void set(int index, T entry) {
        if (index >= pointer) {
            throw new IndexOutOfScopeException("Index " + index + " is out of range..");
        }
        createMoreRoom();
        data[index] = entry;
    }

    @Override
    public void insert(int index, T entry) {
        if (index > pointer) {
            throw new IndexOutOfScopeException("Index " + index + " is out of range..");
        }
        createMoreRoom();
        System.arraycopy(data, index, data, index + 1, pointer - index);
        data[index] = entry;
        pointer++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        data = (T[]) new Object[0];
        pointer = 0;
    }

    @Override
    public boolean isEmpty() {
        return pointer == 0;
    }

    @Override
    public int size() {
        return pointer;
    }

    @Override
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

    @Override
    public boolean contains(T entry) {
        for (int i = 0; i < pointer; i++) {
            if (data[i].equals(entry)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T entry) {
        for (int i = 0; i < pointer; i++) {
            if (data[i].equals(entry)) {
                return i;
            }
        }
        return -1;
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
