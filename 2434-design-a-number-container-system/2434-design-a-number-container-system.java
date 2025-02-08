class NumberContainers {
    HashMap<Integer,PriorityQueue<Integer>> mainMap;
    HashMap<Integer,Integer> indx;
    NumberContainers() {
        this.mainMap=new HashMap<>();
        indx=new HashMap<>();
    }
    
    void change(int index, int number) {
        int val=this.indx.getOrDefault(index,0);
        if(val==0){
            this.indx.put(index,number);
            if(mainMap.containsKey(number)){
                PriorityQueue<Integer> tp=this.mainMap.get(number);
                tp.offer(index);
            }else{
                PriorityQueue<Integer> pq=new PriorityQueue<>();
                pq.add(index);
                this.mainMap.put(number,pq);

            }
        }else{
            if(val==number) return;
            PriorityQueue<Integer> tp=this.mainMap.get(val);
            tp.remove(index);
            this.indx.put(index,number);
            this.mainMap.computeIfAbsent(number,k->new PriorityQueue<>()).offer(index);

        }
        
    }
    
    int find(int number) {
        if(mainMap.containsKey(number)&&mainMap.get(number).size()!=0){
            return mainMap.get(number).peek();
        }
        return -1;
    }
};

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers* obj = new NumberContainers();
 * obj->change(index,number);
 * int param_2 = obj->find(number);
 */