package io.suhaibbasha.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class QueueDSTest {

    @Test
    public void init_createQueue_returnsAQueue() {
        QueueDS<Integer> queueDS = new QueueDS<>();
        assertEquals(queueDS.getClass(), QueueDS.class);
    }

    @Test
    public void push_addElement_increaseSize() {
        QueueDS<String> queueDS = new QueueDS<>();
        queueDS.push("Hello");
        queueDS.push("World");
        assertEquals(queueDS.size(), 2);
        assertEquals(queueDS.top(), "Hello");
        queueDS.display();
    }

    @Test
    public void pop_removeElement_decreaseSize() {
        QueueDS<String> queueDS = new QueueDS<>();
        queueDS.push("Hello");
        queueDS.push("World");
        queueDS.pop();
        assertEquals(queueDS.size(), 1);
        assertEquals(queueDS.top(), "World");
        queueDS.display();
    }

    @Test
    public void top_returnTopElement() {
        QueueDS<String> queueDS = new QueueDS<>();
        queueDS.push("Hello");
        queueDS.push("World");
        assertEquals(queueDS.top(), "Hello");
    }

    @Test
    public void isEmpty_checkIfQueueIsEmpty() {
        QueueDS<String> queueDS = new QueueDS<>();
        assertTrue(queueDS.isEmpty());
        queueDS.push("Hello");
        assertFalse(queueDS.isEmpty());
        queueDS.display();
    }

    @Test
    public void clear_emptyQueue_returnsSizeZero() {
        QueueDS<String> queueDS = new QueueDS<>();
        queueDS.push("Hello");
        queueDS.push("World");
        queueDS.clear();
        assertEquals(queueDS.size(), 0);
        queueDS.display();
    }

}
