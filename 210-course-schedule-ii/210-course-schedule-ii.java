class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        boolean[][] matrix = new boolean[numCourses][numCourses];
        HashMap<Integer, LinkedList<Integer>> adjList = new HashMap<>();
        
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            int pre = prerequisites[i][1];
            int subject = prerequisites[i][0];
            inDegree[subject]++;
            if(adjList.containsKey(pre)){
                adjList.get(pre).add(subject);
            } else {            
                LinkedList<Integer> newList = new LinkedList<>();
                newList.add(subject);
                adjList.put(pre, newList);
            }
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
                if(adjList.containsKey(subject) && adjList.get(subject).contains(i)){
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