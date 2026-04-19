import java.util.*;
// tag medium 
// the problem ask to find the maximum distance between two numbers in two arrays
// we can use two pointers to find the maximum distance between two numbers in two arrays

class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int maxdis=0;
        while(i< nums1.length&&j<nums2.length){
            if(nums1[i]<=nums2[j]){
                int dis=j-i;
                maxdis=Math.max(maxdis,dis);
                j++;
            }
            else{
                i++;
            }
           
        }
        return maxdis;
        
    }
}