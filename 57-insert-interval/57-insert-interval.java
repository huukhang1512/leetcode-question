class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // the goal is keeping track of the minimum start, and the maximum end of the next interval to be added
        ArrayList<int[]> result = new ArrayList();
        for(int[] interval : intervals){
            // if the current interval[0] (start) is more than the new interval, -> the entire interval is bigger
            if(interval[0] > newInterval[1]){
               result.add(newInterval);
               newInterval = interval;
            }
            
            // quite obviously here, the interval is smaller than the new interval
            else if(interval[1] < newInterval[0]){
                result.add(interval);
            } 
            
            // else, init a new interval with the min between the start value, and the max of the end value
            else {
                newInterval[0] = Math.min(newInterval[0],interval[0]); 
                newInterval[1] = Math.max(newInterval[1],interval[1]); 
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
        
    }
}