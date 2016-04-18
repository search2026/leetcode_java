package common;

import nested_list_weight_sum.NestedListWeightSum;

import java.util.List;

public class NestedInteger {
    Object self;

    // Returns true if this com.sada.linkedin.NestedInteger holds a single integer, rather than a nested list
    public boolean isInteger() {
        if (self instanceof String) {
            return true;
        }
        return false;
    }

    // Returns the single integer that this com.sada.linkedin.NestedInteger holds, if it holds a single integer
    // Returns null if this com.sada.linkedin.NestedInteger holds a nested list
    public Integer getInteger() {
        return Integer.valueOf(self.toString());
    }

    // Returns the nested list that this com.sada.linkedin.NestedInteger holds, if it holds a nested list
    // Returns null if this com.sada.linkedin.NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        if (!isInteger()) {
            return (List<NestedInteger>) self;
        }

        return null;
    }
}