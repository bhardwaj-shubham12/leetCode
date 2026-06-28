import java.util.*;

class Solution {

    // Fix: Use .equals() for String comparison
    private String find(String s, Map<String, String> p) {
        if (p.get(s).equals(s)) {
            return s;
        }
        // Path compression: optimizes future lookups
        p.put(s, find(p.get(s), p)); 
        return p.get(s);
    }

    // Proper Union: Connects the root of one to the root of the other
    private void union(String s1, String s2, Map<String, String> p) {
        String root1 = find(s1, p);
        String root2 = find(s2, p);
        if (!root1.equals(root2)) {
            p.put(root1, root2); 
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unionSet = new HashMap<>();
        Map<String, String> owner = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        // 1. Initialize parents
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!parents.containsKey(email)) {
                    parents.put(email, email);
                    owner.put(email, account.get(0));
                }
            }
        }

        // 2. Correct Union Step: Union all emails in an account to the first email
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            for (int i = 2; i < account.size(); i++) {
                union(firstEmail, account.get(i), parents);
            }
        }

        // 3. Group by ultimate root parent
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                String parent = find(account.get(i), parents);
                if (!unionSet.containsKey(parent)) {
                    unionSet.put(parent, new TreeSet<>());
                }
                unionSet.get(parent).add(account.get(i));
            }
        }
        
        // 4. Build result
        for (Map.Entry<String, TreeSet<String>> unionEle : unionSet.entrySet()) {
            String parent = unionEle.getKey();
            TreeSet<String> currentSet = unionEle.getValue();

            ArrayList<String> temp = new ArrayList<>();
            temp.add(owner.get(parent));
            temp.addAll(currentSet);
            res.add(temp);
        }

        return res;
    }
}