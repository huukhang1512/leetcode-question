class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // the goal is to continously add new interval and merge the interval together
        ArrayList<int[]> result = new ArrayList();
        for(int[] interval : intervals){
            // if the current interval[0] (start) is more than the new interval, 
            // it means that the new interval should be before the current interval, set the new interval into interval
            // as it will be use next as the larger interval
            if(interval[0] > newInterval[1]){
               result.add(newInterval);
               newInterval = interval;
            }
            
            // quite obviously here, the interval is before the new interval
            else if(interval[1] < newInterval[0]){
                result.add(interval);
            } 
            
            // else, keeping the min value between the start of both newInterval and the current Interval, 
            // as well as the max of the end value of the interval
            else {
                newInterval[0] = Math.min(newInterval[0],interval[0]); 
                newInterval[1] = Math.max(newInterval[1],interval[1]); 
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
        
    }
}