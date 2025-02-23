package io.suhaibbasha.datastructure;

import java.util.Arrays;

import io.suhaibbasha.exception.IndexOutOfScopeException;
import io.suhaibbasha.generic.ConstructableInterface;

public class QueueDS<T> implements ConstructableInterface<T> {

    private T[] data;
    private int front;
    private int rear;
    private int size;

    @SuppressWarnings("unchecked")
    public QueueDS() {
        data = (T[]) new Object[0];
        front = -1;
        rear = -1;
        size = 0;
    }

    @Override
    public void push(T value) {
        if (isEmpty()) {
            front = 0;
            rear = 0;
        }
        createMoreRoom();
        data[rear++] = value;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IndexOutOfScopeException("Queue is empty..");
        }
        T value = data[front];
        if (front == rear - 1) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }
        size--;
        return value;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            throw new IndexOutOfScopeException("Queue is empty..");
        }
        return data[front];
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        data = (T[]) new Object[0];
        front = -1;
        rear = -1;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    @Override
    public void display() {
        StringBuilder displayString = new StringBuilder("[");
        for (int i = front; i < rear; i++) {
            displayString.append(data[i].toString());
            if (i < rear - 1) {
                displayString.append(", ");
            }
        }
        displayString.append("]");
        System.out.println(displayString);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T value) {
        for (int i = front; i < rear; i++) {
            if (data[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "QueueDS{" +
                "data=" + Arrays.toString(data) +
                ", front=" + data[front] +
                ", rear=" + data[rear] +
                ", size=" + size +
                "}";
    }

    private void createMoreRoom() {
        T[] newData = Arrays.copyOf(data, data.length + 1);
        data = newData;
    }

}
