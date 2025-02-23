package io.suhaibbasha.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class LinkedListDSTest {

    @Test
    public void init_createLinkedList_returnsAnLinkedList() {
        LinkedListDS<Integer> linkedListDS = new LinkedListDS<>();
        assert linkedListDS instanceof LinkedListDS;
    }

    @Test
    public void add_addElement_increaseSize() {
        LinkedListDS<String> linkedListDS = new LinkedListDS<>();
        linkedListDS.add("Hello");
        linkedListDS.add("World");
        assertEquals(linkedListDS.size(), 2);
        linkedListDS.display();
    }

    @Test
    public void get_getElementByIndex_returnsCorrectElement() {
        LinkedListDS<Float> linkedListDS = new LinkedListDS<>();
        linkedListDS.add(1.5f);
        linkedListDS.add(2.3f);
        linkedListDS.add(3.7f);
        assertEquals(linkedListDS.get(1), 2.3f);
        linkedListDS.display();
    }

    @Test
    public void remove_removeElementByIndex_decreaseSize() {
        LinkedListDS<String> linkedListDS = new LinkedListDS<>();
        linkedListDS.add("Hello");
        linkedListDS.add("World");
        linkedListDS.remove(0);
        assertEquals(linkedListDS.size(), 1);
        assertEquals(linkedListDS.get(0), "World");
        linkedListDS.display();
    }

    @Test
    public void set_changeElementByIndex_updatesElement() {
        LinkedListDS<Integer> linkedListDS = new LinkedListDS<>();
        linkedListDS.add(1);
        linkedListDS.add(2);
        linkedListDS.set(1, 3);
        assertEquals(linkedListDS.get(1), 3);
        linkedListDS.display();
    }

    @Test
    public void insert_insertElementByIndex_updatesSizeAndContent() {
        LinkedListDS<String> linkedListDS = new LinkedListDS<>();
        linkedListDS.add("Hello");
        linkedListDS.add("World");
        linkedListDS.insert(1, "Middle");
        assertEquals(linkedListDS.size(), 3);
        assertEquals(linkedListDS.get(1), "Middle");
        linkedListDS.display();
    }

    @Test
    public void clear_emptyLinkedList_returnsSizeZero() {
        LinkedListDS<String> linkedListDS = new LinkedListDS<>();
        linkedListDS.add("Hello");
        linkedListDS.add("World");
        linkedListDS.clear();
        assertEquals(linkedListDS.size(), 0);
        linkedListDS.display();
    }

    @Test
    public void isEmpty_nonEmptyLinkedList_returnsFalse() {
        LinkedListDS<String> linkedListDS = new LinkedListDS<>();
        linkedListDS.add("Hello");
        linkedListDS.add("World");
        assertFalse(linkedListDS.isEmpty());
        linkedListDS.display();
    }

    @Test
    public void reverse_reversesOrderOfElements() {
        LinkedListDS<Integer> linkedListDS = new LinkedListDS<>();
        linkedListDS.add(1);
        linkedListDS.add(2);
        linkedListDS.add(3);
        linkedListDS.reverse();
        assertEquals(linkedListDS.get(0), 3);
        assertEquals(linkedListDS.get(1), 2);
        assertEquals(linkedListDS.get(2), 1);
        linkedListDS.display();
    }

    @Test
    public void indexOf_findElement_returnsIndex() {
        LinkedListDS<String> linkedListDS = new LinkedListDS<>();
        linkedListDS.add("Hello");
        linkedListDS.add("World");
        linkedListDS.add("Java");
        assertEquals(linkedListDS.indexOf("World"), 1);
        linkedListDS.display();
    }

    @Test
    public void concat_concatTwoLinkedListDS_returnsConcatinatedLinkedList() {
        LinkedListDS<Integer> linkedListDS1 = new LinkedListDS<>();
        linkedListDS1.add(1);
        linkedListDS1.add(2);

        LinkedListDS<Integer> linkedListDS2 = new LinkedListDS<>();
        linkedListDS2.add(3);
        linkedListDS2.add(4);

        LinkedListDS<Integer> concatenatedLinkedListDS = linkedListDS1.concat(linkedListDS2);
        assertEquals(concatenatedLinkedListDS.size(), 4);
        concatenatedLinkedListDS.display();
    }
    
}
