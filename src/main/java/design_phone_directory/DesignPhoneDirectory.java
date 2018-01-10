package design_phone_directory;

import org.junit.Test;

import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.*;

public class DesignPhoneDirectory {
  /*
      Design Phone Directory - Using bitset
      Leetcode #379
      https://discuss.leetcode.com/category/499/design-phone-directory
      http://www.cnblogs.com/grandyang/p/5735205.html
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
      return bitset.get(number) == false;
    }

    public void release(int number) {
      //handle release of unallocated ones
      if (bitset.get(number) == false)
        return;
      bitset.clear(number);
      if (number < smallestFreeIndex) {
        smallestFreeIndex = number;
      }
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      // Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
      PhoneDirectory directory = new DesignPhoneDirectory().new PhoneDirectory(3);

      // It can return any available phone number. Here we assume it returns 0.
      assertEquals(0, directory.get());

      // Assume it returns 1.
      assertEquals(1, directory.get());

      // The number 2 is available, so return true.
      assertTrue(directory.check(2));

      // It returns 2, the only number that is left.
      assertEquals(2, directory.get());

      // The number 2 is no longer available, so return false.
      assertFalse(directory.check(2));

      // Release number 2 back to the pool.
      directory.release(2);

      // Number 2 is available again, return true.
      assertTrue(directory.check(2));
    }
  }
}

