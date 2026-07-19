class Solution {
    public String smallestSubsequence(String s) {
        int[] lastOcc = new int[26];
        for(int i=0;i<26;i++){
            lastOcc[i] = -1;
        }
        boolean[] visited = new boolean[26];
        for(int i=0;i<s.length();i++){
            lastOcc[s.charAt(i) - 'a'] = i;
        }

        StringBuilder sBuilder = new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(!visited[s.charAt(i) - 'a']){
                while((!sBuilder.isEmpty()) && (sBuilder.charAt(sBuilder.length() - 1) > s.charAt(i))){
                    if(lastOcc[sBuilder.charAt(sBuilder.length() - 1) - 'a'] > i){
                        visited[sBuilder.charAt(sBuilder.length() - 1) - 'a'] = false;
                        sBuilder.deleteCharAt(sBuilder.length() - 1);
                        
                    }
                    else{
                        break;
                    }
                }
            
                sBuilder.append(s.charAt(i));
                visited[s.charAt(i) - 'a'] = true;
            }

        }

        return sBuilder.toString();

        
    }
}