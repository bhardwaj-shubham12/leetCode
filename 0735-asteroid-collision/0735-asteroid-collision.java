class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int numAsteroids = asteroids.length;

        boolean[] isDestroyed = new boolean[numAsteroids];

        Deque<Integer> stack = new ArrayDeque<>();
        boolean toPush = true;

        for(int i=0;i<numAsteroids;i++){
            toPush = true;
            //System.out.println(i+ ": "+asteroids[i]);
            while(!stack.isEmpty()){
                if((asteroids[stack.peek()] > 0) && (asteroids[i] < 0)){
                    if(asteroids[stack.peek()] + asteroids[i] == 0){
                        isDestroyed[i] = true;
                        isDestroyed[stack.pop()] = true;
                        toPush = false;
                        break;
                    }
                    else if(asteroids[stack.peek()] + asteroids[i] < 0){
                        isDestroyed[stack.pop()] = true;
                    }
                    else{
                        isDestroyed[i] = true;
                        toPush = false;
                        break;
                    }
                }
                else break;
            }
            if(toPush)
                stack.push(i);
        }

        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<numAsteroids;i++){
            if(!isDestroyed[i]){
                temp.add(i);
            }
        }

        int[] ans = new int[temp.size()];
        for(int i=0;i<temp.size();i++){
            ans[i] = asteroids[temp.get(i)];
        }

        return ans;
    }
}