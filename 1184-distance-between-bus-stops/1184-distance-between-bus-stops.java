class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int leftToRight = 0;
        int numNodes = distance.length;

        int index = start;
        int end = ((start - 1) + numNodes) % numNodes;

        while((index != end) && (index != destination)){
            leftToRight += distance[index];
            index = (index + 1) % numNodes;
        }

        int rightToLeft = 0;
        index = start;
        end = (start + 1) % numNodes;

        while((index != end) && (index != destination)){
            rightToLeft += distance[(index - 1 + numNodes) % numNodes];
            index = ((index - 1) + numNodes) % numNodes;
        }

        return Math.min(rightToLeft, leftToRight);
    }
}