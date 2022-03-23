class Solution {
    public int numSplits(String s) {
        int count = 0; 
        HashSet<Character> set = new HashSet<>();

        
        int[] preFix = new int[s.length()];
        int[] postFix = new int[s.length()];
        
        for(int i = 0; i < s.length();i++){
            set.add(s.charAt(i));
            preFix[i] = set.size();
        }
        set.clear();
        for(int i = s.length() - 1; i >= 0;i--){
            set.add(s.charAt(i));
            postFix[i] = set.size();
        }
        
        for(int i = 1; i < s.length();i++){
            if(preFix[i-1] == postFix[i]){
                count++;
            }
        }
        return count;
    }
}