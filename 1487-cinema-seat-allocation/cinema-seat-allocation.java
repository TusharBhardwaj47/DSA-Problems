class Solution {
    
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,boolean[]> map=new HashMap<>();

        for(int[] r:reservedSeats){
            int row=r[0];
            int col=r[1];
            map.putIfAbsent(row,new boolean[11]);
            map.get(row)[col]=true;

        }
        int count=(n-map.size())*2;
        for(boolean[] reserved:map.values()){
            boolean left=true;
            boolean mid=true;
            boolean right=true;

            for(int j=2;j<=5;j++){
                if(reserved[j]){
                    left=false;
                    break;
                }
            }
            for(int j=4;j<=7;j++){
                if(reserved[j]){
                    mid=false;
                    break;
                }
            }
            for(int j=6;j<=9;j++){
                if(reserved[j]){
                    right=false;
                    break;
                }
            }

            if(left && right){
                count+=2;
            }else if(left || mid || right){
                count++;
            }

        }
        return count;
        
    }
}