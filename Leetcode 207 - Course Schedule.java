Leetcode 207 - Course Schedule.java

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //1.记录所有Node的indegree，不管这个入读是从哪里来的
        //2.找到入读为0的点，加入Q
        //3.BFS，Q.poll(), 所有neighbor的indegree都 -1，indegree为0的Node加入Queue
        //4.如果Q为空，而图中仍有点存在indegree，证明有环
        if(numCourses == 0) {
            return true;
        }
        
        if(prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        
        int[] indegreeCount = new int[numCourses];
        
        //1.记录所有Node的indegree，不管这个indegree是从哪里来的
        for(int i = 0; i < prerequisites.length; i++) {
            int courseId = prerequisites[i][0];
            indegreeCount[courseId] ++;
        }
        
        Queue<Integer> Q = new LinkedList<Integer>();
        int res = 0;
        //2.找到入度为0的点
        for(int courseId = 0; courseId < numCourses; courseId++) {
            if(indegreeCount[courseId] == 0) {
                Q.offer(courseId);
                res++;
            }
        }
        
        //3.BFS，Q.poll(), 所有neighbor的indegree都 -1，indegree为0的Node加入Queue
        while(!Q.isEmpty()) {
            int currCourse = Q.poll();
            
            for(int i = 0; i < prerequisites.length; i++) {
                if(prerequisites[i][1] == currCourse) {
                    indegreeCount[prerequisites[i][0]]--;
                    if(indegreeCount[prerequisites[i][0]] == 0) {
                        System.out.println("offer" + indegreeCount[prerequisites[i][0]]);
                        Q.offer(prerequisites[i][0]);
                        res++;
                    }
                }
            }
        }
        
        return res == numCourses;
    }
}