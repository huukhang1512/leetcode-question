class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for(String word : wordDict){
            dict.add(word);
        }
        return dfs(s,0, dict,  new Boolean[s.length()]);
    }
    public boolean dfs(String s,int start, Set<String> dict, Boolean[] memo) {
        if(start == s.length()){
            return true;
        }
        if(memo[start] != null){
            return memo[start];
        }
        for(int i = start + 1; i <= s.length(); i++){
            if(dict.contains(s.substring(start, i)) && dfs(s, i, dict,memo)){
                memo[start] = true;
                return true;
            }
        }
        memo[start] = false;
        return false; 
    }
}