class Solution {
    private double calcTime(int target, int[][] calMatrix, int index){
        double distDiff = (double)target - calMatrix[index][1];
        double time = distDiff/calMatrix[index][2];
        return time;
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int numCars = position.length;
        int[][] carMatrix = new int[numCars][3];

        for(int i=0;i<numCars;i++){
            carMatrix[i][0] = i;
            carMatrix[i][1] = position[i];
            carMatrix[i][2] = speed[i];
        }

        Arrays.sort(carMatrix, (a,b) -> Integer.compare(b[1], a[1]));

        int l = 0;
        int r = l;
        double timeL = -1, timeR = -1;
        int numFleet = 1;

        while((l<numCars) && (r < numCars)){
            //timeL = (((long)target - carMatrix[l][1])/(long)carMatrix[l][2]);
            timeL = calcTime(target, carMatrix, l);
            //System.out.println("timeL: "+timeL);
            while(r < numCars){
                //timeR = (((long)target - carMatrix[r][1])/(long)carMatrix[r][2]);
                timeR = calcTime(target, carMatrix, r);
                //System.out.println("timeR: "+timeR);
                if(timeR <= timeL){
                    r++;
                }
                else break;
            }
            if(r < numCars)
                numFleet++;
            else return numFleet;
            l = r;
        }

        return numFleet;
    }
}