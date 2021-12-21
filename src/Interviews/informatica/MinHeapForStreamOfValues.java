package Interviews.informatica;

import java.util.List;
import java.util.PriorityQueue;

public class MinHeapForStreamOfValues {

    class GetMinValueAlways{
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        public void addElement(int ele){
            priorityQueue.add(ele);
        }
        public int getMinValue(){
            return priorityQueue.peek();
        }
    }

    public void findMinValueAtAnyGivenPointOfTime(List<Integer> elements){
        GetMinValueAlways getMinValueAlways = new GetMinValueAlways();
        int i =0;
        while (!elements.isEmpty() && i < elements.size()){
            getMinValueAlways.addElement(elements.get(i++));
            System.out.println("Min value at this moment -- "+getMinValueAlways.getMinValue());
        }
    }


    public static void main(String[] args) {

        new MinHeapForStreamOfValues().findMinValueAtAnyGivenPointOfTime(List.of(3,1,4,5,2,6,7,12,8));
    }

}
