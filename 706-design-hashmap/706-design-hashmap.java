class MyHashMap {
    private List<int[]>[] entries;
    private int size = 13000;
    public MyHashMap() {
        this.entries = new ArrayList[size];
        for(int i=0; i<this.entries.length; i++)
            this.entries[i] = new ArrayList<>();
    }
    
    public int hash(int key){
        return key % this.size;
    }
    public void put(int key, int value) {
        int index = this.hash(key);
        for(int i = 0; i < this.entries[index].size(); i++){
            if(this.entries[index].get(i)[0] == key){
                this.entries[index].get(i)[1] = value;
                return;
            }
        }
        this.entries[index].add(new int[] {key,value});
    }
    
    public int get(int key) {
        int index = this.hash(key);
        for(int i = 0; i < this.entries[index].size(); i++){
            if(this.entries[index].get(i)[0] == key){
                return this.entries[index].get(i)[1];
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = this.hash(key);
        for(int i = 0; i < this.entries[index].size(); i++){
            if(this.entries[index].get(i)[0] == key){
                this.entries[index].remove(i);
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */