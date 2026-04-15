class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n=words.length;
        int mind=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(words[i].equals(target)){
                int d=Math.abs(i-startIndex);
                int cd=Math.min(d,n-d);
                mind=Math.min(mind,cd);

            }
        }
        if(mind==Integer.MAX_VALUE){
            return -1;
        }
        return mind;
    }
}

// it was a easy circualr array question, we just need to find the minimum distance in both direction and take the minimum of them. 
// if we dont find the target then we return -1.