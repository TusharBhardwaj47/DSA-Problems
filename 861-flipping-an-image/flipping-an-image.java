class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int res[][]=new int[image.length][image.length];
        for(int i=0;i<image.length;i++){
            int n=image.length-1;
            for(int j=0;j<image.length;j++){
                if(n>=0)res[i][j]=image[i][n--];
            }
        }
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image.length;j++){
                if(res[i][j]==1)res[i][j]=0;
                else res[i][j]=1;
            }
        }
        return res;
    }
}