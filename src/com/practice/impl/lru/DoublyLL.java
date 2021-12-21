package com.practice.impl.lru;

public class DoublyLL {

    private Node headNode;

    public Node getHeadNode() {
        return headNode;
    }

    public void setHeadNode(Node headNode) {
        this.headNode = headNode;
    }

    public Node getTailNode() {
        return tailNode;
    }

    public void setTailNode(Node tailNode) {
        this.tailNode = tailNode;
    }

    private Node tailNode;
}
