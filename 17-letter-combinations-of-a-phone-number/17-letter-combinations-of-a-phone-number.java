class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};
        
        ArrayList<String> result = new ArrayList();
        if(digits.length() == 0){
            return result;
        }
        backtrack(map, result, new StringBuilder(),digits, 0);
        return result;
    }
    public void backtrack(Map<Character, String> map, ArrayList<String> result, StringBuilder curStr, String digits, int offset){
        if(offset == digits.length()){
            result.add(curStr.toString());
        } else {
            String listOfLetter = map.get(digits.charAt(offset));
            for(int i = 0; i < listOfLetter.length(); i++){
                curStr.append(listOfLetter.charAt(i));
                backtrack(map, result, curStr, digits, offset+1);
                curStr.deleteCharAt(curStr.length() - 1); 
            }   
        }
    }
}