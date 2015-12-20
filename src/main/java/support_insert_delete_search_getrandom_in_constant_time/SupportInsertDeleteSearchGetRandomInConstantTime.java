package support_insert_delete_search_getrandom_in_constant_time;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class SupportInsertDeleteSearchGetRandomInConstantTime {
    /*
        Implement a Data Structure that supports insert, delete, search and getRandom in constant time
        http://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-search-and-getrandom-in-constant-time/
        Difficulty: Medium
    */
    public class NewDS {
        ArrayList<Integer> arr;
        HashMap<Integer, Integer> hash;

        public NewDS() {
            arr = new ArrayList<Integer>();
            hash = new HashMap<Integer, Integer>();
        }

        public void add(int x) {
            if (hash.get(x) != null)
                return;

            int s = arr.size();
            arr.add(x);
            hash.put(x, s);
        }

        public void remove(int x) {
            Integer index = hash.get(x);
            if (index == null)
                return;

            hash.remove(x);

            int size = arr.size();
            Integer last = arr.get(size - 1);
            Collections.swap(arr, index, size - 1);

            arr.remove(size - 1);

            hash.put(last, index);
        }

        int getRandom() {
            Random rand = new Random();  // Choose a different seed
            int index = rand.nextInt(arr.size());
            return arr.get(index);
        }

        boolean search(int x) {
            return hash.containsKey(x);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            NewDS ds = new SupportInsertDeleteSearchGetRandomInConstantTime().new NewDS();
            ds.add(5);
            ds.add(15);
            ds.add(-2);
            ds.add(1);
            ds.add(-3);
            assertTrue(ds.search(15));
            ds.remove(15);
            assertFalse(ds.search(15));
            assertFalse(ds.getRandom() == 15);
        }
    }
}

