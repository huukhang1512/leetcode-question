class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0) return new int[0];
        
        HashMap<Integer, ArrayList<Integer>> preMap = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        
        for(int i = 0 ; i < numCourses; i++){
            preMap.put(i, new ArrayList<Integer>());
            inDegree.put(i, 0);
        }
        
        for(int[] prerequisite : prerequisites){
            int subject = prerequisite[0];
            int preSubject = prerequisite[1];
            
            preMap.get(preSubject).add(subject);
            inDegree.put(subject, inDegree.get(subject) + 1);
            
        }
        
        int[] res = new int[numCourses];
        int index = 0;
        while(!inDegree.isEmpty()){
            boolean isCyclic = true;
            for(int course: inDegree.keySet()){
                if(inDegree.get(course) == 0){ // no prerequisite, or 0 indegrees
                    res[index++] = course;

                    ArrayList<Integer> children = preMap.get(course);
                    for(int child : children)
                        inDegree.put(child, inDegree.get(child) - 1);
                    inDegree.remove(course);
                    isCyclic = false;
                    break; 
                }
            }
            if (isCyclic)
                return new int[0]; // empty array
        }
        return res;
    }
}