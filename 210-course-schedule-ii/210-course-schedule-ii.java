class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        boolean[][] matrix = new boolean[numCourses][numCourses];
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            inDegree[prerequisites[i][0]]++;
            matrix[prerequisites[i][1]][prerequisites[i][0]] = true;
        }
        
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        int index = 0;
        while(!queue.isEmpty()){
            int subject = queue.poll();
            res[index++] = subject;
            for(int i = 0; i < numCourses; i++){
                if(matrix[subject][i]){
                    inDegree[i]--;
                    if(inDegree[i] == 0){
                        queue.add(i);
                    }
                }
            }
        }
        return index == numCourses ? res : new int[0];
    }
}