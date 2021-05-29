class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int j=1;
        for(int i=0;i<nums.length;i+=2){
            if(nums[i]%2==1){
                while(nums[j]%2==1){
                    j+=2;
                }
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
            }
        }
        return nums;
    }
}
