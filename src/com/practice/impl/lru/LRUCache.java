package com.practice.impl.lru;

import java.util.HashMap;
import java.util.Map;

import static com.practice.impl.lru.Constants.CACHE_LIMIT;

public class LRUCache {

    private int actualSize;
    private DoublyLL doublyLL;
    private Map<Integer, Node> map;

    public LRUCache(){
        map = new HashMap<>(CACHE_LIMIT);
        doublyLL = new DoublyLL();
    }

    public void put(int id, String data){
        Node newNode = new Node(id, data);

        if(this.map.containsKey(id)){
            Node node = this.map.get(id);
            node.setData(data);
            Node nextNode = node.getNextNode();
            Node prevNode = node.getPreviousNode();
            prevNode.setNextNode(nextNode);
            nextNode.setPreviousNode(prevNode);
            //Update node as head
            updateHead(node);
            //Update Map
            this.map.put(id, node);
        }
        else{
            // Add node as head if the limit allows else removeTail to make space
            if(this.actualSize >= CACHE_LIMIT){
                //Remove Tail and then add the new Node as head, update the tail node.
                removeTail();
                updateHead(newNode);
                //Update Map
                this.map.put(id, newNode);
            }
            else{
                updateHead(newNode);
                //Update Map
                this.map.put(id, newNode);
                this.actualSize++;
            }
        }
    }

    public void updateHead(Node node){
        Node currHead = this.doublyLL.getHeadNode();
        if(currHead!=null) {
            Node nextNode = node.getNextNode();
            Node prevNode = node.getPreviousNode();
            if(prevNode!=null) {
                prevNode.setNextNode(nextNode);
            }
            if(nextNode!=null) {
                nextNode.setPreviousNode(prevNode);
            }
            currHead.setPreviousNode(node);
            node.setPreviousNode(null);
            node.setNextNode(this.doublyLL.getHeadNode());
        }
        if(this.doublyLL.getTailNode()==null){
            this.doublyLL.setTailNode(node);
        }

        this.doublyLL.setHeadNode(node);
    }

    public void removeTail(){
        //Remove the tail node and also remove it from the Map
        Node currTail = this.doublyLL.getTailNode();
        if(currTail!=null) {
            this.map.remove(currTail.getId());
            Node newTail = currTail.getPreviousNode();
            newTail.setNextNode(null);
            this.doublyLL.setTailNode(newTail);
        }
    }

    public Node get(int id){
        if (this.map.containsKey(id)){
            Node node= this.map.get(id);
            updateHead(node);
            return node;
        }
        return null;
    }

    public void show(){
        Node node = this.doublyLL.getHeadNode();
        while(node!=null){
            System.out.print(node+" <--> ");
            node = node.getNextNode();
        }
    }
}
