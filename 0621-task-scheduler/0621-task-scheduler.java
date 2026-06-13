class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> charMap = new HashMap<>();
        int maxFreq = 0;
        char maxFreqChar;

        for(int i=0;i<tasks.length;i++){
            int freq = charMap.getOrDefault(tasks[i], 0);
            charMap.put(tasks[i], ++freq);
            if(freq > maxFreq){
                maxFreq = freq;
                maxFreqChar = tasks[i];
            }
        }

        int time = (maxFreq - 1) * (n + 1);

        for(Map.Entry<Character, Integer> entry: charMap.entrySet()){
            if(entry.getValue() == maxFreq){
                time++;
            }
        }

        return Math.max(time, tasks.length);


    }
}