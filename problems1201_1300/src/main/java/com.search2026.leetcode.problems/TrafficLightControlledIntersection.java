package com.search2026.leetcode.problems;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TrafficLightControlledIntersection {

    /*
        Traffic Light Controlled Intersection
        Leetcode #1279
        https://github.com/search2026/leetcode_java/blob/master/problems1201_1300/resources/TrafficLightControlledIntersection.md
        Difficulty: Easy
     */
    class TrafficLight {
        public TrafficLight() {
        }

        boolean lightA = true;

        public void carArrived(int carId,
                               // ID of the car
                               int roadId,
                               // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
                               int direction,
                               // Direction of the car
                               Runnable turnGreen,
                               // Use turnGreen.run() to turn light to green on current road
                               Runnable crossCar
                               // Use crossCar.run() to make car cross the intersection
        ) {
            synchronized (this) {
                if (roadId == 1) {
                    if (!lightA) {
                        turnGreen.run();
                        lightA = true;
                    }
                    crossCar.run();
                } else {
                    if (lightA) {
                        turnGreen.run();
                        lightA = false;
                    }
                    crossCar.run();
                }
            }
        }
    }

}
