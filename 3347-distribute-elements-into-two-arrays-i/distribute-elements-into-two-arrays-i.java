class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length; 
        int[] nums1 = new int[n];
        int[] nums2 = new int[n];

        nums1[0]=nums[0];
        int index1=0;
        nums2[0]=nums[1];
        int index2=0;

        for(int i=2;i<nums.length;i++){
            if(nums1[index1]>nums2[index2]){
                nums1[++index1]=nums[i];
            }else{
                nums2[++index2]=nums[i];
            }
        }

        int[] result  = new int[nums.length];

        int index3=0;
        for(int i=0;i<n;i++){
                if(nums1[i]!=0){
                    result[index3]=nums1[i];
                    index3++;
                }
        }

        for(int i=0;i<n;i++){
                if(nums2[i]!=0){
                    result[index3]=nums2[i];
                    index3++;
                }
        }

            return result;
    }
}