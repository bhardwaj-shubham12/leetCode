class Solution {
    void makeMin(StringBuilder sBuilder, int[] counter){
        int index = 0;

        while(index < 26){
            while(counter[index] > 0){
                sBuilder.append((char)('a' + index));
                counter[index]--;
            }
            index++;
        }
    }
    boolean simulateString(String target, int[] counter, StringBuilder sBuilder, int index){
        if(index == target.length()) return true;

        int charIndex = target.charAt(index) - 'a';

        int nextIndex;
        if(index == target.length() - 1){
            nextIndex = charIndex + 1;
        }
        else{
            nextIndex = charIndex;
        }

        while(nextIndex < 26){
            if(counter[nextIndex] > 0){
                sBuilder.append((char)('a' + nextIndex));
                counter[nextIndex]--;
                //Keep checking validity
                if(nextIndex == charIndex){
                    if(simulateString(target, counter, sBuilder, index + 1)) return true;
                    sBuilder.deleteCharAt(sBuilder.length() - 1);
                    counter[nextIndex]++;
                }
                //make smallestString Possible
                else{
                    makeMin(sBuilder, counter);
                    return true;
                }
            }
            nextIndex++;
        }

        return false;
    }
    public String lexGreaterPermutation(String s, String target) {
        int[] counter = new int[26];

        for(int i=0;i<s.length();i++){
            counter[s.charAt(i) - 'a']++;
        }

        StringBuilder sBuilder = new StringBuilder("");
        if(!simulateString(target, counter, sBuilder,0)) return "";
        return sBuilder.toString();
    }
}