class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int handSize = hand.length;
	    if((handSize % groupSize) != 0) return false;

	    Map<Integer, Integer> eleFreq=  new HashMap<>();	
	    PriorityQueue<Integer> pq = new PriorityQueue<>();

	    for(int ele: hand){
		    if(!eleFreq.containsKey(ele)){
			    pq.add(ele);
		    }
		    eleFreq.put(ele, eleFreq.getOrDefault(ele, 0) + 1);
	    }
	
	    int temp = -1;
	    int top;
	    while(!pq.isEmpty()){
		    List<Integer> tempList = new ArrayList<>();
		    temp = groupSize;
            while(temp > 0 && (!pq.isEmpty())){
	            top = pq.poll();
                tempList.add(top);
		        if(temp > 1){
			        if(pq.isEmpty()) return false;
			        if(pq.peek() != top + 1) return false;
		        }
	            temp-- ;
            }
            if(temp > 0) return false;


            for(int ele: tempList){
                if(eleFreq.get(ele) == 1){
	                eleFreq.remove(ele);
                }
                else{
	                eleFreq.put(ele, eleFreq.get(ele) - 1);
	                pq.add(ele);
                }
            }
            
	    }
        return true;
    }
}