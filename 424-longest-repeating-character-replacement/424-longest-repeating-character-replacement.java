class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0; 
        int j = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
            while((i-j+1) - getMaxFreq(map) > k){
                map.put(s.charAt(j), map.get(s.charAt(j))- 1); // decrease the freq in the map
                j++;
            }
            result = Math.max(result,i-j+1);
        }
        return result;
    }
    
    public int getMaxFreq(HashMap<Character,Integer> map){
        int maxFreq = 0;
        for(int value : map.values()){
            maxFreq = Math.max(maxFreq,value);
        }
        
        return maxFreq;
    }
}