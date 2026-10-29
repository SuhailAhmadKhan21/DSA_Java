class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        int[] indegree = new int[numCourses];
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];
            graph.get(prerequisite).add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++)
        {
            if(indegree[i] == 0)
                q.offer(i);
        }
        int course = 0;
        while(q.size() > 0)
        {
            int curr = q.remove();
            course++;
            for(int n : graph.get(curr))
            {
                indegree[n]--;
                if(indegree[n] == 0)
                    q.add(n);
            }
        }
        return course == numCourses;
    }
}