package io.suhaibbasha.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class ArrayListDSTest {

    @Test
    public void init_createArrayList_returnsAnArrayList() {
        ArrayListDS<Integer> arrayListDS = new ArrayListDS<>();
        assert arrayListDS instanceof ArrayListDS;
    }

    @Test
    public void add_addElement_increaseSize() {
        ArrayListDS<String> arrayListDS = new ArrayListDS<>();
        arrayListDS.add("Hello");
        arrayListDS.add("World");
        assertEquals(arrayListDS.size(), 2);
        arrayListDS.display();
    }

    @Test
    public void get_getElementByIndex_returnsCorrectElement() {
        ArrayListDS<Float> arrayListDS = new ArrayListDS<>();
        arrayListDS.add(1.5f);
        arrayListDS.add(2.3f);
        arrayListDS.add(3.7f);
        assertEquals(arrayListDS.get(1), 2.3f);
        arrayListDS.display();
    }

    @Test
    public void remove_removeElementByIndex_decreaseSize() {
        ArrayListDS<String> arrayListDS = new ArrayListDS<>();
        arrayListDS.add("Hello");
        arrayListDS.add("World");
        arrayListDS.remove(0);
        assertEquals(arrayListDS.size(), 1);
        assertEquals(arrayListDS.get(0), "World");
        arrayListDS.display();
    }

    @Test
    public void set_changeElementByIndex_updatesElement() {
        ArrayListDS<Integer> arrayListDS = new ArrayListDS<>();
        arrayListDS.add(1);
        arrayListDS.add(2);
        arrayListDS.set(1, 3);
        assertEquals(arrayListDS.get(1), 3);
        arrayListDS.display();
    }

    @Test
    public void insert_insertElementByIndex_updatesSizeAndContent() {
        ArrayListDS<String> arrayListDS = new ArrayListDS<>();
        arrayListDS.add("Hello");
        arrayListDS.add("World");
        arrayListDS.insert(1, "Middle");
        assertEquals(arrayListDS.size(), 3);
        assertEquals(arrayListDS.get(1), "Middle");
        arrayListDS.display();
    }

    @Test
    public void clear_emptyArrayList_returnsSizeZero() {
        ArrayListDS<String> arrayListDS = new ArrayListDS<>();
        arrayListDS.add("Hello");
        arrayListDS.add("World");
        arrayListDS.clear();
        assertEquals(arrayListDS.size(), 0);
        arrayListDS.display();
    }

    @Test
    public void isEmpty_nonEmptyArrayList_returnsFalse() {
        ArrayListDS<Boolean> arrayListDS = new ArrayListDS<>();
        arrayListDS.add(true);
        arrayListDS.add(false);
        assertFalse(arrayListDS.isEmpty());
    }

    @Test
    public void concat_concatTwoArrayListDS_returnsConcatinatedArrayList() {
        ArrayListDS<Integer> arrayListDS1 = new ArrayListDS<>();
        arrayListDS1.add(1);
        arrayListDS1.add(2);

        ArrayListDS<Integer> arrayListDS2 = new ArrayListDS<>();
        arrayListDS2.add(3);
        arrayListDS2.add(4);

        ArrayListDS<Integer> concatenatedArrayListDS = arrayListDS1.concat(arrayListDS2);
        assertEquals(concatenatedArrayListDS.size(), 4);
        concatenatedArrayListDS.display();
    }

    @Test
    public void join_joinElementsByDelimeter_returnAStringOfJointElements() {
        ArrayListDS<String> arrayListDS = new ArrayListDS<>();
        arrayListDS.add("Hello");
        arrayListDS.add("World");
        String joinedString = arrayListDS.join(", ");
        System.out.println(joinedString);
        assertEquals(joinedString, "Hello, World");
        arrayListDS.display();
    }

}
