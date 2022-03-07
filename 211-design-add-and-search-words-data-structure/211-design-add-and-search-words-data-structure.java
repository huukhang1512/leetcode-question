class WordDictionary {
    HashMap<Character, WordDictionary> children;
    boolean isEnd;
    public WordDictionary() {
        children = new HashMap<>();
        isEnd = false;
    }
    WordDictionary root = this;
    public void addWord(String word) {
        WordDictionary cur = root;
        char[] charArr = word.toCharArray();
        for(char c: charArr){
            if(!cur.children.containsKey(c)){
                cur.children.put(c, new WordDictionary());
            }
            cur = cur.children.get(c);
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        WordDictionary cur = root;
        for(int i = 0; i < word.length();i++){
            if(word.charAt(i) == '.'){
                for(WordDictionary c : cur.children.values()){
                    if(c != null && c.search(word.substring(i+1))){
                        return true;
                    };
                }
                return false;
            }
            if(!cur.children.containsKey(word.charAt(i))){
                return false;
            }
            cur = cur.children.get(word.charAt(i));
        }
        return cur != null && cur.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
