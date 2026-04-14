import java.util.*;
// leetcode daily 14 april 2026

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.<int[]>comparingInt(a -> a[0]));
        List<Integer>fp=new ArrayList<>();
        for(int []f:factory){
            for(int i=0;i<f[1];i++){
                fp.add(f[0]);
            }
        }
        int rc=robot.size();
        int fc=fp.size();
        long[][]dp=new long[rc+1][fc+1];
        for(int i=0;i<rc;i++){
           dp[i][fc]=(long) 1e12;
        }
        for(int i=rc-1;i>=0;i--){
            for(int j=fc-1;j>=0;j--){
                long take=Math.abs(robot.get(i)-fp.get(j))+dp[i+1][j+1];
                long ntake=dp[i][j+1];
                dp[i][j]=Math.min(take,ntake);
            }
        }
        return dp[0][0];

        
    }
}
