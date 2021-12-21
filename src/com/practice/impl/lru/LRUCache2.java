package com.practice.impl.lru;

import java.util.HashMap;
import java.util.Map;

import static com.practice.impl.lru.Constants.CACHE_LIMIT;

public class LRUCache2 {
    private int actualSize;
    private DoublyLL linkedList;
    private Map<Integer, Node> map;

    public LRUCache2() {
        map = new HashMap<>(CACHE_LIMIT);
        linkedList = new DoublyLL();
    }

    public void put(int id, String data){
        //If id already exists in Map, update the node with new data and move the node to front of linkedlist
        if(map.containsKey(id)){
            Node node = map.get(id);
            node.setData(data);
            updateToHead(node);
            return;
        }
        //Else create a node
        Node node = new Node(id, data);
        //If size of elements less than cache limit, increment the counter. Add the node in front of LL.
        if(this.actualSize < CACHE_LIMIT){
            this.actualSize++;
            addInFront(node);
        }
        //Else remove Tail and add this node in front.
        else{
            removeTail();
            addInFront(node);
        }
    }

    public void addInFront(Node node){
        node.setNextNode(this.linkedList.getHeadNode());
        node.setPreviousNode(null);
        if(this.linkedList.getHeadNode()!=null){
            this.linkedList.getHeadNode().setPreviousNode(node);
        }
        this.linkedList.setHeadNode(node);
        if(this.linkedList.getTailNode()==null){
            this.linkedList.setTailNode(node);
        }
        this.map.put(node.getId(), node);
    }

    public void removeTail(){
        Node lastNode = this.linkedList.getTailNode();
        this.linkedList.setTailNode(lastNode.getPreviousNode());
        if(this.linkedList.getTailNode()!=null){
            this.linkedList.getTailNode().setNextNode(null);
        }
        lastNode = null;
    }

    public void updateToHead(Node node){
        //Find out prev and next node of the current node
        Node prevNode = node.getPreviousNode();
        Node nextNode = node.getNextNode();

        //If prevNode is not null, then next pointer of prevNode points to nextNode
        if(prevNode!=null){
            prevNode.setNextNode(nextNode);
        }
        //If prevNode is null, then set linked list head to nextNode
        else{
            this.linkedList.setHeadNode(nextNode);
        }
        //If nextNode is not null, then prev pointer of nextNode points to prevNode
        if(nextNode!=null){
            nextNode.setPreviousNode(prevNode);
        }
        //Else set prevNode to tail node
        else{
            this.linkedList.setTailNode(prevNode);
        }
        addInFront(node);
    }

    public Node get(int id){
        if(!this.map.containsKey(id)){
            return null;
        }
        Node node = this.map.get(id);
        updateToHead(node);
        return node;
    }

    public void show(){
        Node head = this.linkedList.getHeadNode();
        while (head!=null){
            System.out.print(" <--> "+head);
            head = head.getNextNode();
        }
    }
}
