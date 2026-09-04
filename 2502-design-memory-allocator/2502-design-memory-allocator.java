class Allocator {

    int[] memory;
    public Allocator(int n) {
        memory = new int[n];
    }
    
    public int allocate(int size, int mID) {
        int count = 0;
        int start = -1;

        for(int i=0 ; i<memory.length; i++){
            if(memory[i] == 0){
                if(count == 0){
                    start = i;
                }
                count++;

                if(count == size){
                    for(int j=start; j<start+size; j++){
                        memory[j] = mID;
                    }
                    return start;
                }
            }
            else{
                count = 0;
                start = -1;
            }
        }
        return -1;
    }
    
    public int freeMemory(int mID) {
        int count = 0;
        for(int i=0; i<memory.length; i++){
            if(memory[i] == mID){
                memory[i] = 0;
                count++;
            }
        }
        return count;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */