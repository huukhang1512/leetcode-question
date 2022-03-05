class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        for(String str : strs){
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedS = String.valueOf(charArr);
            if(map.containsKey(sortedS)){
                map.get(sortedS).add(str);
            } else {
                map.put(sortedS, new ArrayList<String>());
                map.get(sortedS).add(str);
            }
        }
        return new ArrayList(map.values());
    }
}