class TimeMap {
    class Pair{
        int timeStamp;
        String value;

        Pair(int timeStamp, String value){
            this.timeStamp = timeStamp;
            this.value = value;
        }
    }

    HashMap<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(timestamp, value));        
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }

        List<Pair> list = map.get(key);
        int low = 0;
        int high = list.size()-1;

        String answer = "";
        while(low<=high){
            int mid = low + (high-low) / 2;
            int currentTime = list.get(mid).timeStamp;
            if(currentTime <= timestamp){
                answer = list.get(mid).value;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return answer;    
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */