class Solution {
    public boolean isVowel(char character) {
        String vowels = "aeiou";
        return vowels.indexOf(character) != -1;
    }
    
    public int[] vowelStrings(String[] words, int[][] queries) {
        int wordCount = words.length;
        int[] prefixSum = new int[wordCount];
        
        for (int i = 0; i < wordCount; i++) {
            String currentWord = words[i];
            if (isVowel(currentWord.charAt(0)) && isVowel(currentWord.charAt(currentWord.length() - 1))) {
                prefixSum[i]++;
            }
        }
        
        for (int i = 1; i < wordCount; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }
        
        int[] results = new int[queries.length];
        int queryIndex = 0;
        
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            if (left == 0) {
                results[queryIndex++] = prefixSum[right];
            } else {
                results[queryIndex++] = prefixSum[right] - prefixSum[left - 1];
            }
        }
        
        return results;
    }
}