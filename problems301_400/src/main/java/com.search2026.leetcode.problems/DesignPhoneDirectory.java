package com.search2026.leetcode.problems;

import java.util.BitSet;

public class DesignPhoneDirectory {

    /*
        Design Phone Directory - Using bitset
        Leetcode #379
        https://github.com/search2026/leetcode_java/blob/master/problems301_400/resources/DesignPhoneDirectory.md
        Difficulty: Medium
     */
    public class PhoneDirectory {

        BitSet bitset;
        int max; // max limit allowed
        int smallestFreeIndex; // current smallest index of the free bit

        public PhoneDirectory(int maxNumbers) {
            this.bitset = new BitSet(maxNumbers);
            this.max = maxNumbers;
        }

        public int get() {
            // handle bitset fully allocated
            if (smallestFreeIndex == max) {
                return -1;
            }
            int num = smallestFreeIndex;
            bitset.set(smallestFreeIndex);
            //Only scan for the next free bit, from the previously known smallest free index
            smallestFreeIndex = bitset.nextClearBit(smallestFreeIndex);
            return num;
        }

        public boolean check(int number) {
            return !bitset.get(number);
        }

        public void release(int number) {
            //handle release of unallocated ones
            if (!bitset.get(number))
                return;
            bitset.clear(number);
            if (number < smallestFreeIndex) {
                smallestFreeIndex = number;
            }
        }
    }

}
