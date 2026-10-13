class Solution {
    public int totalFruit(int[] fruits) {
        int numFruit = fruits.length;
        int l = 0, r= 0;
        HashMap<Integer, Integer> hMap = new HashMap<>();
        int maxSize = 1;
        int numDistinct = 0;

        while(r < numFruit){
            if(!hMap.containsKey(fruits[r])){
                hMap.put(fruits[r], 1);
                numDistinct++;
            }
            else{
                hMap.put(fruits[r], hMap.get(fruits[r]) + 1);
            }
            while(numDistinct > 2){
                if(hMap.containsKey(fruits[l])){
                    if(hMap.get(fruits[l]) == 1){
                        hMap.remove(fruits[l]);
                        numDistinct--;
                    }
                    else{
                        hMap.put(fruits[l], hMap.get(fruits[l]) - 1);
                    }
                }
                l++;
            }
            maxSize = Math.max(maxSize, r - l + 1);
            r++;
        }

        return maxSize;
        
    }
}