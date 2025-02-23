package io.suhaibbasha.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TreeDSTest {
    
    @Test
    public void init_createTree_returnsATree() {
        TreeDS<Integer> treeDS = new TreeDS<>(0);
        assert treeDS instanceof TreeDS;
    }

    @Test
    public void addChild_addNodeToTree_increaseChildrenCount() {
        TreeDS<Integer> treeDS = new TreeDS<>(0);
        treeDS.addChild(1);
        treeDS.addChild(2);

        treeDS.getChild(0).addChild(3);
        treeDS.getChild(0).addChild(5);
        treeDS.getChild(0).addChild(7);

        treeDS.getChild(1).addChild(4);
        treeDS.getChild(1).addChild(6);
        treeDS.getChild(1).addChild(8);

        treeDS.getChild(1).getChild(0).addChild(16);
        treeDS.getChild(1).getChild(0).addChild(32);

        assertEquals(treeDS.getChildrenCount(), 2);
        assertEquals(treeDS.getChild(0).getChildrenCount(), 3);

        treeDS.display();
    }

    @Test
    public void getChild_retrieveChildByIndex_returnsNode() {
        TreeDS<Integer> treeDS = new TreeDS<>(0);
        treeDS.addChild(1);
        treeDS.addChild(2);
        TreeDS<Integer> retrievedChild = treeDS.getChild(1);
        assertEquals(retrievedChild.getData(), 2);
        retrievedChild = treeDS.getChild(0);
        assertEquals(retrievedChild.getData(), 1);
        treeDS.display();
    }

    @Test
    public void isRoot_checkIfNodeIsRoot_returnsTrue() {
        TreeDS<Integer> treeDS = new TreeDS<>(0);
        treeDS.addChild(1);
        assertEquals(treeDS.isRoot(), true);
        treeDS.getChild(0).addChild(2);
        assertEquals(treeDS.getChild(0).isRoot(), false);
        treeDS.display();
    }
}
