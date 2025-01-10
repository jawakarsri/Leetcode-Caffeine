class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> l=new ArrayList<>();
        int freq[]=new int[26];
        for(String s:words2){
            int temp[]=getFreq(s);
            for(int i=0;i<26;i++){
                freq[i]=Math.max(freq[i],temp[i]);
            }
        }
        for(String s:words1){
            int temp[]=getFreq(s);
            boolean flag=true;
            for(int i=0;i<26;i++){
                if(freq[i]>temp[i]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                l.add(s);
            }
        }
        return l;
    }
    public int[] getFreq(String s){
        int temp[]=new int[26];
        for(int i=0;i<s.length();i++){
            temp[s.charAt(i)-'a']++;
        }
        return temp;
    }
}