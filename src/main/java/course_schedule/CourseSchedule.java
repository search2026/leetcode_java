package course_schedule;

import java.util.*;

public class CourseSchedule {

    public class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, List<Integer>> outNodes = new HashMap<Integer, List<Integer>>();
            int[] inDegree = new int[numCourses];
            Set<Integer> courses = new HashSet<Integer>(numCourses);
            for (int i = 0; i < numCourses; i++) {
                courses.add(i);
                outNodes.put(i, new ArrayList<Integer>());
            }
            for (int[] edge : prerequisites) {
                int from = edge[1];
                int to = edge[0];
                inDegree[to]++;
                List<Integer> nodes = outNodes.get(from);
                nodes.add(to);
            }
            while (!courses.isEmpty()) {
                List<Integer> toRemoved = new ArrayList<Integer>();
                for (int course : courses) {
                    if (inDegree[course] == 0) {
                        toRemoved.add(course);
                        for (int node : outNodes.get(course)) {
                            inDegree[node]--;
                        }
                    }
                }
                if (toRemoved.isEmpty()) {
                    return false;
                }
                courses.removeAll(toRemoved);
            }
            return true;
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null){
            throw new IllegalArgumentException("illegal prerequisites array");
        }

        int len = prerequisites.length;

        //if there is no prerequisites, return a sequence of courses
        if(len == 0){
            int[] res = new int[numCourses];
            for(int m=0; m<numCourses; m++){
                res[m]=m;
            }
            return res;
        }

        //records the number of prerequisites each course (0,...,numCourses-1) requires
        int[] pCounter = new int[numCourses];
        for(int i=0; i<len; i++){
            pCounter[prerequisites[i][0]]++;
        }

        //stores courses that have no prerequisites
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(pCounter[i]==0){
                queue.add(i);
            }
        }

        int numNoPre = queue.size();

        //initialize result
        int[] result = new int[numCourses];
        int j=0;

        while(!queue.isEmpty()){
            int c = queue.remove();
            result[j++]=c;

            for(int i=0; i<len; i++){
                if(prerequisites[i][1]==c){
                    pCounter[prerequisites[i][0]]--;
                    if(pCounter[prerequisites[i][0]]==0){
                        queue.add(prerequisites[i][0]);
                        numNoPre++;
                    }
                }

            }
        }

        //return result
        if(numNoPre==numCourses){
            return result;
        }else{
            return new int[0];
        }
    }
}

