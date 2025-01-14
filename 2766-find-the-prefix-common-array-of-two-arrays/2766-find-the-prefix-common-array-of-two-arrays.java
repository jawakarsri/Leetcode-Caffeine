class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int common = 0;
        int[] c = new int[n];
        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (s.contains(A[i])) {
                common++;
            }
            if (s.contains(B[i])) {
                common++;
            }
            if (A[i] == B[i]) {
                common++;
            }
            s.add(A[i]);
            s.add(B[i]);
            c[i] = common;
        }

        return c;
    }
}