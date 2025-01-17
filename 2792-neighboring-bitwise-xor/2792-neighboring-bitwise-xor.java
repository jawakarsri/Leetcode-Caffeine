class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        // if(derived.length<2)return false;

        int sum=0;
        for(int a:derived){
            sum^=a;
        }
       
    if(sum==0){
        return true;
    }
        return false;
    }
}