package io.suhaibbasha.datastructure;

public class BinaryTreeDS<T> {

    private T data;
    private BinaryTreeDS<T> parent;
    private BinaryTreeDS<T> leftChild;
    private BinaryTreeDS<T> rightChild;

    public BinaryTreeDS(T data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = null;
    }

    public void insertLeftChild(T data) {
        BinaryTreeDS<T> newLeftChild = new BinaryTreeDS<>(data);
        newLeftChild.parent = this;
        this.leftChild = newLeftChild;
    }

    public void insertRightChild(T data) {
        BinaryTreeDS<T> newRightChild = new BinaryTreeDS<>(data);
        newRightChild.parent = this;
        this.rightChild = newRightChild;
    }

    public BinaryTreeDS<T> getLeftChild() {
        return leftChild;
    }

    public BinaryTreeDS<T> getRightChild() {
        return rightChild;
    }

    public BinaryTreeDS<T> getParent() {
        return parent;
    }

    public T getData() {
        return data;
    }

    public void display() {
        System.out.print(data + " ");
        if (leftChild != null) {
            leftChild.display();
        }
        if (rightChild != null) {
            rightChild.display();
        }
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    public int getHeight() {
        int leftHeight = (leftChild == null) ? 0 : leftChild.getHeight();
        int rightHeight = (rightChild == null) ? 0 : rightChild.getHeight();
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int getDegree() {
        return (leftChild == null ? 0 : 1) + (rightChild == null ? 0 : 1);
    }

    public int getSize() {
        int leftSize = (leftChild == null) ? 0 : leftChild.getSize();
        int rightSize = (rightChild == null) ? 0 : rightChild.getSize();
        return leftSize + rightSize + 1;
    }

    public boolean isBalanced() {
        int leftHeight = (leftChild == null) ? 0 : leftChild.getHeight();
        int rightHeight = (rightChild == null) ? 0 : rightChild.getHeight();
        return Math.abs(leftHeight - rightHeight) <= 1;
    }

    public BinaryTreeDS<T> findNode(T data) {
        if (this.data.equals(data)) {
            return this;
        }
        if (leftChild != null && leftChild.data.equals(data)) {
            return leftChild.findNode(data);
        }
        if (rightChild != null && rightChild.data.equals(data)) {
            return rightChild.findNode(data);
        }
        return null;
    }

    public void deleteNode(T data) {
        BinaryTreeDS<T> nodeToDelete = findNode(data);
        if (nodeToDelete == null) {
            return;
        }
        if (nodeToDelete.isLeaf()) {
            if (nodeToDelete.parent.leftChild == nodeToDelete) {
                nodeToDelete.parent.leftChild = null;
            } else {
                nodeToDelete.parent.rightChild = null;
            }
            nodeToDelete = null;
        }
    }

    @Override
    public String toString() {
        return "BinaryTreeDS{" +
                "data=" + data +
                ", leftChild=" + (leftChild == null ? null : leftChild.data) +
                ", rightChild=" + (rightChild == null ? null : rightChild.data) +
                ", parent=" + (parent == null ? null : parent.data) + "}";
    }

}
