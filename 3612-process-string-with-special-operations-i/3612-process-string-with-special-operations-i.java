class Solution {
    public String processStr(String s) {
        StringBuilder sBuild = new StringBuilder("");

        for(int i=0;i<s.length();i++){
            switch(s.charAt(i)){
                case '*':   if(sBuild.length() >= 1)
                                sBuild.deleteCharAt(sBuild.length() - 1);
                            break;
                case '#':   sBuild.append(sBuild.toString());
                            break;
                case '%':   sBuild.reverse();
                            break;
                default:    sBuild.append(String.valueOf(s.charAt(i)));
                            break;
            }
        }

        return sBuild.toString();
    }
}