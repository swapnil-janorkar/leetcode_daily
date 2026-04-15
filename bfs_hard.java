import java.util.*;
//  tag hard bfs
// the problem ask to find the shortest path from (0,0) to (n-1,m-1) in a grid with obstacles and we can remove at most k obstacles
// we can use bfs to solve this problem, we need to keep track of the number of obstacles we have removed and the number of steps we have taken. we can use a 3d boolean array to keep track of the visited states.
 
class Solution {
    class pair{
        int r;
        int c;
        int ob;
        int st;
        pair(int r,int c,int ob,int st){
            this.r=r;
            this.c=c;
            this.ob=ob;
            this.st=st;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int[][]dir={{0,1},{0,-1},{1,0},{-1,0}};
        if(n==1 && m==1){
            return 0;
        }
        Queue<pair>q=new LinkedList<>();
        boolean[][][]vis=new boolean[n][m][k+1];
        q.add(new pair(0,0,0,0));
        vis[0][0][0]=true;
        while(!q.isEmpty()){
            pair rem = q.remove();
            int row=rem.r;
            int col=rem.c;
            int obs=rem.ob;
            int stp=rem.st;
            for(int []d: dir){
                int nr=row+d[0];
                int nc=col+d[1];
                if(nr<0 || nr>n-1 || nc<0 || nc>m-1){
                    continue;
                }
                int nob=obs+grid[nr][nc];
                if(nob>k){
                    continue;
                }
                if(nr ==n-1 && nc ==m-1){
                    return stp+1;
                }
                if(!vis[nr][nc][nob]){
                    vis[nr][nc][nob]=true;
                    q.add(new pair(nr,nc,nob,stp+1));
                }
            }

        }
        return -1;


        
    }
}
