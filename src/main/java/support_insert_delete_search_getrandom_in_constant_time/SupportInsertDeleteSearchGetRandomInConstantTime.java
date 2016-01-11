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
        ArrayList<Integer> list;
        HashMap<Integer, Integer> map;

        public NewDS() {
            list = new ArrayList<Integer>();
            map = new HashMap<Integer, Integer>();
        }

        public void add(int x) {
            if (map.get(x) != null)
                return;

            int s = list.size();
            list.add(x);
            map.put(x, s);
        }

        public void remove(int x) {
            Integer index = map.get(x);
            if (index == null)
                return;

            map.remove(x);

            int size = list.size();
            Integer last = list.get(size - 1);
            Collections.swap(list, index, size - 1);

            list.remove(size - 1);

            map.put(last, index);
        }

        int getRandom() {
            Random rand = new Random();  // Choose a different seed
            int index = rand.nextInt(list.size());
            return list.get(index);
        }

        boolean search(int x) {
            return map.containsKey(x);
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

