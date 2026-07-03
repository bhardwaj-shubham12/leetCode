class TimeMap {

    class ListElement{
        public int timestamp;
        public String value;

        public ListElement(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    };

    Map<String,List<ListElement>> mapList;

    public TimeMap() {
        mapList = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(mapList.containsKey(key) == false){
            mapList.put(key, new ArrayList<>());    
        }
        mapList.get(key).add(new ListElement(timestamp, value));
        
    }
    
    public String get(String key, int timestamp) {
        if(mapList.containsKey(key) == false) return "";
        List<ListElement> curList = mapList.get(key);

        int l = 0;
        int r = curList.size() - 1;
        int mid;
        int ans = -1;

        while(l <= r){
            mid = l + (r - l)/2;
            if((curList.get(mid).timestamp) <= timestamp){
                l = mid + 1;
                ans = (ans > mid) ? ans: mid;
            }
            else{
                r = mid - 1;
            }
        }

        if(ans == -1) return "";
        return curList.get(ans).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */