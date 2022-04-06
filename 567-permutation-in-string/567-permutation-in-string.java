class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s1.length();i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i),0) + 1);
        }
        
        int count = map.size();
        int j = 0;
        for(int i = 0 ; i < s2.length();i++){
            char curr = s2.charAt(i);
            if(map.get(curr) != null){
                map.put(curr, map.get(curr) - 1);
                if(map.get(curr) == 0){
                    count--;
                }
            }

            if(count == 0){
                return true;
            }
            if(i + 1 >= s1.length()){
                 char curr1 = s2.charAt(j);
                if(map.containsKey(curr1)){
                    if(map.get(curr1) == 0)
                        count++;
                    map.put(curr1, map.getOrDefault(curr1, 0) + 1);
                }
                j++;
            }
        }
        
        return false;
    }
}