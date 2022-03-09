class TimeValue {
    int time;
    String value;
    public TimeValue(String value, int time){
        this.time = time;
        this.value = value;
    }
    
}
class TimeMap {
    HashMap<String,List<TimeValue>> map;
    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new ArrayList());
        }
        map.get(key).add(new TimeValue(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<TimeValue> val = map.get(key);
        // with binary search
        String res = "";
        int left = 0;
        int right = val.size() - 1;

        while(left <= right){
            int mid = (left+right)/2;
            if(val.get(mid).time <= timestamp){
                res = val.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */