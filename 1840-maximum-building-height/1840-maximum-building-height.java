class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        List<List<Integer>> restrictionArr = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(0);
        restrictionArr.add(temp);

        for(int i=0;i<restrictions.length;i++)
        {
            temp = new ArrayList<>();
            temp.add(restrictions[i][0]);
            temp.add(restrictions[i][1]);
            restrictionArr.add(temp);
        }
        if(restrictionArr.getLast().get(0) != n){
            temp = new ArrayList<>();
            temp.add(n);
            temp.add(n-1);
            restrictionArr.add(temp);
        }



        restrictionArr.sort(Comparator.comparing((List<Integer> list) -> list.get(0))
            );

        int prevHeight = -1, heightDiff = -1, curHeight;
        int distance = -1;

        for(int i=1;i<restrictionArr.size();i++){
            prevHeight = restrictionArr.get(i-1).get(1);
            curHeight = restrictionArr.get(i).get(1);
            heightDiff = restrictionArr.get(i).get(1) - prevHeight;

            distance = Math.abs(restrictionArr.get(i).get(0) - restrictionArr.get(i-1).get(0));

            restrictionArr.get(i).set(1, Math.min(curHeight, prevHeight + distance));
        }

        for(int i=restrictionArr.size() - 2; i>=0; i--){
            prevHeight = restrictionArr.get(i + 1).get(1);
            curHeight = restrictionArr.get(i).get(1);
            heightDiff = restrictionArr.get(i).get(1) - prevHeight;

            distance = Math.abs(restrictionArr.get(i).get(0) - restrictionArr.get(i + 1).get(0));

            restrictionArr.get(i).set(1, Math.min(curHeight, prevHeight + distance));
        }

        int maxHeight = -1;
        int curMaxHeight = -1;

        for(int i=1;i<restrictionArr.size();i++){
            prevHeight = restrictionArr.get(i - 1).get(1);
            curHeight = restrictionArr.get(i).get(1);

            distance = Math.abs(restrictionArr.get(i).get(0) - restrictionArr.get(i-1).get(0));

            curMaxHeight = (curHeight + prevHeight + distance) / 2;
            maxHeight = Math.max(curMaxHeight, maxHeight);
        }

        return maxHeight;
    }
}