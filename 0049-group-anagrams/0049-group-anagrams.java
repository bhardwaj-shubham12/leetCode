class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anaMap = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            char[] tempArray = strs[i].toCharArray();
            Arrays.sort(tempArray);
            String tempString = new String(tempArray);

            if(!anaMap.containsKey(tempString)){
                anaMap.put(tempString, new ArrayList<>());
            }
            anaMap.get(tempString).add(strs[i]);
        }

        List<List<String>> stringArr = new ArrayList<>();

        for(Map.Entry<String, List<String>> ele: anaMap.entrySet()){
            List<String> temp = new ArrayList<>();
            for(String stringEle: ele.getValue()){
                temp.add(stringEle);
            }
            stringArr.add(temp);
        }

        return stringArr;

    }
}