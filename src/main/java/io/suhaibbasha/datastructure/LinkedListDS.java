package io.suhaibbasha.datastructure;

import io.suhaibbasha.exception.IndexOutOfScopeException;
import io.suhaibbasha.generic.IterableInterface;

public class LinkedListDS<T> implements IterableInterface<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedListDS() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(T entry) {
        Node<T> newNode = new Node<>(entry);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfScopeException("Index out of scope: " + index);
        }

        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfScopeException("Index out of scope: " + index);
        }

        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
        } else if (index == size - 1) {
            tail = tail.previous;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            Node<T> currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }

            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;

            currentNode = null;
        }
        size--;
    }

    @Override
    public void set(int index, T entry) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfScopeException("Index out of scope: " + index);
        }

        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.data = entry;
        add(entry);
        remove(index);
    }

    @Override
    public void insert(int index, T entry) {
        if (index < 0 || index > size) {
            throw new IndexOutOfScopeException("Index out of scope: " + index);
        }

        if (index == 0) {
            add(entry);
            return;
        }
        Node<T> newNode = new Node<>(entry);
        Node<T> currentNode = head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
        }
        newNode.next = currentNode.next;
        if (currentNode.next != null) {
            currentNode.next.previous = newNode;
        }
        newNode.previous = currentNode;
        currentNode.next = newNode;
        size++;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        StringBuilder displayString = new StringBuilder("[");
        Node<T> currentNode = head;
        while (currentNode != null) {
            displayString.append(currentNode.data.toString());
            if (currentNode.next != null) {
                displayString.append(" -> ");
            }
            currentNode = currentNode.next;
        }
        displayString.append("]");
        System.out.println(displayString.toString());
    }

    public void reverse() {
        Node<T> current = head;
        Node<T> next = null;
        Node<T> prev = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            current.previous = next;
            prev = current;
            current = next;
        }

        head = prev;
    }

    @Override
    public boolean contains(T entry) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(entry)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public int indexOf(T entry) {
        Node<T> currentNode = head;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.data.equals(entry)) {
                return index;
            }
            currentNode = currentNode.next;
            index++;
        }
        return -1;
    }

    public LinkedListDS<T> concat(LinkedListDS<T> list) {
        LinkedListDS<T> result = new LinkedListDS<>();
        result.head = this.head;
        result.tail = this.tail;
        result.size = this.size + list.size;

        Node<T> currentNode = this.tail;
        if (currentNode != null) {
            currentNode.next = list.head;
            list.head.previous = currentNode;
        }
        result.tail = list.tail;

        return result;
    }

    @Override
    public String toString() {
        return "LinkedListDS{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    private class Node<E> {
        Node<E> previous;
        Node<E> next;
        E data;

        public Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
    
}
