package io.suhaibbasha.datastructure;

public class TreeDS<T> {

    private T data;
    private TreeDS<T> parentNode;
    private ArrayListDS<TreeDS<T>> children = new ArrayListDS<TreeDS<T>>();

    public TreeDS(T data) {
        this.parentNode = null;
        this.data = data;
    }

    public void addChild(T data) {
        TreeDS<T> child = new TreeDS<>(data);
        child.parentNode = this;
        children.add(child);
    }

    public TreeDS<T> getChild(int index) {
        return children.get(index);
    }

    public boolean isRoot() {
        return parentNode == null;
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }

    public int getChildrenCount() {
        return children.size();
    }

    public void removeChild(int index) {
        children.remove(index);
    }

    public void removeAllChildren() {
        children.clear();
    }

    public T getData() {
        return data;
    }

    public TreeDS<T> getRoot() {
        TreeDS<T> currentNode = this;
        while (currentNode.parentNode != null) {
            currentNode = currentNode.parentNode;
        }
        return currentNode;
    }

    public TreeDS<T> getParent() {
        return parentNode;
    }

    public int getDepth() {
        int depth = 0;
        TreeDS<T> currentNode = this;
        while (currentNode.parentNode != null) {
            currentNode = currentNode.parentNode;
            depth++;
        }
        return depth;
    }

    public TreeDS<T> findNode(T data) {
        if (this.data.equals(data)) {
            return this;
        }
        for (int i = 0; i < children.size(); i++) {
            TreeDS<T> foundNode = children.get(i).findNode(data);
            if (foundNode != null) {
                return foundNode;
            }
        }
        return null;
    }

    public void display() {
        StringBuilder displayString = new StringBuilder();
        displayString.append(data);
        displayString.append(" (");
        if (parentNode != null) {
            displayString.append(parentNode.data);
        } else {
            displayString.append("ROOT");
        }
        displayString.append(") - ");
        for (int i = 0; i < children.size(); i++) {
            displayString.append(children.get(i).data);
            displayString.append(", ");
        }
        displayString.setLength(displayString.length() - 2);
        System.out.println(displayString);

        for (int i = 0; i < children.size(); i++) {
            children.get(i).display();
        }
    }

    @Override
    public String toString() {
        return "TreeDS{" +
                "data=" + data +
                ", parentNode=" + (parentNode == null ? null : parentNode.data) +
                ", children=" + children +
                "}";
    }

}
