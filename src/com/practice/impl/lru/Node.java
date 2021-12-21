package com.practice.impl.lru;

public class Node {

    public Node(){
    }

    public Node(int id, String data) {
        this.id = id;
        this.data = data;
    }

    private int id;

    private String data;

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Node previousNode;

    private Node nextNode;

    @Override
    public String toString(){
        return id+"-"+data;
    }

}
