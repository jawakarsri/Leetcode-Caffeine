class Solution {
    public boolean isPrefixAndSuffix(String str1, String str2){
        int oneLength = str1.length();
        int twoLength = str2.length();
        if(oneLength > twoLength){
            return false;
        }
        if(str2.substring(0, oneLength).equals(str1)){
            if(str2.substring(twoLength-oneLength).equals(str1)){
                return true;
            }
        }
        return false;
    }
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for(int i = 0; i < words.length-1; i++){
            for(int j = i+1; j <words.length; j++){
                if(isPrefixAndSuffix(words[i],words[j])){
                    count++;
                }
            }
        }
        return count;
    }
}