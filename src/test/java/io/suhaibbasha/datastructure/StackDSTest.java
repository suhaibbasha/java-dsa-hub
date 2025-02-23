package io.suhaibbasha.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StackDSTest {

    @Test
    public void init_createStack_returnsAStack() {
        StackDS<Integer> stackDS = new StackDS<>();
        assertEquals(stackDS.getClass(), StackDS.class);
    }

    @Test
    public void push_addElement_increaseSize() {
        StackDS<String> stackDS = new StackDS<>();
        stackDS.push("Stack");
        stackDS.push("Test");
        assertEquals(stackDS.size(), 2);
        assertEquals(stackDS.top(), "Test");
        stackDS.display();
    }

    @Test
    public void pop_removeElement_decreaseSize() {
        StackDS<String> stackDS = new StackDS<>();
        stackDS.push("Stack");
        stackDS.push("Test");
        stackDS.pop();
        assertEquals(stackDS.size(), 1);
        assertEquals(stackDS.top(), "Stack");
        stackDS.display();
    }

    @Test
    public void top_returnTopElement() {
        StackDS<Integer> stackDS = new StackDS<>();
        stackDS.push(1);
        stackDS.push(2);
        stackDS.push(3);
        assertEquals(stackDS.top(), 3);
        stackDS.display();
    }

    @Test
    public void isEmpty_checkIfStackIsEmpty() {
        StackDS<String> stackDS = new StackDS<>();
        assertTrue(stackDS.isEmpty());
        stackDS.push("Hello");
        assertFalse(stackDS.isEmpty());
        stackDS.display();
    }

}
