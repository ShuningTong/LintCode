class ArrayReader {
    int[] largeArray;

    public ArrayReader(){
        this.largeArray = new int[6];
        for (int i = 0; i < 6; i++){
            this.largeArray[i] = i + 1;
        }
    }

    public int get(int index){
        if (index < 0){
            return -1;
        }
        if (index > 5){
            return Integer.MAX_VALUE;
        }
        return this.largeArray[index];
    }
}
