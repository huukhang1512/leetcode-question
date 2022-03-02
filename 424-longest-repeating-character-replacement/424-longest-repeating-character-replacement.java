class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0; 
        int j = 0;
        int maxf = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
            maxf = Math.max(maxf, map.get(s.charAt(i)));
            while((i-j+1) - maxf > k){
                map.put(s.charAt(j), map.get(s.charAt(j))- 1); // decrease the freq in the map
                j++;
            }
            result = Math.max(result,i-j+1);
        }
        return result;
    }
}