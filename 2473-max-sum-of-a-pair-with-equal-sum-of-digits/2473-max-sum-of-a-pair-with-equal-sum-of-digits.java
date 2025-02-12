class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> nmap = new HashMap<>();
        for(int num: nums){
            int digitS = digitSum(num);
            if(nmap.containsKey(digitS)){
                List<Integer> temp = nmap.get(digitS);
                temp.add(num);
                nmap.put(digitS,temp);
            }
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(num);
                nmap.putIfAbsent(digitS,temp);
            }
        }
        int max = -1;
        for(Map.Entry<Integer, List<Integer>> entry: nmap.entrySet()){
            List<Integer> value = entry.getValue();
            if(value.size() > 1){
                value.sort(null);
                max = Math.max(max, value.get(value.size()-1) + value.get(value.size()-2));
            }
        }


        return max;
    }
    public static int digitSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}