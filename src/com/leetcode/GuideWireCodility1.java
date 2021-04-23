package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GuideWireCodility1 {
    public int solution(int[] P, int[] S) {
        PriorityQueue<Car> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.vacant , a.vacant));
        PriorityQueue<Car> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.people));
        int res = S.length;

        for(int i = 0; i < P.length; i++){
            Car car = new Car(P[i], S[i]);
            minHeap.add(car);
            maxHeap.add(car);
        }

        while(!minHeap.isEmpty() && !maxHeap.isEmpty()){
            Car fewerP = minHeap.remove();
            Car maxVacant = maxHeap.remove();
            if(maxVacant.vacant == 0) break;
            int extra = maxVacant.vacant - fewerP.people;
            maxVacant.vacant = maxVacant.people + fewerP.people;
            maxHeap.add(maxVacant);
            if(extra >= 0){
                res--;

            }
        }
        return res;
    }


    class Car{
        int people;
        int seats;
        int vacant;

        Car(int people, int seats){
            people = people;
            seats = seats;
            vacant = seats - people;
        }
    }
}
