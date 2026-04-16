import java.util.*;
// a great circular array problem
// initially i stored the indices in arrlist for num[i] and then for each query 
// i was calculating the distance from all the indices in arrlist and taking the minimum but it was giving tle so i optimized
//  it by using binary search to find the closest index in arrlist and then calculating the distance from that index and its neighbors to get the minimum distance.
// also provided the code where i got tle for reference.
class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hm.containsKey(nums[i])) {
                hm.put(nums[i], new ArrayList<>());
            }
            hm.get(nums[i]).add(i);
        }
        // for (int i = 0; i < queries.length; i++) {
        //     List<Integer> ls = hm.get(nums[queries[i]]);
        //     if (ls.size() == 1) {
        //         ans.add(-1);
        //         continue;
        //     }
        //     int min = Integer.MAX_VALUE;
        //     for (int j = 0; j < ls.size(); j++) {
        //         if (ls.get(j) == queries[i]) {
        //             continue;
        //         }
        //         int d = Math.abs(ls.get(j) - queries[i]);
        //         int dist = Math.min(d, nums.length - d);
        //         min = Math.min(min, dist);
        //     }
        //     ans.add(min);
        // }
        for (int i = 0; i < queries.length; i++) {
            List<Integer> ls = hm.get(nums[queries[i]]);
            if (ls.size() == 1) {
                ans.add(-1);
                continue;
            }
            int min = Integer.MAX_VALUE;
            int idx = findidx(ls, queries[i]);
            int left = (idx - 1 + ls.size()) % ls.size();
            int right = (idx + 1) % ls.size();
            int d1 = Math.abs(ls.get(left) - queries[i]);
            int d2 = Math.abs(ls.get(right) - queries[i]);
            int dist1 = Math.min(d1, nums.length - d1);
            int dist2 = Math.min(d2, nums.length - d2);
            min = Math.min(dist1, dist2);
            ans.add(min);
        }
        return ans;
    }
    private int findidx(List<Integer> ls, int target) {
        int low = 0, high = ls.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ls.get(mid) == target) {
                return mid;
            } else if (ls.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}