class Allocator {

    int[] memory;
    public Allocator(int n) {
        memory = new int[n];
    }
    
    public int allocate(int size, int mID) {
        int free_count = 0;
        int block_start = -1;

        for(int i=0 ; i<memory.length; i++){
            if(memory[i] == 0){
                if(free_count == 0){
                    block_start = i;
                }
                free_count++;

                if(free_count == size){
                    for(int j=block_start; j<block_start+size; j++){
                        memory[j] = mID;
                    }
                    return block_start;
                }
            }
            else{
                free_count = 0;
                block_start = -1;
            }
        }
        return -1;
    }
    
    public int freeMemory(int mID) {
        int occupied_count = 0;
        for(int i=0; i<memory.length; i++){
            if(memory[i] == mID){
                memory[i] = 0;
                occupied_count++;
            }
        }
        return occupied_count;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */