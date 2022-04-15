class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int l = 0;
        int r = 0;
        String res = s;
        int resLen = Integer.MAX_VALUE;
        int counter = map.size();
        String subStr = s;
        while(r < s.length()){
            if(map.containsKey(s.charAt(r))){
                map.put(s.charAt(r), map.get(s.charAt(r)) - 1);
                if(map.get(s.charAt(r)) == 0){
                    counter--;
                }
            } 
            
            
            while(counter == 0){
                String possibleStr = s.substring(l, r+1);
                if(resLen > possibleStr.length()){
                    res = possibleStr;
                    resLen = res.length();
                }
                if(map.containsKey(s.charAt(l))){
                    map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                    if(map.get(s.charAt(l)) > 0){
                        counter++;       
                    }
                }
                l++;
            }
            r++;
            
        }
        if(resLen ==  Integer.MAX_VALUE) return "";
        return res;
    }
}