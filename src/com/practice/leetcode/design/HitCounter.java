package com.practice.leetcode.design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * 362. Design Hit Counter
 * Design a hit counter which counts the number of hits received in the past 5 minutes (i.e., the past 300 seconds).
 *
 * Your system should accept a timestamp parameter (in seconds granularity), and you may assume that calls are being made to the system in chronological order (i.e., timestamp is monotonically increasing). Several hits may arrive roughly at the same time.
 *
 * Implement the HitCounter class:
 *
 * HitCounter() Initializes the object of the hit counter system.
 * void hit(int timestamp) Records a hit that happened at timestamp (in seconds). Several hits may happen at the same timestamp.
 * int getHits(int timestamp) Returns the number of hits in the past 5 minutes from timestamp (i.e., the past 300 seconds).
 *
 *
 * Example 1:
 *
 * Input
 * ["HitCounter", "hit", "hit", "hit", "getHits", "hit", "getHits", "getHits"]
 * [[], [1], [2], [3], [4], [300], [300], [301]]
 * Output
 * [null, null, null, null, 3, null, 4, 3]
 *
 * Explanation
 * HitCounter hitCounter = new HitCounter();
 * hitCounter.hit(1);       // hit at timestamp 1.
 * hitCounter.hit(2);       // hit at timestamp 2.
 * hitCounter.hit(3);       // hit at timestamp 3.
 * hitCounter.getHits(4);   // get hits at timestamp 4, return 3.
 * hitCounter.hit(300);     // hit at timestamp 300.
 * hitCounter.getHits(300); // get hits at timestamp 300, return 4.
 * hitCounter.getHits(301); // get hits at timestamp 301, return 3.
 *
 *
 * Constraints:
 *
 * 1 <= timestamp <= 2 * 109
 * All the calls are being made to the system in chronological order (i.e., timestamp is monotonically increasing).
 * At most 300 calls will be made to hit and getHits.
 *
 *
 * Follow up: What if the number of hits per second could be huge? Does your design scale?
 */
public class HitCounter {

    /**
     * We can use either Map or Queue but not both required.
     * Queue is sufficient to do the job. If there are number of hits per second are more than 1, we can use a Pair in Queue
     * by having count and timestamp. When we remove, we can just remove the pair instead of removing from queue many times.
     */
    private Map<Integer, Integer> map;
    private Queue<Integer> queue;
    private int constantTime = 300;

    public HitCounter() {
//        map = new TreeMap<>();
        queue = new LinkedList<>();
    }

    public void hit(int timestamp) {
//        map.put(timestamp, map.getOrDefault(timestamp,0)+1);
        queue.add(timestamp);
//        removeHitsBeyond(timestamp);
    }

    public int getHits(int timestamp) {
//        removeHitsBeyond(timestamp);
        int removableTimes = timestamp - constantTime;
        while(!queue.isEmpty()){
            if(queue.peek() < removableTimes){
                queue.poll();
            }else{
                break;
            }
        }
        return queue.size();
    }

    private void removeHitsBeyond(int timeStamp){
        int removableTimes = timeStamp - constantTime;
        List<Integer> list = new ArrayList<>();
        for(int key:map.keySet()){
            if(key >= removableTimes){
                break;
            }else{
                int cnt = map.get(key);
                while(cnt > 0){
                    queue.poll();
                    cnt--;
                }
                list.add(key);
            }
        }
        for(int i=0; i< list.size(); i++){
            map.remove(list.get(i));
        }
    }
}
