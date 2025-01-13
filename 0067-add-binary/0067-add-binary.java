class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result=new StringBuilder();
        int carry=0;
        // Length equal
        int maxlen=Math.max(a.length(), b.length());
        while(a.length()<maxlen){
            a="0"+a;
        }
        while(b.length()<maxlen){
            b="0"+b;
        }
        for(int i=maxlen-1;i>=0;i--){
            // to convert char/string in integer
            int bitA=a.charAt(i)-'0';
            int bitB=b.charAt(i)-'0';
            int sum=bitA+bitB+carry;

            result.append(sum%2); // add value in stringbuilder
            carry=sum/2; // update value
        }
        if(carry>0){
            result.append(carry); // append leftover carry
        }
        return result.reverse().toString(); // to reverse ans(001)
    }
}