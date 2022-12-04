package com.practice.leetcode.contest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MostPopularCreator {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {

        List<String> mostPopular = new ArrayList();
        List<List<String>> result = new ArrayList();
        int len = creators.length;
        Map<String, Integer> viewsMap = new HashMap();

        Map<String, Queue<IdView>> idsMap = new HashMap();
        int max = -1;
        List<String> maxCreators = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            String creator = creators[i];
            int viewCount = views[i];
            String id = ids[i];
            if (viewsMap.containsKey(creator)) {
                viewCount += viewsMap.get(creator);
                viewsMap.put(creator, viewCount);
                IdView idView = new IdView(views[i], id);
                final Queue<IdView> idViews = idsMap.get(creator);
                idViews.add(idView);
                idsMap.put(creator, idViews);
            } else {
                viewsMap.put(creator, viewCount);
                IdView idView = new IdView(viewCount,id);
                PriorityQueue<IdView> priorityQueue = new PriorityQueue(new CustomComparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return ((IdView)o1).getView() > ((IdView)o2).getView() ? 1 : -1;
                    }
                });
                priorityQueue.add(idView);
                idsMap.put(creator, priorityQueue);
            }

        }
        for(Map.Entry<String, Integer> entry: viewsMap.entrySet()){
            int value = entry.getValue();
            String key = entry.getKey();
            if(value > max){
                max = value;
                maxCreators = new ArrayList<>();
                maxCreators.add(key);
            }else if(value == max){
                maxCreators.add(key);
            }
        }
        
        for(int i=0;i<maxCreators.size();i++){
            String maxCreator = maxCreators.get(i);
            final Queue<IdView> idViews = idsMap.get(maxCreator);
            mostPopular = new ArrayList();
            mostPopular.add(maxCreator);
            mostPopular.add(idViews.peek().getId());
            result.add(mostPopular);
        }
        return result;
    }

    abstract class CustomComparator implements Comparator{

        public int compare(IdView o1, IdView o2) {
            return o1.getView() > o2.getView()? 1: -1;
        }
    }

    class IdView {
        private int view;
        private String id;

        public IdView(int view, String id) {
            this.id = id;
            this.view = view;
        }

        public int getView() {
            return this.view;
        }

        public String getId() {
            return this.id;
        }
    }


        class IdView2 implements Comparable<IdView>{
        private int view;
        private String id;

        public int getView() {
            return this.view;
        }

        public String getId() {
            return this.id;
        }

        public IdView2(int view, String id){
            super();
            this.id = id;
            this.view = view;
        }

        @Override
        public int compareTo(IdView obj) {
            return this.getView() > obj.getView()? 1 : -1;
        }
    }


    public static void main(String[] args) {

        MostPopularCreator m = new MostPopularCreator();
        final List<List<String>> lists = m.mostPopularCreator(new String[]{"alice", "alice", "alice"}, new String[]{"a", "b", "c"}, new int[]{1, 2, 2});
        System.out.println(lists);

    }


    /**
     * public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
     * 		long max = 0;
     * 		HashMap<String, PriorityQueue<Integer>> map = new HashMap<>();
     * 		HashMap<String, Long> count = new HashMap<>();
     * 		for (int i = 0; i < creators.length; i++) {
     * 			map.computeIfAbsent(creators[i], t -> new PriorityQueue<>(
     * 					(o, p) -> views[o] == views[p] ? ids[o].compareTo(ids[p]) : views[p] - views[o])).offer(i);
     * 			count.put(creators[i], count.getOrDefault(creators[i], 0L) + views[i]);
     * 			max = Math.max(max, count.get(creators[i]));
     *                }
     * 		ArrayList<List<String>> list = new ArrayList<>();
     * 		for (Map.Entry<String, Long> entry : count.entrySet()) {
     * 			if (entry.getValue() == max) {
     * 				list.add(List.of(entry.getKey(), ids[map.get(entry.getKey()).peek()]));
     *            }
     *        }
     * 		return list;* 	}
     * }
     */
}
