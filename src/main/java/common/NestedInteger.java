package common;

import nested_list_weight_sum.NestedListWeightSum;

import java.util.List;

public class NestedInteger {
    Object self;

    // Constructor initializes an empty nested list.
    public NestedInteger() {
    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {

    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        if (self instanceof String) {
            return true;
        }
        return false;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return Integer.valueOf(self.toString());
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {

    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {

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