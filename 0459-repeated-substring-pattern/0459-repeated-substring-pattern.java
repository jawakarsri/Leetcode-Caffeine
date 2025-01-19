class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        
        for (int l = 1; l <= n / 2; l++) {
            if (n % l == 0) {  // Length of s must be divisible by length of substring
                String sub = s.substring(0, l);
                int repeatTimes = n / l;
                StringBuilder repeatedString = new StringBuilder();
                
                for (int i = 0; i < repeatTimes; i++) {
                    repeatedString.append(sub);
                }
                
                if (repeatedString.toString().equals(s)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
