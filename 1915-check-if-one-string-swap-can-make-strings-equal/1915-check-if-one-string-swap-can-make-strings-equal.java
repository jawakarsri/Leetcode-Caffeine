class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int c=0;
        char[] k1=new char[3];
        char[] k2=new char[3];
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)!=s2.charAt(i))
            {
                k1[c]=s1.charAt(i);
                k2[c]=s2.charAt(i);
                c++;
                if(c>2)
                {
                    return false;
                }
            }
        }
        if((c==2 && k1[0]==k2[1] && k1[1]==k2[0])|| c==0)
        {
            return true;
        }
        return false;
    }
}