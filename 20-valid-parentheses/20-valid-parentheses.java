class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put('{','}');
        map.put('(',')');
        map.put('[',']');
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0 ; i < charArray.length;i++){
            if(map.get(charArray[i]) != null){
                stack.push(map.get(charArray[i]));
            } else if(stack.isEmpty() || stack.pop() != charArray[i]){
                return false;
            }
        }
        return stack.isEmpty();
    }
}