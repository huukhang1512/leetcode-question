class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] matrix = new boolean[numCourses][numCourses]; // i -> j
        int[] indegree = new int[numCourses];

        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        
        
        // topological sorting, kahn algo
        for (int i=0; i<prerequisites.length; i++) {
            int subject = prerequisites[i][0];
            int pre = prerequisites[i][1];
            
            if (!matrix[pre][subject]){
                indegree[subject]++; 
            }
            matrix[pre][subject] = true;
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
                if (matrix[course][i]) { // check if there are any other subject that need course as req
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