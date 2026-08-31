class StockPrice {
    TreeMap<Integer, Integer> timeToPrice;
    TreeMap<Integer, Integer> priceToFreq;
    public StockPrice() {
        timeToPrice = new TreeMap<>();
        priceToFreq = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        //If the timestamp already exists, update old price with new price 
        if(timeToPrice.containsKey(timestamp)){
            int oldPrice = timeToPrice.get(timestamp);

            priceToFreq.put(oldPrice, priceToFreq.get(oldPrice)-1);
            if(priceToFreq.get(oldPrice) == 0){
                priceToFreq.remove(oldPrice);
            }
        }

        //Update timeStamp with new price and update the pricetofreq map
        timeToPrice.put(timestamp, price);
        if(!priceToFreq.containsKey(price)){
            priceToFreq.put(price, 1);
        }
        else{
            priceToFreq.put(price, priceToFreq.get(price)+1);
        } 
    }
    
    public int current() {
        return timeToPrice.lastEntry().getValue();
    }
    
    public int maximum() {
        return priceToFreq.lastEntry().getKey();
    }
    
    public int minimum() {
        return priceToFreq.firstEntry().getKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */