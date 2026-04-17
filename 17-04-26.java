import java.util.*;
// needed to find the min ditance between the mirror pairs.
// easy problem comparitively but the only thing to take care of is to reverse the number and store the index of the reversed number 
// in the map and then when we encounter a number we check if its reverse is present in the map and if it is present then we calculate the 
// distance and update the minimum distance.
class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (map.containsKey(x)) {
                min = Math.min(min, i - map.get(x));
            }
            int rev = reverse(x);
            map.put(rev, i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    private int reverse(int x) {
        int res = 0;
        while (x > 0) {
            res = res * 10 + (x % 10);
            x /= 10;
        }
        return res;
    }
}