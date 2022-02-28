class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; // i -> j
        int[] indegree = new int[numCourses];

        // topological sorting, kahn algo
        for (int i=0; i<prerequisites.length; i++) {
            int subject = prerequisites[i][0];
            int pre = prerequisites[i][1];
            
            if (matrix[pre][subject] == 0){
                indegree[subject]++; 
            }
            matrix[pre][subject] = 1;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i=0; i<numCourses; i++) {
                if (matrix[course][i] != 0) {
                    indegree[i]--;
                    if (indegree[i] == 0){
                        queue.add(i);
                    }
                }
            }
        }
        return count == numCourses;
    }

    
}