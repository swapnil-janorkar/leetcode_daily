import java.util.*;
//  tag easy
// the problem ask to find the distance between a number and its mirror image
//  we can reverse the number and find the absolute difference between the original number and the reversed number.
class Solution {
    public int mirrorDistance(int n) {
        int ans=Math.abs(n-reverse(n));
        return ans;
        
    }
    private int reverse(int n){
        int ans=0;
        while(n>0){
            ans=(ans*10)+(n%10);
            n/=10;

        }
        return ans;
    }
}