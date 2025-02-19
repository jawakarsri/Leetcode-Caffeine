import java.util.*;

class Solution {
    List<String> happyStrings = new ArrayList<>();
    
    public String getHappyString(int n, int k) {
        backtrack(n, new StringBuilder(), ' ');
        
        if (k > happyStrings.size()) return "";
        return happyStrings.get(k - 1);
    }

    private void backtrack(int n, StringBuilder current, char lastChar) {
        if (current.length() == n) {
            happyStrings.add(current.toString());
            return;
        }
        
        for (char c : new char[]{'a', 'b', 'c'}) {
            if (c != lastChar) {
                //no consecutive char is same
                current.append(c);
                backtrack(n, current, c);
                current.deleteCharAt(current.length() - 1); // Backtrack
            }
        }
    }
}