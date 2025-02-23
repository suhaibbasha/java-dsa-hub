package io.suhaibbasha.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinaryTreeDSTest {

    @Test
    public void init_createBinaryTree_returnsABinaryTree() {
        BinaryTreeDS<Integer> binaryTreeDS = new BinaryTreeDS<>(1);
        assert binaryTreeDS instanceof BinaryTreeDS;
    }

    @Test
    public void insertLeftChild_addLeftChildToTree_increaseLeftChildCount() {
        BinaryTreeDS<Integer> binaryTreeDS = new BinaryTreeDS<>(1);
        binaryTreeDS.insertLeftChild(2);
        binaryTreeDS.getLeftChild().insertLeftChild(3);
        assertEquals(binaryTreeDS.getLeftChild().getData(), 2);
        assertEquals(binaryTreeDS.getLeftChild().getLeftChild().getData(), 3);
        assertEquals(binaryTreeDS.getLeftChild().getDegree(), 1);
        assertEquals(binaryTreeDS.getLeftChild().getLeftChild().getDegree(), 0);
        binaryTreeDS.display();
    }

    @Test
    public void insertRightChild_addRightChildToTree_increaseRightChildCount() {
        BinaryTreeDS<Integer> binaryTreeDS = new BinaryTreeDS<>(1);
        binaryTreeDS.insertRightChild(2);
        binaryTreeDS.getRightChild().insertLeftChild(3);
        assertEquals(binaryTreeDS.getRightChild().getData(), 2);
        assertEquals(binaryTreeDS.getRightChild().getLeftChild().getData(), 3);
        assertEquals(binaryTreeDS.getRightChild().getDegree(), 1);
        binaryTreeDS.display();
    }

    @Test
    public void getHeight_createTreeWithMultipleLevels_returnsHeight() {
        BinaryTreeDS<Integer> binaryTreeDS = new BinaryTreeDS<>(1);
        binaryTreeDS.insertLeftChild(2);
        binaryTreeDS.getLeftChild().insertLeftChild(3);
        binaryTreeDS.getLeftChild().insertRightChild(4);
        binaryTreeDS.insertRightChild(5);
        assertEquals(binaryTreeDS.getHeight(), 3);
        binaryTreeDS.display();
    }

    @Test
    public void isLeaf_createTreeWithSingleNode_returnsTrue() {
        BinaryTreeDS<Integer> binaryTreeDS = new BinaryTreeDS<>(1);
        assertEquals(binaryTreeDS.isLeaf(), true);
        binaryTreeDS.display();
    }
    
}
